# 💱 CoinPulse

API REST desenvolvida em Java com Spring Boot para consulta, monitoramento e registro de cotações de moedas em tempo real.

O projeto consome dados da AwesomeAPI, registra o histórico das consultas em banco H2 e aplica alertas por nível utilizando os padrões de projeto Facade, Strategy e Singleton.

---

## 🚀 Funcionalidades

- ✅ Consulta de cotação de moedas em tempo real
- ✅ Integração externa com AwesomeAPI via OpenFeign
- ✅ Registro de histórico com Spring Data JPA
- ✅ Persistência em banco H2 em memória
- ✅ Alertas por nível usando Strategy
- ✅ Contador de consultas usando Singleton
- ✅ Camada Facade para centralizar a regra de negócio

---

## 🛠️ Tecnologias utilizadas

- Java 25
- Spring Boot 4.1.0
- Spring WebMVC
- Spring Data JPA
- Spring Cloud OpenFeign
- H2 Database
- Maven
- JUnit 5

---

## 🧠 Padrões de projeto

### 🏛️ Facade

A classe `CurrencyFacade` centraliza o fluxo principal da aplicação: consulta a API externa, registra o histórico e executa os alertas.

### 🎯 Strategy

O projeto utiliza estratégias de alerta para alternar comportamentos conforme o nível informado:

- `NORMAL`: relatório diário
- `HIGH`: alerta crítico

### 🧩 Singleton

A classe `SystemTrackerSingleton` mantém um contador único de consultas realizadas durante a sessão da aplicação.

---

## 📡 Endpoint principal

```http
GET /api/v1/currencies/{pair}
```

Exemplo:

```http
GET http://localhost:8080/api/v1/currencies/USD-BRL?level=NORMAL
```

Parâmetros:

| Parâmetro | Tipo | Obrigatório | Descrição |
| --- | --- | --- | --- |
| `pair` | Path Variable | Sim | Par de moedas. Exemplo: `USD-BRL` |
| `level` | Query Param | Não | Nível do alerta: `NORMAL` ou `HIGH` |

---

## ▶️ Como executar

No Windows:

```bash
./mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

## 🧪 Testes

Para executar os testes:

No Windows:

```bash
./mvnw.cmd test
```

No Linux/macOS:

```bash
./mvnw test
```

Resultado validado no projeto:

```text
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

---

## 📂 Estrutura do projeto

```text
src
├── main
│   ├── java/com/example/CoinPulse
│   │   ├── client
│   │   ├── controller
│   │   ├── dto
│   │   ├── facade
│   │   ├── model
│   │   ├── repository
│   │   ├── singleton
│   │   └── strategy
│   └── resources
└── test
```

---

## 🌐 API externa

O projeto utiliza a AwesomeAPI para consultar cotações.

Base URL:

```text
https://economia.awesomeapi.com.br
```

Endpoint usado:

```text
/last/{currencies}
```

---

## 📈 Melhorias futuras

- 🔐 Tratamento global de exceções
- 📘 Documentação com Swagger/OpenAPI
- 🧪 Testes unitários para controller, facade e strategies
- 🗃️ Endpoint para listar histórico de consultas
- 🐳 Dockerfile para execução em container
- ⚙️ Perfis de ambiente para desenvolvimento e produção

---

## 👨‍💻 Autor

Desenvolvido por **Lucas Fernandes**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Lucas%20Fernandes-blue?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/lucasfernandes-dev/)

---

## 📄 Licença

Este projeto está sob a licença MIT.
