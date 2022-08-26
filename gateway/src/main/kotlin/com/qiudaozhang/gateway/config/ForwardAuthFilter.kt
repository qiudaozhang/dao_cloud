package com.qiudaozhang.gateway.config

import cn.dev33.satoken.id.SaIdUtil
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono


/**
 * rpc框架传递需要
 */
@Component
class ForwardAuthFilter : GlobalFilter {
    override fun filter(exchange: ServerWebExchange?, chain: GatewayFilterChain?): Mono<Void> {
        val newRequest: ServerHttpRequest = exchange!!.request.mutate().header(SaIdUtil.ID_TOKEN, SaIdUtil.getToken())
            .build()
        val newExchange = exchange!!.mutate().request(newRequest).build()
        return chain!!.filter(newExchange)

    }
}