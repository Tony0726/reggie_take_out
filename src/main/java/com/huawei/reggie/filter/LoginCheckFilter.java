package com.huawei.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.huawei.reggie.common.BaseContext;
import com.huawei.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * date:2022/5/18 20:26
 * author:Tony
 * description:
 */

/**
 * 检查用户是否已经完成登陆
 */
// /*可以拦截所有请求，/**反而不能拦截请求只会显示No mapping，不是很理解
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1、获取本次请求的URI
        String requestURI = request.getRequestURI();

        log.info("拦截到请求：{}", request.getRequestURI());

        String[] urls = new String[] {
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login"

        };

        //2、判断本次请求是否需要处理
        boolean check = check(urls, requestURI);

        //3、如果不需要处理，则直接放行
        if (check) {
            log.info("本次请求不需要处理：{}", request.getRequestURI());
            filterChain.doFilter(request, response);
            return;
        }

        //4-1、判断登陆状态，如果已登陆，则直接放行
        if (request.getSession().getAttribute("employee") != null) {
            log.info("用户已登陆，用户id为：{}", request.getSession().getAttribute("employee"));

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

            filterChain.doFilter(request, response);
            return;
        }

        //4-2、判断登陆状态，如果已登陆，则直接放行
        if (request.getSession().getAttribute("user") != null) {
            log.info("用户已登陆，用户id为：{}", request.getSession().getAttribute("employee"));

            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);

            filterChain.doFilter(request, response);
            return;
        }

        log.info("用户未登陆");
        //5、如果未登陆则返回未登陆结果，通过输出流方式向客户端页面响应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;

        /**
         * “URI和URL都定义了资源是什么,但URL还定义了该如何访问资源。
         * URL是一种具体的URI,它是URI的一个子集,它不仅唯一标识资源,而且还提供了定位该资源的信息。
         * URI 是一种语义上的抽象概念,可以是绝对的,也可以是相对的,而URL则必须提供足够的信息来定位,是绝对的。”
         */
        //log.info("拦截到请求：{}", request.getRequestURI());
        //filterChain.doFilter(request, response);
    }

    /**
     * 路径匹配，检查本次请求是否需要放行
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }

}
