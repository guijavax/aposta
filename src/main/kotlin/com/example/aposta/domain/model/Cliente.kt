package com.example.aposta.domain.model

import com.example.aposta.infra.entity.ClientEntity


data class Cliente(
    val name : String,
    val idade : Int,
    val cpf : Long,
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
        cpf = cpf,
        dataNasc = dataNasc
    )




