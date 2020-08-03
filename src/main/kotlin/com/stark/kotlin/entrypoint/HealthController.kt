package com.stark.kotlin.entrypoint

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController{
    @GetMapping("/ping")
    fun healtCheck(): String = "pong"
}