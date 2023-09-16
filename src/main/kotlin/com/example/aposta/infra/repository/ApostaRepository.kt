package com.example.aposta.infra.repository

import com.example.aposta.infra.entity.ApostaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ApostaRepository : JpaRepository<ApostaEntity, Long> {
}