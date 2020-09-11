package site.ysy.logcat.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import site.ysy.logcat.model.LogInfo

@Mapper
interface LogMapper : BaseMapper<LogInfo> {
}