# Send Book Email Spring Batch

[![Java](https://img.shields.io/badge/Java-21-red.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-green.svg)](https://spring.io/projects/spring-boot)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)]()

## Descrição

Este projeto é uma aplicação Spring Boot que utiliza Spring Batch para enviar notificações por e-mail sobre empréstimos de livros. A aplicação está configurada para usar o Quartz Scheduler para agendar tarefas de envio de e-mails.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Batch**
- **Quartz Scheduler**
- **SendGrid**
- **MySQL**
- **Maven**

## Configuração do Projeto

### Banco de Dados

A aplicação utiliza dois bancos de dados MySQL:
- Um para o Spring Batch (`spring_batch`)
- Outro para a aplicação (`library`)

As configurações de conexão com o banco de dados estão no arquivo `src/main/resources/application.properties`.

### Dependências

As dependências do projeto estão definidas no arquivo `pom.xml`. As principais dependências incluem:

- `spring-boot-starter-batch`
- `spring-boot-starter-quartz`
- `spring-boot-starter-data-jpa`
- `mysql-connector-java`
- `sendgrid`

### Configuração do Quartz

A configuração do Quartz está no arquivo `src/main/java/com/example/send_book_email_spring_batch/config/QuartzConfig.java`. O job `SendBookLoanNotificationScheduleJob` é agendado para ser executado diariamente às 14:40.

### Configuração do Spring Batch

O job do Spring Batch é configurado no arquivo `src/main/java/com/example/send_book_email_spring_batch/job/SendBookLoanNotificationScheduleJob.java`. O step `sendEmailUserStep` é configurado no arquivo `src/main/java/com/example/send_book_email_spring_batch/step/SendEmailUserStepConfig.java`.

## Modelo de Domínio
![Modelo de domínio](https://raw.githubusercontent.com/fabioallima/send-book-email-spring-batch/refs/heads/main/src/main/resources/assets/bookloan.svg)

## Requisitos de Sistema

- Java Development Kit (JDK) 21
- Maven 3.6+
- Docker e Docker Compose (para ambiente de desenvolvimento e testes)
- MySql (pode ser executado via Docker)

## Como Executar

```bash
# Clonar o repositório
git clone https://github.com/fabioallima/send-book-email-spring-batch

# Entrar no diretório do projeto
cd dslist

# Construir o projeto
mvn clean install

# Executar os testes
mvn test

# Iniciar a aplicação
mvn spring-boot:run
```

## Configuração do SendGrid

Para enviar e-mails, configure a chave da API do SendGrid no arquivo `application.properties`:
```ini
spring.sendgrid.api-key=YOUR_SENDGRID_API_KEY
```

## Autor

Fabio Almeida Lima

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Fabio%20Almeida%20Lima-blue.svg)](https://www.linkedin.com/in/fabio-alima/)

