package com.huawei.reggie.controller;

import com.huawei.reggie.common.R;
import com.huawei.reggie.entity.Orders;
import com.huawei.reggie.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date:2022/6/23 21:40
 * author:Tony
 * description:订单
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 用户下单
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit (@RequestBody Orders orders) {
        log.info("订单数据:{}",orders);
        ordersService.submit(orders);
        return R.success("下单成功");
    }

}
