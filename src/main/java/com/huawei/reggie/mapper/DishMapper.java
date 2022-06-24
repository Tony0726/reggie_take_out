package com.huawei.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * date:2022/6/19 10:12
 * author:Tony
 * description:菜品Mapper
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
