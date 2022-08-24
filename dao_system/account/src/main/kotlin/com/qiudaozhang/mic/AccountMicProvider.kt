package com.qiudaozhang.mic

import com.qiudaozhang.entity.Account
import com.qiudaozhang.service.IAccountService
import org.apache.dubbo.config.annotation.DubboService
import javax.annotation.Resource

@DubboService // 服务提供者
class AccountMicProvider : AccountMic {

    @Resource
    lateinit var accountService: IAccountService

    override fun getAll(): List<Account> {
        return accountService.list()
    }
}