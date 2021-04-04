package com.baeppo.server.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import com.baeppo.server.config.properties.S3Properties
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class S3Uploader(
    private val s3Client: AmazonS3,
    private val s3Properties: S3Properties
) {
    fun upload(file: MultipartFile) : String {
        val fileName = file.originalFilename

        s3Client.putObject(PutObjectRequest(s3Properties.s3.bucket, fileName, file.inputStream, null)
                .withCannedAcl(CannedAccessControlList.PublicRead))
        return s3Client.getUrl(s3Properties.s3.bucket, fileName).toString()
    }
}