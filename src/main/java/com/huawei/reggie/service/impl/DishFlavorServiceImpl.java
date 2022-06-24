package com.huawei.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huawei.reggie.entity.DishFlavor;
import com.huawei.reggie.mapper.DishFlavorMapper;
import com.huawei.reggie.mapper.DishMapper;
import com.huawei.reggie.service.DishFlavorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * date:2022/6/19 16:57
 * author:Tony
 * description:
 */
@Service
@Slf4j
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService{
}
