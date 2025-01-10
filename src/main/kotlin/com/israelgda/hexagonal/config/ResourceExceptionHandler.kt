package com.israelgda.hexagonal.config

import com.israelgda.hexagonal.application.core.exceptions.ClientErrorException
import com.israelgda.hexagonal.application.core.exceptions.CpfAlreadyRegisteredException
import com.israelgda.hexagonal.application.core.exceptions.NotFoundException
import com.israelgda.hexagonal.application.core.exceptions.responses.StandardError
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun customerNotFound(exception: NotFoundException): ResponseEntity<StandardError>{
        val status = HttpStatus.NOT_FOUND
        val error = StandardError(
            status = status.value(),
            error = "Entity not found",
            message = exception.message!!
        )

        return ResponseEntity
            .status(status)
            .body(error)
    }

    @ExceptionHandler(CpfAlreadyRegisteredException::class)
    fun cfpAlreadyRegistered(exception: CpfAlreadyRegisteredException): ResponseEntity<StandardError> {
        val status = HttpStatus.BAD_REQUEST
        val error = StandardError(
            status = status.value(),
            error = "Constraint violation",
            message = exception.message!!
        )

        return ResponseEntity
            .status(status)
            .body(error)
    }
    @ExceptionHandler(ClientErrorException::class)
    fun cfpAlreadyRegistered(exception: ClientErrorException): ResponseEntity<StandardError> {
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val error = StandardError(
            status = status.value(),
            error = "Client Response Error",
            message = exception.message!!
        )

        return ResponseEntity
            .status(status)
            .body(error)
    }

}