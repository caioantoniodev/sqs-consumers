package tech.example.springsqsconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

@Configuration
public class AwsConfig {

    @Bean
    public AwsCredentialsProvider awsCredentialsProvider() {
        return new CustomCredentialsProvider("fakeAwsAccessKey", "fakeAwsAcessSecret");
    }
}
