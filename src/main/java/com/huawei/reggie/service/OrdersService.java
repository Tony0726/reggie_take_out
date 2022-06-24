package com.huawei.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huawei.reggie.entity.Orders;

/**
 * date:2022/6/23 21:34
 * author:Tony
 * description:
 */
public interface OrdersService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit (Orders orders);
}
