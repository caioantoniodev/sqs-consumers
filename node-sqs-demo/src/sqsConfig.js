import { SQS } from '@aws-sdk/client-sqs'  

export const sqs = new SQS({
    useQueueUrlAsEndpoint: false,
    region: 'sa-east-1',
    endpoint: 'https://localhost.localstack.cloud:4566/000000000000/example-queue', 
  });

export const MAX_NUMBER_OF_MESSAGES = 10;