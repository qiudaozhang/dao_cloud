package com.qiudaozhang.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
open class GatewayApp {
}

fun main(array: Array<String>) {
    runApplication<GatewayApp>(*array)
}