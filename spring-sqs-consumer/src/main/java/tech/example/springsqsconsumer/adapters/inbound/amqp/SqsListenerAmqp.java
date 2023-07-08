package tech.example.springsqsconsumer.adapters.inbound.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import io.awspring.cloud.sqs.annotation.SqsListener;

@Component
public class SqsListenerAmqp {

   private static final Logger LOGGER = LoggerFactory.getLogger(SqsListenerAmqp.class);

    @SqsListener(value = "example-queue.fifo")
    public void listener(String message) {

        LOGGER.info("Message received from SQS is: {} ", message);
    }
}
