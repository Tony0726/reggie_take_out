package com.huawei.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * date:2022/5/18 16:30
 * author:Tony
 * description:
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
