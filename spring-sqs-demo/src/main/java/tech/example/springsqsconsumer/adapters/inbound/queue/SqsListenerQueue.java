package tech.example.springsqsconsumer.adapters.inbound.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.awspring.cloud.sqs.annotation.SqsListener;

@Component
public class SqsListenerQueue {

   private static final Logger LOGGER = LoggerFactory.getLogger(SqsListenerQueue.class);

    @SqsListener(value = "${sqs.queue-name}")
    public void listener(String message) {

        LOGGER.info("Message received from SQS is: {} ", message);
    }
}
