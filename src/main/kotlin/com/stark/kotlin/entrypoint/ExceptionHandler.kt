package com.stark.kotlin.entrypoint

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ExceptionHandler {

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ExceptionHandler::class.java)
    }

    @ExceptionHandler(Exception::class)
    fun handlerError(error: Exception): ResponseEntity<String>{
        val errorMessage = Error(error.message)
        LOG.info("${errorMessage}")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage.message)
    }
}