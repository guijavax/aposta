package com.example.aposta.domain.adapters.secondary.aws

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.PutObjectRequest
import com.example.aposta.application.port.output.S3ClientUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.io.FileOutputStream

@Service
class S3Adapter :  S3ClientUseCase {

    @Autowired
    lateinit var amazonS3 : AmazonS3
    override fun sendS3() {
        val file = File("teste.txt")
        val fileOut = FileOutputStream(file)
        fileOut.write("teste".toByteArray())

        fileOut.flush()
        fileOut.close()
        amazonS3.putObject(PutObjectRequest("bucket", "teste", file))

    }


}