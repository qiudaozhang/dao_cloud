package com.qiudaozhang.manager.config

import cn.dev33.satoken.jwt.StpLogicJwtForSimple
import cn.dev33.satoken.stp.StpLogic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class JwtConfig {

    @Bean
    open fun getStpLogicJwt(): StpLogic? {
        return StpLogicJwtForSimple()
    }
}