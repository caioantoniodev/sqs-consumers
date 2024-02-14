import { sqs, MAX_NUMBER_OF_MESSAGES } from "./sqsConfig.js";

const receiveParams = {
    MaxNumberOfMessages: MAX_NUMBER_OF_MESSAGES,
    MessageAttributeNames: [
        "All"
    ],
    QueueUrl: sqs.getQueueUrl,
};

sqs.receiveMessage(receiveParams, (err, data) => {
    console.log("Retrieving messages from queue ", sqs.getQueueUrl)
    if (err) {
        console.error("Error retrieving messages: ", err)
    } else {
        if (data.Messages) {
            deleteMessages(data.Messages);
        } else {
            console.log("No messages found in queue");
        }
    }
});

function deleteMessages(messages) {
    messages.forEach(message => {
        const deleteParams = {
            QueueUrl: sqs.getQueueUrl,
            ReceiptHandle: message.ReceiptHandle
        };
        console.log("deleting message: ", message.MessageId);
        sqs.deleteMessage(deleteParams, (err, data) => {
            if (err) {
                console.log("Error deleting message ID", message.MessageId);
            } else {
                console.log("message deleted", data);
            }
        });
    });
}

