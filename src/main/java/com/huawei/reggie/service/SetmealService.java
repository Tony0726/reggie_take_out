package com.huawei.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huawei.reggie.dto.SetmealDto;
import com.huawei.reggie.entity.Setmeal;

import java.util.List;

/**
 * date:2022/6/19 10:15
 * author:Tony
 * description:套餐Mapper
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时更新两张表
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    public void removeWithDish(List<Long> ids);
}
