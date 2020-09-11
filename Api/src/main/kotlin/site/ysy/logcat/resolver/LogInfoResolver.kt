package site.ysy.logcat.resolver

import org.springframework.context.annotation.Configuration
import org.springframework.core.MethodParameter
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import site.ysy.logcat.model.LogInfo

@Configuration
class LogInfoResolver : HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.parameterType == LogInfo::class.java
    }

    override fun resolveArgument(parameter: MethodParameter, mavContainer: ModelAndViewContainer?, webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory?): Any? {
        val tag = webRequest.getParameter("tag") ?: throw IllegalArgumentException("未发现tag参数")
        val message = webRequest.getParameter("message") ?: throw IllegalArgumentException("未发现message参数")
        val phoneTime = webRequest.getParameter("phoneTime")?.toLong()
                ?: throw IllegalArgumentException("未发现phoneTime参数")
        return LogInfo(tag = tag, message = message, phoneTime = phoneTime,serverTime = System.currentTimeMillis())
    }
}