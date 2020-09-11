package site.ysy.logcat.service

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import site.ysy.logcat.mapper.LogMapper
import site.ysy.logcat.model.LogInfo
import javax.annotation.Resource

@Service
class LogService {

    @Resource
    private lateinit var logMapper: LogMapper

    suspend fun insert(@RequestBody logInfo: LogInfo): Int {
        logMapper.insert(logInfo)
        return logMapper.selectCount(QueryWrapper())
    }
}