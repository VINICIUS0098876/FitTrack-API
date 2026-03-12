# 🚀 FitTrack-API

FitTrack-API é uma solução robusta para o gerenciamento de alunos de academias, fornecendo ferramentas de cadastro e cálculo de IMC de forma eficiente e segura. Desenvolvida com as melhores práticas do ecossistema Java, esta API entrega alta performance, modularidade e fácil integração.

---

## 💻 Tecnologias Utilizadas

| Tecnologia         | Versão      | Badge                                                                                |
|--------------------|-------------|--------------------------------------------------------------------------------------|
| Java               | 21          | ![Java](https://img.shields.io/badge/Java-21-blue.svg)                               |
| Spring Boot        | 4.0.2       | ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen.svg)     |
| Spring Data JPA    | -           | ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-4.0.2-blue.svg)  |
| Hibernate          | -           | ![Hibernate](https://img.shields.io/badge/Hibernate-ORM-blue.svg)                    |
| MySQL              | -           | ![MySQL](https://img.shields.io/badge/MySQL-Database-orange.svg)                     |
| Maven              | -           | ![Maven](https://img.shields.io/badge/Maven-Build-red.svg)                           |

---

## ⚙️ Como Rodar o Projeto

1. **Pré-requisitos:**
   - Java 21 instalado
   - MySQL disponível e configurado
   - Maven ou Wrapper (`mvnw`)

2. **Configuração do Banco de Dados:**
   - No arquivo `src/main/resources/application.properties` configure as credenciais de acesso ao MySQL:

```properties
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/fittrackdb
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

3. **Executando a aplicação:**
   - Via Maven Wrapper:
     ```bash
     .\mvnw spring-boot:run
     ```
   - Ou via Maven:
     ```bash
     mvn spring-boot:run
     ```

---

## 📚 Endpoints

| Método  | Rota                    | Descrição                                                     |
|---------|-------------------------|---------------------------------------------------------------|
| POST    | `/usuario`              | Cadastro de usuário/ aluno (salva diretamente no MySQL)       |
| GET     | `/usuario`              | Listagem de todos os usuários/alunos cadastrados              |
| GET     | `/count`                | Retorna a quantidade total de alunos cadastrados              |
| GET     | `/imc/{peso}/{altura}`  | Calcula o IMC baseado nos valores informados na URL           |

### Exemplos de Requisição

- **Cadastrar usuário:**
  ```http
  POST /usuario
  Content-Type: application/json

  {
    "nome": "Maria",
    "idade": 24,
    "peso": 60.0,
    "altura": 1.70
  }
  ```

- **Listar usuários:**
  ```http
  GET /usuario
  ```

- **Contar alunos:**
  ```http
  GET /count
  ```

- **Calcular IMC:**
  ```http
  GET /imc/70/1.75
  ```

---

## 🏛️ Padrão de Projeto Diferencial

O FitTrack-API segue rigorosamente o padrão de camadas para garantir manutenção e escalabilidade:

- **Controller:** Responsável pelo recebimento das requisições HTTP.
- **Entity:** Modela os dados de domínio.
- **Repository:** Abstrai operações de persistência.
- **Service (opcional):** Recomendado para lógica de negócio.

---

## 📄 Licença

Este projeto está sob a licença [MIT](LICENSE).

---

## 👨‍💻 Autor

VINICIUS0098876

---
