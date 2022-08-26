package com.qiudaozhang.core.common.exceptions

import java.lang.RuntimeException

open class BizExp(c: Int, message: String?) : RuntimeException(message) {
    val code: Int = c

    companion object {
        // 确保code不要重复
        val USERNAME_PASSWORD_WRONG = BizExp(1001, "用户名或密码错误")
    }
}