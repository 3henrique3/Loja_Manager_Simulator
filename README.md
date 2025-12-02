# 🛍️ Simulador - Sistema de Gerenciamento de Produtos

## 📌 Sobre o Projeto

Projeto **Spring Boot** desenvolvido em **Java 21** que implementa uma **API REST** para gerenciamento de **Produtos**.
A API permite criar, listar, atualizar (completa e parcial) e remover produtos da loja.

Foi construído usando:

* **Spring Boot Web**
* **Spring Data JPA**
* **MySQL**
* **Lombok**
* **Validation**
* **Enums** para Categoria e Status do Produto

## 📂 *Estrutura do Projeto*

```
src/main/java/com/henrique/loja/ 
│ 
├── controller/ 
│   └── ProdutoController.java (A ser criado) 
│ 
├── dto/ 
│   ├── AtualizarPatchProdutoDto.java 
│   └── SalvarProdutoDto.java 
│ 
├── enums/ 
│   ├── CategoriaProduto.java 
│   └── StatusProduto.java 
│ 
├── model/ 
│   └── ProdutoModel.java 
│ 
├── repository/ 
│   └── ProdutoRepository.java 
│ 
├── service/ 
│   ├── ProdutoService.java 
│   └── impl/ 
│       └── ProdutoServiceImpl.java
```

## 🛠 *Tecnologias Utilizadas*

| Tecnologia  | Versão |
| ----------- | ------ |
| Java        | 21     |
| Spring Boot | 3.5.8  |
| Maven       | 3.x    |
| MySQL       | 8+     |


# ⚙️ *Configuração do Projeto*

## *1. Configure o Banco de Dados MySQL*

Crie o banco:

sql
CREATE DATABASE loja;


## *2. Configure o application.yml*

Exemplo:
```
yaml
server:
  port: 8080
  servlet:
    context-path: /loja/

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/loja?useSSL=false&serverTimezone=UTC
    username: root
    password: SUA_SENHA
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQLDialect
```

# 🚀 *Executando o Projeto*

### Via Maven

bash
mvn spring-boot:run


### Compilando JAR

bash
mvn clean package
java -jar target/loja-0.0.1-SNAPSHOT.jar


A API estará disponível em:

http://localhost:8080/loja/


# 📡 *Endpoints da API*

Base URL:

http://localhost:8080/loja/produto

## 📌 *1. Criar nova disciplina*

### *POST* /loja/produto

#### Body JSON:

json
{
  "nome": "Detergente",
  "valor": 1.30,
  "categoriaProduto": "LIMPEZA",
  "statusProduto": "DISPONIVEL"
}


## 📌 *2. Listar todos os produtos*

### *GET* /loja/produto


## 📌 *3. Buscar produto por ID*

### *GET* /loja/produto/{produto_id}


## 📌 *4. Atualizar produto (PUT)*

### *PUT* /loja/produto/{produto_id}

#### Body:

json
{
  "nome": "Salgadinho",
  "valor": 3.30,
  "categoriaProduto": "ALIMENTACAO",
  "statusProduto": "DISPONIVEL"
}


## 📌 *5. Atualização parcial nome, valor, categoriaProduto e/ou statusProduto (PATCH)*

### *PATCH* /loja/produto/{produto_id}

#### Body:

json
{
  "categoriaProduto": "ELETRONICO"
}


## 📌 *6. Deletar disciplina*

### *DELETE* /loja/produto/{produto_id}

Retorno esperado:

204 NO CONTENT


# ⌨️ Testando no Postman

Use os endpoints conforme acima.

Para testar o POST, configure:

* *Method:* POST
* *URL:* http://localhost:8080/loja/produto
* *Body → Raw → JSON*
* Insira o JSON do DTO


# 📦 *Dependências (pom.xml)*

Esse projeto utiliza:

xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>


# 💻 Autor

*Pedro Henrique*
Projeto de estudo seguindo roadmap Java + Spring Boot.
