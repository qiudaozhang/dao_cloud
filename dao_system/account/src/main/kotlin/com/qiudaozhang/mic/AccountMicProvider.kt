package com.qiudaozhang.mic

import cn.dev33.satoken.secure.SaSecureUtil
import com.qiudaozhang.core.common.exceptions.BizExp
import com.qiudaozhang.core.common.exceptions.CustomException
import com.qiudaozhang.entity.Account
import com.qiudaozhang.service.IAccountService
import org.apache.dubbo.config.annotation.DubboService
import org.springframework.beans.factory.annotation.Value
import javax.annotation.Resource

@DubboService // 服务提供者
class AccountMicProvider : AccountMic {

    @Resource
    lateinit var accountService: IAccountService

    // kotlin需要在前面加一个反斜杠
    @Value("\${privateKey}")
    private val privateKey: String? = null

    @Value("\${publicKey}")
    private val publicKey: String? = null

    override fun getAll(): List<Account> {
        return accountService.list()
    }

    override fun create(account: Account) {
        // 需要加密
        account.password = SaSecureUtil.rsaEncryptByPublic(publicKey, account.password)
        accountService.save(account)
    }

    override fun login(account: Account): Account {
        val one = accountService.ktQuery().eq(Account::username, account.username).one()
        if (one != null) {
            val dePass = SaSecureUtil.rsaDecryptByPrivate(privateKey, one.password)
            if (account.password == dePass) {
                return one
            }
        }
        throw BizExp.USERNAME_PASSWORD_WRONG
//        throw BizExp(1001,"用户或密码错误")
//        throw BizExp(1001,"用户名获密码错误")
    }

    override fun checkHasUsername(username: String): Boolean {
        return accountService.ktQuery().eq(Account::username, username).count() > 0
    }
}