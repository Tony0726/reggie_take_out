package com.huawei.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huawei.reggie.entity.User;
import com.huawei.reggie.mapper.UserMapper;
import com.huawei.reggie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * date:2022/6/21 19:13
 * author:Tony
 * description:
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
