package com.qiudaozhang.gateway.config

import cn.dev33.satoken.stp.StpInterface
import org.springframework.stereotype.Component

@Component
class StpInterfaceImpl:StpInterface {
    override fun getPermissionList(loginId: Any?, loginType: String?): MutableList<String> {
        return mutableListOf("admin")
    }

    override fun getRoleList(loginId: Any?, loginType: String?): MutableList<String> {
        return mutableListOf("admin")
    }
}