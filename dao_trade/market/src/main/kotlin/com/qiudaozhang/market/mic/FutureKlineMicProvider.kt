package com.qiudaozhang.market.mic

import com.qiudaozhang.market.entity.FutureKline
import com.qiudaozhang.market.service.FutureKlineService
import org.apache.dubbo.config.annotation.DubboService
import javax.annotation.Resource

/**
 * 合约K线微服务提供者
 * 只作为一个基本的演示
 * @since 2022-8-27
 * @author qiudaozhang
 */
@DubboService
class FutureKlineMicProvider : FutureKlineMic {

    @Resource
    lateinit var futureKlineService: FutureKlineService

    override fun findLastN(s: String, i: String, limit: Int): List<FutureKline> {
        return futureKlineService.ktQuery().eq(FutureKline::s, s).eq(FutureKline::i, i)
            .orderByDesc(FutureKline::t).last(" limit $limit").list()
    }
}