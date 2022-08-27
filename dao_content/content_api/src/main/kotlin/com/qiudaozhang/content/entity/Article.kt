package com.qiudaozhang.content.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.io.Serializable
import java.time.LocalDateTime
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author qiudaozhang
 * @since 2022-08-27
 */
@ApiModel(value = "Article对象", description = "")
class Article : Serializable {

        @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    var id: Long? = null

        @ApiModelProperty("标题")
    var title: String? = null

        @ApiModelProperty("Markdown内容")
    var md: String? = null

        @ApiModelProperty("渲染后的html内容")
    var html: String? = null

        @ApiModelProperty("UID")
    var uid: Long? = null

    var created: LocalDateTime? = null

    var updated: LocalDateTime? = null

    var deleted: Int? = null

    override fun toString(): String {
        return "Article{" +
        "id=" + id +
        ", title=" + title +
        ", md=" + md +
        ", html=" + html +
        ", uid=" + uid +
        ", created=" + created +
        ", updated=" + updated +
        ", deleted=" + deleted +
        "}"
    }
}
