package com.huawei.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huawei.reggie.entity.Employee;
import com.huawei.reggie.mapper.EmployeeMapper;
import com.huawei.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * date:2022/5/18 16:34
 * author:Tony
 * description:
 */
@Service
@Slf4j
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
