package com.example.aposta.infra.advice

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class HandleAdvice : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val listGetErrors = ex.allErrors
        val listErrors = mutableListOf<String>()
        listGetErrors?.map {
            it?.let {error ->
                listErrors.add("Mensagem: ${error.defaultMessage}")
            }
        }
        val responseBody = mutableMapOf<String, MutableList<String>>()
        responseBody["Erros:"] = listErrors
        return ResponseEntity.badRequest().body(responseBody)
    }
}