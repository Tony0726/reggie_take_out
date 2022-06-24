package com.huawei.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huawei.reggie.common.CustomException;
import com.huawei.reggie.entity.Category;
import com.huawei.reggie.entity.Dish;
import com.huawei.reggie.entity.Setmeal;
import com.huawei.reggie.mapper.CategoryMapper;
import com.huawei.reggie.service.CategoryService;
import com.huawei.reggie.service.DishService;
import com.huawei.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * date:2022/6/17 21:47
 * author:Tony
 * description:
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements  CategoryService{

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据分类id进行查询
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishLambdaQueryWrapper);

        //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        if (count1>0) {
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        //查询当前分类是否关联了套餐，如果已经关联，跑出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2 > 0) {
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }

        //否则正常删除
        super.removeById(id);
    }
}
