package com.example.aposta.infra.entity

import com.example.aposta.domain.model.Cliente
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern


@Entity
@Table(name = "client")
data class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    val id : Long = 0,
    val nome : String,
    val cpf : Long,
    val idade : Int,
    val dataNasc : String,

    @OneToOne(mappedBy =  "cliente", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JsonIgnore
    @NotNull
    val apostaEntity: ApostaEntity? = null

)
     fun Cliente.toClientEntity() : ClientEntity {
         var   cpfConvert = cpf.replace(".", "").replace("-", "")
         return ClientEntity(
             nome = name,
             cpf = cpfConvert.toLong(),
             idade = idade,
             dataNasc = dataNasc
         )
     }


