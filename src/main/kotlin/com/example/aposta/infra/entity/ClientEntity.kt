package com.example.aposta.infra.entity

import com.example.aposta.domain.model.Cliente
import jakarta.persistence.*


@Entity
@Table(name = "client")
data class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id : Long = 0,
    val nome : String,
    val cpf : Long,
    val idade : Int,
    val dataNasc : String
)
     fun Cliente.toClientEntity() = ClientEntity(
        nome = name,
        cpf = cpf,
        idade = idade,
        dataNasc = dataNasc
    )

