package com.example.aposta.infra.rest

import com.example.aposta.application.port.input.ApostaUseCase
import com.example.aposta.domain.model.Aposta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.time.LocalDateTime

@RestController
@RequestMapping("/aposta")
class ApostaConntroller {

    @Autowired
    lateinit var apostaUseCase: ApostaUseCase

    @PostMapping("/{id_cliente}")
    fun save(@RequestParam valor : BigDecimal, @PathVariable("id_cliente") idCliente : Long) : ResponseEntity<Aposta> {
        val aposta = Aposta(valor = valor, idCliente = idCliente)
         apostaUseCase.saveAposta(aposta)
        return ResponseEntity.ok(aposta)
    }

}