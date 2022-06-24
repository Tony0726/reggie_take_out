package com.huawei.reggie.dto;

import com.huawei.reggie.entity.Setmeal;
import com.huawei.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
