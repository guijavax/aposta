package com.example.aposta.domain.adapters.primary

import com.example.aposta.application.port.input.ClientUseCase
import com.example.aposta.domain.model.Cliente
import org.springframework.stereotype.Service

@Service
class ClientAdapter : ClientUseCase {

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