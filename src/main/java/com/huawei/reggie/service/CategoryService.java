package com.huawei.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huawei.reggie.entity.Category;

/**
 * date:2022/6/17 21:46
 * author:Tony
 * description:
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
