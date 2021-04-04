package com.baeppo.server.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.baeppo.server.config.properties.S3Properties
import com.baeppo.server.util.Logger
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile


@Service
class S3Uploader(
    private val s3Client: AmazonS3,
    private val s3Properties: S3Properties
) {

    companion object : Logger

    fun upload(file: MultipartFile): String {
        return runCatching {
            val fileName = file.originalFilename

            s3Client.putObject(
                PutObjectRequest(s3Properties.s3.bucket,
                    fileName,
                    file.inputStream,
                    ObjectMetadata().apply {
                        this.contentLength = file.size
                    })
                    .withCannedAcl(CannedAccessControlList.PublicRead)
            )

            s3Client.getUrl(s3Properties.s3.bucket, fileName).toString()
        }.onSuccess {
            log.debug("S3 upload path -> $it")
        }.onFailure {
            handleS3UploadFails(it)
        }.getOrThrow()
    }

    private fun handleS3UploadFails(e: Throwable) {
        log.error("S3 upload fail -> ${e.message}")
    }
}