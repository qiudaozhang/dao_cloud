package com.qiudaozhang.mic

import com.qiudaozhang.entity.Account

interface AccountMic {

    fun getAll(): List<Account>

    fun create(account: Account)
    fun login(account: Account): Account

    fun checkHasUsername(username: String): Boolean
}