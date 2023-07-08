package tech.example.springsqsconsumer.config;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

public class CustomCredentialsProvider implements AwsCredentialsProvider {

    private final AwsCredentials awsCredentials;

    public CustomCredentialsProvider(String accessKey, String secretKey) {
        this.awsCredentials = AwsBasicCredentials.create(accessKey, secretKey);
    }

    @Override
    public AwsCredentials resolveCredentials() {
        return awsCredentials;
    }
}
