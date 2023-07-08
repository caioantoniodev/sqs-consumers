package tech.example.springsqsconsumer.config;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.awspring.cloud.sqs.operations.TemplateAcknowledgementMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class AwsSQSConfig {

    private final SqsAsyncClient sqsAsyncClient;

    public AwsSQSConfig(SqsAsyncClient sqsAsyncClient) {
        this.sqsAsyncClient = sqsAsyncClient;
    }

    @Bean
    public SqsTemplate queueMessagingTemplate() {

        return SqsTemplate.builder()
            .sqsAsyncClient(this.sqsAsyncClient)
            .configure(options -> options
                    .acknowledgementMode(TemplateAcknowledgementMode.MANUAL)
                    .defaultQueue("example-queue.fifo"))
            .build();
    }
}
