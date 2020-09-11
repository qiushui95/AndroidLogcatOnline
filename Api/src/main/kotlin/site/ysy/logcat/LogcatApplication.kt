package site.ysy.logcat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LogcatApplication

fun main(args: Array<String>) {
    runApplication<LogcatApplication>(*args)
}
