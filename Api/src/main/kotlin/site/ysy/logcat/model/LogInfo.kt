package site.ysy.logcat.model

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName

@TableName(value = "LogInfo")
data class LogInfo(
        @TableId(value = "row", type = IdType.AUTO)
        val row: Int = 0,
        @TableField("tag")
        val tag: String,
        @TableField("message")
        val message: String,
        @TableField("phone_time")
        val phoneTime: Long,
        @TableField("server_time")
        val serverTime: Long = 0
) {
    fun updateServerTime() = copy(serverTime = System.currentTimeMillis())
}