#!/bin/bash
echo "########### Create Profile ###########"
aws configure set aws_access_key_id fakeAwsAccessKey --profile=localstack
aws configure set aws_secret_access_key fakeAwsAcessSecret --profile=localstack
aws configure set region sa-east-1 --profile=localstack

echo "########### Create SQS ###########"
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name example-queue --profile=localstack

echo "########### Listing queues ###########"
aws --endpoint-url=http://localhost:4566 sqs list-queues --profile=localstack

echo "########### Command to view SNS messages in SQS-Subscriber ###########"
echo "aws --endpoint-url=http://localhost:4566 sqs receive-message --queue-url http://localhost:4566/000000000000/example-queue --profile=localstack"

echo "########### Command to send messages to SQS-Subscriber ###########"
echo "aws --endpoint-url=http://localhost:4566 sqs send-message --queue-url http://localhost:4566/000000000000/example-queue --message-body hello world"
