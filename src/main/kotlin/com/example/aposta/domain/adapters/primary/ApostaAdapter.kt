package com.example.aposta.domain.adapters.primary

import com.example.aposta.application.port.input.ApostaUseCase
import com.example.aposta.application.port.output.S3ClientUseCase
import com.example.aposta.domain.model.Aposta
import com.example.aposta.infra.entity.toClienteEntity
import com.example.aposta.infra.repository.ApostaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApostaAdapter : ApostaUseCase {

    @Autowired
    lateinit var repository: ApostaRepository

    @Autowired
    lateinit var s3ClientUseCase: S3ClientUseCase

    override fun saveAposta(aposta: Aposta) {
        val apostaEntity = aposta.toClienteEntity()
        s3ClientUseCase.sendS3()
        repository.save(apostaEntity)

    }
}