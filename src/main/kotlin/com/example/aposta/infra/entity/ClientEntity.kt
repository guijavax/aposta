package com.example.aposta.infra.entity

import jakarta.persistence.*


@Entity
@Table(name = "client")
data class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column

    val id : Long,
    val nome : String,
    val cpf : Long,
    val idade : Int,
    val dataNasc : String
)
