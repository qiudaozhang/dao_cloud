package com.qiudaozhang.market.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable
import java.math.BigDecimal

/**
 * <p>
 *
 * </p>
 *
 * @author qiudaozhang
 * @since 2022-08-27
 */
@TableName("future_kline")
@ApiModel(value = "FutureKline对象", description = "")
class FutureKline : Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    var id: Long? = null

    @ApiModelProperty("开盘时间")
    var t: Long? = null

    @ApiModelProperty("币对")
    var s: String? = null

    @ApiModelProperty("周期")
    var i: String? = null

    @ApiModelProperty("开盘价格")
    var o: BigDecimal? = null

    @ApiModelProperty("收盘价格")
    var c: BigDecimal? = null

    @ApiModelProperty("最高价")
    var h: BigDecimal? = null

    @ApiModelProperty("最低价")
    var l: BigDecimal? = null

    @ApiModelProperty("成交量")
    var v: BigDecimal? = null

    @ApiModelProperty("交易额")
    var q: BigDecimal? = null

    override fun toString(): String {
        return "FutureKline{" +
                "id=" + id +
                ", t=" + t +
                ", s=" + s +
                ", i=" + i +
                ", o=" + o +
                ", c=" + c +
                ", h=" + h +
                ", l=" + l +
                ", v=" + v +
                ", q=" + q +
                "}"
    }
}
