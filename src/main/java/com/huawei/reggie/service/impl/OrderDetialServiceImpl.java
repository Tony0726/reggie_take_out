package com.huawei.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huawei.reggie.entity.OrderDetail;
import com.huawei.reggie.mapper.OrderDetailMapper;
import com.huawei.reggie.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * date:2022/6/23 21:39
 * author:Tony
 * description:
 */
@Service
@Slf4j
public class OrderDetialServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
