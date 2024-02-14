package tech.example.springsqsconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Configuration
public class SqsConfig {

    @Value("${sqs.base-url}")
    private String baseUrl;

    @Value("${sqs.port}")
    private String port;

    @Bean
    public SqsAsyncClient sqsAsyncClient() {

        return SqsAsyncClient.builder()
                .endpointOverride(URI.create(String.format("%s:%s", baseUrl, port)))
                .region(Region.SA_EAST_1)
                .build();
    }
}
