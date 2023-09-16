package com.example.aposta.infra.entity

import com.example.aposta.domain.model.Cliente
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull



@Table(name = "client")
@Entity
data class ClienteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    val id : Long = 0,
    val nome : String,
    val cpf : Long,
    val idade : Int,
    val dataNasc : String,

)
fun Cliente.toClienteEntity() : ClienteEntity {
    var   cpfConvert = cpf.replace(".", "").replace("-", "")
    return ClienteEntity(
        nome = name,
        cpf = cpfConvert.toLong(),
        idade = idade,
        dataNasc = dataNasc
    )
}


