package com.example.aposta.domain.model

import com.example.aposta.infra.entity.ApostaEntity

import com.example.aposta.infra.entity.ClienteEntity
import java.math.BigDecimal
import java.time.LocalDateTime

data class Aposta(
    val valor : BigDecimal,
    val dataAposta : LocalDateTime = LocalDateTime.now(),
    val idCliente: Long
)

fun ApostaEntity.toCliente() : Aposta {
    return Aposta(
        valor = valor,
        idCliente = idCliente,
        dataAposta = dataAposta
    )
}

