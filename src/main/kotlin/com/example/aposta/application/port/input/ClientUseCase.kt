package com.example.aposta.application.port.input

import com.example.aposta.domain.model.Cliente

interface ClientUseCase {

    fun saveCliente(cliente: Cliente)

    fun deletar(id : Int)

    fun search(cpf : String) : Cliente

    fun atualiza(client : Cliente)


}