package com.huawei.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huawei.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * date:2022/6/21 19:12
 * author:Tony
 * description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
