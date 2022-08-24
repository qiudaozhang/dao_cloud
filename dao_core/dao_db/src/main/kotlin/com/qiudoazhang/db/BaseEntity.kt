package com.qiudoazhang.db

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.qiudaozhang.core.common.model.DeletedModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime


/**
 * 基础实体类
 */
open class BaseEntity : DeletedModel(){

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    var id: Long? = null

    @ApiModelProperty("创建时间")
    var created: LocalDateTime? = null

    @ApiModelProperty("更新时间")
    var updated: LocalDateTime? = null

//    @ApiModelProperty("逻辑删除 1 删除 0 未删除")
//    var deleted: Int? = null

}