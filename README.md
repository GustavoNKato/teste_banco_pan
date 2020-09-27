# Customer Service

### Requirements

1. JDK 8
1. Maven 3

### Running

1. Clone : `https://github.com/GustavoNKato/teste_banco_pan.git`
1. Go to the folder `teste_banco_pan` and execute: `mvn spring-boot:run`

### Request methods

| Command | URI | JSON |
| --- | --- | --- |
| `Listar todos os cliente` | GET http://localhost:8080/cliente/ | NA
| `Consultar clientes pelo CPF` | GET http://localhost:8080/cliente/{cpf} | NA
| `Consultar endereço pelo CEP` | GET http://localhost:8080/endereco/{cep} | NA
| `Consultar Municipio` | GET http://localhost:8080/endereco/{municipio} | NA
| `Consultar Estados` | GET http://localhost:8080/estados/ | NA
