package com.qiudaozhang.market.mic

import com.qiudaozhang.market.entity.FutureKline

interface FutureKlineMic {

    fun findLastN(s:String,i:String,limit:Int = 500):List<FutureKline>

}