package com.bolinho.uploadcsv.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import com.bolinho.uploadcsv.aws.Credentials;

import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class UploadS3 {

    private static final String BUCKET = "bucket-grupo8";

    public static void uploadFile(String fileName, InputStream inputStream)
            throws S3Exception, AwsServiceException, SdkClientException, IOException, InterruptedException,
            ExecutionException {
        S3Client client = S3Client.builder().region(Region.US_EAST_1).credentialsProvider(Credentials.getCredentials())
                .build();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();

        client.putObject(request, RequestBody.fromInputStream(inputStream, inputStream.available()));
        ProducerKafka.sendMessage(null, fileName);
    }
}
