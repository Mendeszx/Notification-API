# email-web-service

[Draw io](https://drive.google.com/uc?export=view&id=1fFboDbRxk26WCWr15TMBKoOsAr_0mcyL)

Este projeto demonstra um ambiente de mensageria usando RabbitMQ juntamente com uma aplicação de produtor e consumidor, ambos em Java Spring Boot, além de um servidor Nginx para roteamento. Além disso, utiliza um banco de dados PostgreSQL para persistência dos dados.

## Pré-requisitos

- Docker
- Docker Compose
- Postman

## Instruções de Uso

1. Clone este repositório:

```bash
git clone https://github.com/Mendeszx/email-web-service.git
```

2. Navegue até o diretório do projeto:

3. Execute o Docker Compose para iniciar o ambiente:

```bash
docker-compose up -d
```

4. Aguarde até que todos os serviços estejam em execução.

5. Acesse a interface web do RabbitMQ em [http://localhost:15672](http://localhost:15672) (Usuário: admin, Senha: admin) para monitorar a fila de mensagens.

6. Pronto! Seu ambiente de mensageria com RabbitMQ e PostgreSQL está pronto para uso.

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com melhorias.

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para obter mais detalhes.
