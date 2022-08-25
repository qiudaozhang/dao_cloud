package com.qiudaozhang.manager.controller;

import com.qiudaozhang.core.common.consts.StringConst
import com.qiudaozhang.entity.Account
import com.qiudaozhang.mic.AccountMic
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.apache.dubbo.config.annotation.DubboReference
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
    // 代码要放类里面，不然不会生效的
//    @Resource
//    lateinit var accountService: IAccountService


    //    @DubboRe
    @DubboReference
    lateinit var accountMic: AccountMic

//
//    @PostMapping
//    @ApiOperation(StringConst.CREATE)
//    fun create(account: Account) {
//        accountService.save(account)
//    }
//
//
//    @PutMapping
//    @ApiOperation(StringConst.UPDATE)
//    fun update(account: Account) {
//        val one = accountService.getById(account.id)
//        one.updated = LocalDateTime.now()
//        one.username = account.username
//        accountService.updateById(one)
//    }
//
//    @GetMapping("{id}")
//    @ApiOperation(StringConst.GET)
//    fun get(@PathVariable("id") id: Long): Account? {
//        return accountService.getById(id)
//    }
//
//    @DeleteMapping("{id}")
//    @ApiOperation(StringConst.DELETE)
//    fun delete(@PathVariable("id") id: Long) {
//        accountService.removeById(id)
//    }


    @GetMapping("do/getAll")
    @ApiOperation(StringConst.GET_ALL)
    fun getAll(): List<Account> {
        return accountMic.getAll()
    }


//    @GetMapping("do/search")
//    @ApiOperation(StringConst.SEARCH)
//    fun search(accountSearch: AccountSearch): List<Account> {
//        return accountService.ktQuery().like(Account::username, accountSearch.username).list()
//    }
}


