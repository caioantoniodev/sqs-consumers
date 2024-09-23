# SQS Localstack consumer/producer

Este projeto foi desenvolvido com o intuito de auxiliar os testes de produção e consumo de filas SQS utilizando o localstack

![Captura de Tela 2024-08-18 às 18 07 41](https://github.com/user-attachments/assets/63c87eb4-8e1a-4a93-9c84-229595cf9098)


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
## Referencias
- [Localstack | docs](https://docs.localstack.cloud/overview/)
