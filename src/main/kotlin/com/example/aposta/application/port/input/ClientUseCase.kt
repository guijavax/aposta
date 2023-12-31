package com.example.aposta.application.port.input

import com.example.aposta.domain.model.Cliente
import com.example.aposta.infra.entity.ClienteEntity

interface ClientUseCase {

    fun saveCliente(cliente: Cliente) : ClienteEntity

    fun deletar(id : Int)

    fun search(cpf : String) : Cliente

    fun atualiza(client : Cliente)

    fun findAll() : List<Cliente>
}