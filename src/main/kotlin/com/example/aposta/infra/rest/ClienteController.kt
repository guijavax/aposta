package com.example.aposta.infra.rest

import com.example.aposta.application.port.input.ClientUseCase
import com.example.aposta.domain.model.Cliente
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cliente")
class ClienteController {

    @Autowired
    lateinit var clienteUseCase : ClientUseCase

    @PostMapping
    fun saveCliente(@RequestBody @Valid cliente: Cliente) : ResponseEntity<String> {
        return  ResponseEntity.ok(clienteUseCase.saveCliente(cliente).toString())
    }

    @GetMapping("/findAll")
    fun findAll() : ResponseEntity<List<Cliente>> {
        return ResponseEntity.ok(clienteUseCase.findAll())
    }
}