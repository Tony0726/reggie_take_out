package com.huawei.reggie.common;

/**
 * date:2022/6/19 10:58
 * author:Tony
 * description:自定义业务异常类
 */
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
