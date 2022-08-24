package com.qiudaozhang.service.impl;

import com.qiudaozhang.entity.Account;
import com.qiudaozhang.mapper.AccountMapper;
import com.qiudaozhang.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiudaozhang
 * @since 2022-08-24
 */
@Service
open class AccountServiceImpl : ServiceImpl<AccountMapper, Account>(), IAccountService {

}
