package com.qiudaozhang.gateway.config

import cn.dev33.satoken.reactor.filter.SaReactorFilter
import cn.dev33.satoken.util.SaResult
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * token配置
 */
@Configuration
open class SaTokenConfigure {
    @Bean
    open fun getSaReactorFilter(): SaReactorFilter? {
        return SaReactorFilter() // 指定 [拦截路由]
            .addInclude("/**") // 指定 [放行路由]
            .addExclude("/favicon.ico") // 指定[认证函数]: 每次请求执行
            .addExclude("/admin/api/account/**")
            .setAuth { obj: Any? -> println("---------- sa全局认证") } // 指定[异常处理函数]：每次[认证函数]发生异常时执行此函数
            .setError { e: Throwable ->
                println("---------- sa全局异常 ")
                SaResult.error(e.message)
            }
    }


}