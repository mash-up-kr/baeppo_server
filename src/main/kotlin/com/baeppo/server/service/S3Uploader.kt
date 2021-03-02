package com.baeppo.server.service

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import javax.annotation.PostConstruct

@Service
class S3Uploader() {
    private lateinit var s3Client: AmazonS3

    @Value("cloud.aws.credentials.accessKey")
    private val accessKey: String? = null

    @Value("cloud.aws.credentials.secretKey")
    private val secretKey: String? = null

    @Value("cloud.aws.s3.bucket")
    private val bucket: String? = null

    @Value("cloud.aws.region.static")
    private val region: String? = null

    @PostConstruct
    fun setS3Client() {
        val credentials = BasicAWSCredentials(this.accessKey, this.secretKey)

        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(AWSStaticCredentialsProvider(credentials))
                .withRegion(this.region)
                .build()
    }

    fun upload(file: MultipartFile) : String {
        val fileName = file.originalFilename

        s3Client.putObject(PutObjectRequest(bucket, fileName, file.inputStream, null)
                .withCannedAcl(CannedAccessControlList.PublicRead))
        return s3Client.getUrl(bucket, fileName).toString()
    }

}