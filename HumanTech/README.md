# 🌐 HumanTech Global Solution

A aplicação HumanTech Global Solution é uma API REST construída em Java com Spring Boot para gerenciar processos de recrutamento. O sistema oferece endpoints para criação, atualização, remoção e consulta de vagas, além de suporte a documentação automática via Swagger. A solução utiliza Spring Data JPA para persistência, banco H2 para ambiente de desenvolvimento e segue o padrão MVC dentro do ecossistema Spring.

O projeto permite que clientes da API realizem operações completas sobre vagas de emprego, incluindo cadastro, listagem, busca detalhada e exclusão. A infraestrutura inclui configuração de banco integrada, testes via Postman/Insomnia e console H2 para inspeção dos dados. Ferramentas como Lombok e Maven otimizam o desenvolvimento, enquanto o Swagger facilita o uso da API e a comunicação com terceiros.

## 🧰 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 / MySQL
- SpringDoc OpenAPI 3 (Swagger)
- Lombok
- Maven



## ❗ Requisitos

- Java 17+
- Maven instalado
- IDE de preferência (IntelliJ, Eclipse, VS Code)
- Postman / Insomnia para testes



## 📦 Instalação e Execução

```bash
# Clonar repositório
git clone https://github.com/SEU_USUARIO/humantech.git
cd humantech

# Compilar projeto
mvn clean install

# Executar aplicação
mvn spring-boot:run
```
## 🔌 Main Endpoints

| Método | Endpoint      | Descrição             |
|--|-||
| POST   | /vagas         | Cria uma nova vaga     |
| GET    | /vagas/{id}    | Busca vaga pelo ID     |
| GET    | /vagas         | Lista todas as vagas   |
| PUT    | /vagas/{id}    | Atualiza uma vaga      |
| DELETE | /vagas/{id}    | Deleta uma vaga        |


### 📤 Exemplo de Requisição (POST /vagas)
```bash
{
  "titulo": "Dev Back-End",
  "tipoTrabalho": "Presencial",
  "salario": 6500.00,
  "descricao": "Experiência com Java e Spring Boot"
}
```
### 📥 Exemplo de Resposta
```bash
{
  "id": 1,
  "titulo": "Dev Back-End",
  "tipoTrabalho": "Presencial",
  "salario": 6500.00,
  "descricao": "Experiência com Java e Spring Boot"
}
```
## ❔ Como testar no Postman

1. Execute o projeto com: **mvn spring-boot:run**

2. Use o endereço base: **http://localhost:8080**

3. Envie requisições para os endpoints listados

## 📖 Documentation Swagger

    Acesse após iniciar a aplicação:

🔗 http://localhost:8080/swagger-ui/index.html

    Para executar: mvn test

## 🛠 Configuração do Banco (application.properties)

- spring.datasource.url=jdbc:h2:mem:testdb  
- spring.datasource.driverClassName=org.h2.Driver  
- spring.datasource.username=sa  
- spring.datasource.password=  
- spring.jpa.hibernate.ddl-auto=update  
- spring.h2.console.enabled=true  

### 🔗 Console H2: **http://localhost:8080/h2-console**
```bash
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```

## 👨‍💻 Authors

Eric Segawa Montagner

Pedro Pereira dos Santos
