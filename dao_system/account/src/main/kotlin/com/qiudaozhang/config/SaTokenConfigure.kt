package com.qiudaozhang.config

import cn.dev33.satoken.context.SaHolder
import cn.dev33.satoken.filter.SaServletFilter
import cn.dev33.satoken.id.SaIdUtil
import cn.dev33.satoken.util.SaResult
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


/**
 * 子服务需要
 */
@Configuration
open class SaTokenConfigure : WebMvcConfigurer {

    @Bean
    open fun getSaServletFilter(): SaServletFilter? {
        return SaServletFilter()
            .addInclude("/**")
            .addExclude("/favicon.ico")
            .addExclude("/**/login")
            .setAuth { obj: Any? ->
                // 校验 Id-Token 身份凭证     —— 以下两句代码可简化为：SaIdUtil.checkCurrentRequestToken();
                println("获取 ID  token")
                val token = SaHolder.getRequest().getHeader(SaIdUtil.ID_TOKEN)
                SaIdUtil.checkToken(token)
            }
            .setError { e: Throwable -> SaResult.error(e.message) }
    }
}