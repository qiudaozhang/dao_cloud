package com.qiudaozhang.gateway

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo(scanBasePackages = ["com.qiudaozhang"])
open class GatewayApp {
}

fun main(array: Array<String>) {
    runApplication<GatewayApp>(*array)
}