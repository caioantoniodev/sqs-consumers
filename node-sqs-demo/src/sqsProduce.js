import { sqs } from "./sqsConfig.js";
import { message } from './message.js';

const messageParams = {
    MessageBody: JSON.stringify(message),
    QueueUrl: sqs.getQueueUrl
}

sqs.sendMessage(messageParams, (err, data) => {
    if (err) {
        console.error('Error sending message: ', err);
    } else {
        console.log('Message sent successfully!', data.MessageId);
    }
})