package site.ysy.logcat.controller

import kotlinx.coroutines.reactor.mono
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import site.ysy.logcat.model.LogInfo
import site.ysy.logcat.service.LogService

@RestController
@RequestMapping("upload")
class UploadLogController {

    @Autowired
    private lateinit var logService: LogService

    @PostMapping
    fun postLog(@RequestBody logInfo: LogInfo): Mono<Int> {
        return mono {
            logService.insert(logInfo.updateServerTime())
        }
    }
}