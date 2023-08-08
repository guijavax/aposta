package com.example.aposta.infra.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(name = "client")
data class ClientEntity(
    val id : Int,
    val nome : String,
    val cpf : Long,
    val idade : Int,
    val dataNasc : String
)
