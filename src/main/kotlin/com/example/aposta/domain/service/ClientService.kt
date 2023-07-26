package com.example.aposta.domain.service

import com.example.aposta.application.port.input.CreateClientUseCase
import com.example.aposta.application.port.input.DeleteClientUseCase
import com.example.aposta.application.port.input.FindClientUseCase
import com.example.aposta.application.port.input.UpdateClienteUseCase
import com.example.aposta.domain.model.Cliente
import org.springframework.stereotype.Service

@Service
class ClientService : CreateClientUseCase, DeleteClientUseCase, UpdateClienteUseCase, FindClientUseCase {

    override fun saveCliente(cliente: Cliente) {
        TODO("Not yet implemented")
    }

    override fun deletar(id: Int) {
        TODO("Not yet implemented")
    }

    override fun search(cpf: String): Cliente {
        TODO("Not yet implemented")
    }

    override fun atualiza(client: Cliente) {
        TODO("Not yet implemented")
    }
}