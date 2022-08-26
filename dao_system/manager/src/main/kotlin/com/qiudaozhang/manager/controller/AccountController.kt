package com.qiudaozhang.manager.controller;

import cn.dev33.satoken.stp.SaLoginConfig
import cn.dev33.satoken.stp.SaTokenInfo
import cn.dev33.satoken.stp.StpUtil
import com.qiudaozhang.core.common.consts.StringConst
import com.qiudaozhang.entity.Account
import com.qiudaozhang.mic.AccountMic
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.apache.dubbo.config.annotation.DubboReference
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.RuntimeException

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qiudaozhang
 * @since 2022-08-24
 */
@RestController
@RequestMapping("/api/account")
@Api(tags = ["账户"])
class AccountController {


    @DubboReference
    lateinit var accountMic: AccountMic


    @PostMapping
    @ApiOperation(StringConst.CREATE)
    fun create(account: Account) {

        val has = accountMic.checkHasUsername(account.username)
        if (has) {
            throw RuntimeException("用户已经在")
        }

        accountMic.create(account)
    }

    @PostMapping("do/login")
    @ApiOperation("登录")
    fun login(account: Account): SaTokenInfo {
        val account = accountMic.login(account)
        val model = SaLoginConfig.setExtra("phone", account.username)
        StpUtil.login(account.id, model)
        return StpUtil.getTokenInfo()
    }

    @GetMapping("do/getAll")
    @ApiOperation(StringConst.GET_ALL)
    fun getAll(): List<Account> {
        val data = accountMic.getAll()
        // 密码要置空
        data.forEach { a -> a.password = StringConst.EMPTY }
        return data
    }


}


