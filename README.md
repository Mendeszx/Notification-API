# Notification-API

Este projeto demonstra um ambiente de mensageria usando RabbitMQ para envio de emails juntamente com uma aplicação de produtor e consumidor, ambos em Java Spring Boot, além de um servidor Nginx para roteamento. Além disso, utiliza um banco de dados PostgreSQL para persistência dos dados.

<img src="https://cdn.discordapp.com/attachments/538485144106041394/1240118710019031120/Notification-API.drawio.png?ex=6645660c&is=6644148c&hm=b9cd68485c4bcc84dff4e5bf85b00286a40bf7e0d3fcb41e305c775ffb268e16&">

## Pré-requisitos

- Docker
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
