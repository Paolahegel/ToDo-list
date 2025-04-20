# 📋 To-Do List API em dese

## 🧾 Descrição

Esta é uma aplicação de lista de tarefas (To-Do List) desenvolvida em Java com Spring Boot, que expõe uma API RESTful para o gerenciamento de tarefas. A aplicação permite criar, atualizar, buscar, filtrar e deletar tarefas utilizando operações CRUD integradas a um banco de dados relacional (PostgreSQL).

---

## 🛠 Tecnologias Utilizadas
- Linguagem: Java 
- Framework: Spring Boot
- Banco de dados: PostgreSQL e H2 para testes
- Gerenciador de Dependências: Maven
- Anotações: Lombok
- Documentação: SwaggerUI
- Testes Unitários: JUnit
- Teste Manual: Postman
---

## 💡 Princípios Adotados
- Arquitetura MVC (Model-View-Controller)
- Construção de API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Documentação automática com Swagger
- Tratamento de respostas de erro

---

## ⚙️ Funcionalidades

- ✅ Criar uma nova tarefa
- 🔄 Atualizar uma tarefa existente
- 🔍 Filtrar tarefas por status
- 🔎 Filtrar tarefas por termo (palavra-chave)
- ❌ Deletar tarefa por ID
- 🧹 Deletar todas as tarefas

---

## 🖥️ Configuração e Execução

### Pré-requisitos:
- Java JDK 17+
- Maven
- Banco de Dados SQL

## Passos para rodar localmente:

1️⃣ **Clone o repositório**
```bash
git clone https://github.com/paolahegel/ToDo-list.git
```

2️⃣ **Acesse o diretório do projeto.**
```sh
cd ToDo-list
```
3️⃣ **Configure o arquivo `application.properties` com as credenciais do seu banco de dados.**

4️⃣ **Execute o projeto:** 
```bash
./mvnw spring-boot:run
```
5️⃣ **Acesse a documentação da API via Swagger:**
```bash
http://localhost:8080/swagger-ui/index.html
```

## Exemplo de Uso

### ✅ Criar uma nova tarefa  
- **Rota:** `POST /api/tasks](http://localhost:8080/api/todo`  
- Requisição:  
```json
    {
        "nome": "Estudar estrutura de dados",
        "descricao": "Aprender manipulação e alocamento de memória",
        "prioridade": 0,
        "status": "COMPLETED",
        "realizado": true
    }
```
- Resposta:
```json
    {
        "id": 1,
        "nome": "Estudar estrutura de dados",
        "descricao": "Aprender manipulação e alocamento de memória",
        "prioridade": 0,
        "status": "COMPLETED",
        "realizado": true
    }
```









