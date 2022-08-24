package com.qiudaozhang.controller;

import com.qiudaozhang.core.common.consts.StringPool
import com.qiudaozhang.entity.Account
import com.qiudaozhang.request.AccountSearch
import com.qiudaozhang.service.IAccountService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.annotation.Resource

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
    @Resource
    lateinit var accountService: IAccountService


    @PostMapping
    @ApiOperation(StringPool.CREATE)
    fun create(account: Account) {
        accountService.save(account)
    }


    @PutMapping
    @ApiOperation(StringPool.UPDATE)
    fun update(account: Account) {
        val one = accountService.getById(account.id)
        one.updated = LocalDateTime.now()
        one.username = account.username
        accountService.updateById(one)
    }

    @GetMapping("{id}")
    @ApiOperation(StringPool.GET)
    fun get(@PathVariable("id") id: Long): Account {
        return accountService.getById(id)
    }

    @DeleteMapping("{id}")
    @ApiOperation(StringPool.DELETE)
    fun delete(@PathVariable("id") id: Long) {
        accountService.removeById(id)
    }


    @GetMapping("do/getAll")
    @ApiOperation(StringPool.GET_ALL)
    fun getAll(): List<Account> {
        val data = accountService.list()
        return data
    }


    @GetMapping("do/search")
    @ApiOperation(StringPool.SEARCH)
    fun search(accountSearch: AccountSearch): List<Account> {
        return accountService.ktQuery().like(Account::username, accountSearch.username).list()
    }
}


