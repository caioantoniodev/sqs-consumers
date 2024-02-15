import { sqs } from "./sqsConfig.js"

const receiveParams = {
    MessageAttributeNames: [
        "All"
    ],
    QueueUrl: sqs.getQueueUrl,
}

sqs.receiveMessage(receiveParams, (err, data) => {
    if (err) {
        console.error("Error receiving message: ", err);
    } else {
        if (data.Messages) {
            data.Messages?.forEach(message => {
                console.log("Message received: ", message.ReceiptHandle);
                console.log("Message ID: ", message.MessageId);
                console.log("Message content: ", message.Body)
                console.log("Message attributes: ", message.MessageAttributes);
                removeFromQueue(message);
            })
        } else {
            console.log("No messages published in ", sqs.getQueueUrl)
        }
    }
})

function removeFromQueue(message) {
    sqs.deleteMessage({
        QueueUrl : sqs.getQueueUrl,
        ReceiptHandle : message.ReceiptHandle
    }, function(err, data) {
        err && console.log(err);
    });
};