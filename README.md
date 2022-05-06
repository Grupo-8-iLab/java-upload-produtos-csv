<h1 align="center" font-style="bold">
    <img width="584" alt="imagem header" src="https://raw.githubusercontent.com/GeraldinJr/BackendTrackHistory-iFood/master/assets/imgHeaderReadme.png"><br>
Track History - API
</h1>

## 💻 Sobre o projeto

- <p > Este projeto é uma aplicação web simples que realiza upload de arquivos csv na Amazon S3 e salva os dados desses arquivos em um banco PostgreSql na Amazon RDS.</p>

Para ver o repositório do **Consumer Kafka**, clique aqui: [Consumer](https://github.com/Grupo-8-iLab/java-server-aws-kafka)

## 👨🏻‍💻 Desenvolvedores

- [Debora Brum](https://github.com/DeboraBrum)
- [Edvan Jr.](https://github.com/Edvan-Jr)
- [Geraldo Jr.](https://github.com/GeraldinJr)
- [Lucas Paixão](https://github.com/lucasfpds)
- [Magnólia Medeiros](https://github.com/magnoliamedeiros)

## 🚀 Tecnologias

Tecnologias que utilizamos para desenvolver este projeto:

- [Java](https://www.java.com/pt-BR/)
- [Spring](https://spring.io/)
- [PostgreSQL](https://www.postgresql.org/)
- [Amazon EC2](https://aws.amazon.com/pt/ec2/)
- [Amazon Kafka](https://kafka.apache.org)
- [Amazon S3](https://aws.amazon.com/pt/s3/)
- [Amazon RDS](https://aws.amazon.com/pt/rds/)

## ▶️ Iniciando

- As instruções a seguir irão te guiar para que você crie uma cópia do projeto na sua máquina local.

### Pré-requisitos

- Configure um banco de dados [PostgreSQL](https://www.postgresql.org/) na sua máquina e crie um novo banco.

**Clone o projeto, e acesse a pasta**

```bash
$ git clone https://github.com/Grupo-8-iLab/java-upload-produtos-csv.git && cd java-upload-produtos-csv
```

**Siga as etapas abaixo**

Edite o arquivo "./src/main/resources/application.properties" com as configurações do seu banco de dados:

```
spring.datasource.username = seu_usuario
spring.datasource.password = sua_senha
spring.datasource.url = jdbc:postgresql://localhost:5432/nome_do_seu_banco
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL10Dialect
spring.jpa.show_sql = true
```

Edite as seguintes variáveis de ambiente em seu bash_profile:

```shell
export AWS_ACCESS_SECRET_KEY_ID=
export AWS_SECRET_KEY=
export KAFKA_HOST=
export KAFKA_TOPIC=
```

Inicie o Kafka na sua máquina utilizando os seguintes comandos: 

```shell
# Para iniciar o zookeper
sh ~/kafka_2.13-3.1.0/bin/zookeeper-server-start.sh ~/kafka_2.13-3.1.0/config/zookeeper.properties
# Para iniciar o kafka
sh ~/kafka_2.13-3.1.0/bin/kafka-server-start.sh ~/kafka_2.13-3.1.0/config/server.properties
```

E rode o projeto na sua IDE.

Tudo pronto! Agora, basta acessar http://localhost:8080/.

## 📄 Exemplo de arquivo .csv

| Nome  | Descrição          | Quantidade |
| ----- | ------------------ | ---------- |
| Fruta | Banana Prata       | 2          |
| Doce  | Chocolate ao Leite | 3          |

## ⚙️ Funcionalidades

Funcionalidades que a API oferece:
- Upload de Arquivos .csv;
- Listagem dos dados salvos em banco de dados;

## 📄 Licença

Este projeto está sob a licença de Bolinho de Java Corp.