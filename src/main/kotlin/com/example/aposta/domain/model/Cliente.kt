package com.example.aposta.domain.model

import com.example.aposta.infra.entity.ClientEntity
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Pattern


data class Cliente(
    val name : String,

    @field:Min(value=18, message = "Para usar o nosso serviço tem que ser maior de idade!")
    val idade : Int,

    @field:Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "Cpf no formato Inválido!")
    val cpf : String,

    @field:Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data Inválida!")
    val dataNasc : String
) {
    override fun toString() =
         "{ " +
                "Nome: $name," +
                "Idade: $idade," +
                "DataNasc: $dataNasc" +
                 "}"

}
    fun ClientEntity.toCliente() = Cliente(
        name = nome,
        idade = idade,
        cpf = cpf.toString(),
        dataNasc = dataNasc
    )




