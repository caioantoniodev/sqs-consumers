# SQS Localstack consumer/producer

Este projeto foi desenvolvido com o intuito de auxiliar os testes de produção e consumo de filas SQS utilizando o localstack

## Requerimentos

- Java (versão 17 ou superior)
- C# e .NET (versão 6 ou superior)
- docker
- docker-compose

## Configuração

- Localstack

1. Instanciar o container do localstack:

```shell
docker-compose up -d
```

2. Acessar o container e configura o localstack:

```shell
docker-compose exec localstack bash

# Dentro do container
aws configure
# Informar o seu access-key, access-secret e region do localstack
```

3. Verificar se a(s) fila(s) foram criadas no localstack:

```shell
# dentro do container
aws --endpoint-url=http://localhost:4566 sqs list-queues
```

- NodeJS

1. Instalar as dependencias

```shell
npm install
```

## Executando a aplicação

### Produzindo uma mensagem

Para produzir uma mensagem, excecute o seguinte comando:

```shell
npm run sqs:produce
```

### Consumindo as mensagens publicadas

Para consumir as mensagens publicadas, execute o seguinte comando:

```shell
npm run sqs:consume
```

### Excluindo as mensagens em uma fila

Para excluir as 10 ultimas mensagens de uma fila, execute o seguinte comando:

```shell
npm run sqs:clear
```

## Alterando as configurações

1. Alterar a fila onde a mensagem será publicada

Para alterar a fila onde a mensagem será publicada, altere a variável `produceUrl` no arquivo `src/sqsConfig.js`

2. Alterar a mensagem publicada

Para alterar a mensagem publicada, altere a variável `message` no arquivo `src/message.js`

3. Alterar a fila de consumo da mensagem

Para alterar a fila de consumo da mensagem, altere a variável `consumeUrl` do no arquivo `src/sqsConfig.js`

4. Alterar a fila onde as mensagens serão removidas

Para alterar a fila de consumo da mensagem, altere a variável `clearUrl` do no arquivo `src/sqsConfig.js`

5. Alterar a quantidade de mensagens excluidas na fila

Para alterar a quantidade de mensagens serem excluídas da fila, altere o valor da constante `MAX_NUMBER_OF_MESSAGES` no arquivo `src/sqsConfig.js`

**OBS.:** o número de mensagens deve ser um valor entre **1 e 10**

## Referencias

- [Enviar e receber mensagens no Amazon SQS](https://docs.aws.amazon.com/pt_br/sdk-for-javascript/v2/developer-guide/sqs-examples-send-receive-messages.html)
- [Localstack | docs](https://docs.localstack.cloud/overview/)
- [AWS SDK for JavaScript | SQS](https://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/SQS.html)