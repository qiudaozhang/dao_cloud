package com.qiudaozhang.market

import com.qiudaozhang.market.mapper.FutureKlineMapper
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
@MapperScan(basePackageClasses = [FutureKlineMapper::class])
open class MarketApp {
}

fun main(array: Array<String>) {
    runApplication<MarketApp>(*array)
}