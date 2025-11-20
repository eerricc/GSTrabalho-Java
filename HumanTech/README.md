# 🚀 HumanTech API

API REST desenvolvida com **Java + Spring Boot** para gerenciamento de vagas de emprego.  
Permite **criar, listar, buscar, atualizar e deletar vagas**, com suporte a documentação via Swagger.

---

## 📚 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Banco de Dados (H2/MySQL)**
- **Swagger OpenAPI 3**
- **Lombok**

---

## 🏁 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- Java 17 ou superior
- Maven
- IDE (IntelliJ, Eclipse, VS Code ou outra)
- Postman ou Insomnia para testes

---

## 📦 Instalação e Execução

```bash
# Clonar repositório
git clone https://github.com/SEU_USUARIO/humantech.git
cd humantech

# Compilar projeto
mvn clean install

# Executar aplicação
mvn spring-boot:run

🔌 Endpoints Principais
Método	Endpoint	Descrição
POST	/vagas	Cria uma nova vaga
GET	/vagas/{id}	Busca vaga pelo ID
GET	/vagas	Lista todas as vagas
PUT	/vagas/{id}	Atualiza uma vaga
DELETE	/vagas/{id}	Deleta uma vaga
📤 Exemplo de Requisição (POST /vagas)

{
  "titulo": "Dev Back-End",
  "tipoTrabalho": "Presencial",
  "salario": 6500.00,
  "descricao": "Experiência com Java e Spring Boot"
}

📥 Exemplo de Resposta

{
  "id": 1,
  "titulo": "Dev Back-End",
  "tipoTrabalho": "Presencial",
  "salario": 6500.00,
  "descricao": "Experiência com Java e Spring Boot"
}

📍 Como testar no Postman

    Execute o projeto com mvn spring-boot:run

    No Postman, use http://localhost:8080

    Envie requisições para os endpoints listados acima

📖 Documentação Swagger

Após iniciar a aplicação, acesse:

🔗 http://localhost:8080/swagger-ui.html
ou
🔗 http://localhost:8080/swagger-ui/index.html
🧪 Executar Testes

mvn test

🛠 Configuração do Banco (application.properties)
Exemplo usando H2 para testes

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true

🔗 Console H2: http://localhost:8080/h2-console

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>


👨‍💻 Autor

Eric Segawa Montagner
Pedro Pereira dos Santos