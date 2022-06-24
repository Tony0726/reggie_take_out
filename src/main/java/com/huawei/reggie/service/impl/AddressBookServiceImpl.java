package com.huawei.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huawei.reggie.entity.AddressBook;
import com.huawei.reggie.mapper.AddressBookMapper;
import com.huawei.reggie.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * date:2022/6/21 20:10
 * author:Tony
 * description:
 */
@Service
@Slf4j
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
