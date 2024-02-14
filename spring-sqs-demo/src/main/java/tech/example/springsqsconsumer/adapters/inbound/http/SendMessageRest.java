package tech.example.springsqsconsumer.adapters.inbound.http;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendMessageRest {

    private final SqsTemplate sqsTemplate;

    @Value("${sqs.queue-url}")
    private String queueUrl;

    public SendMessageRest(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }

    @PostMapping
    public void send() {
        var result =  sqsTemplate.send(queueUrl, "tech example message");
    }
}
