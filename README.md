# Customer Service

### Requirements

1. JDK 8
1. Maven 4

### Running

1. Clone : `https://github.com/GustavoNKato/teste_banco_pan.git`
1. Go to the folder `teste_banco_pan` and execute: `mvn spring-boot:run`

### Request methods

| Command | URI | JSON |
| --- | --- | --- |
| `Listar todos os cliente` | GET http://localhost:8080/cliente/ | NA
| `Consultar clientes pelo CPF` | GET http://localhost:8080/cliente/{cpf} | NA
| `Altera endereço do cliente` | PUT http://localhost:8080/cliente/{cpf} | {"logradouro": "Rua Almirante","numero": 30,"bairro": "Residencial Cumbica","cidade": "Guarulhos","uf": "SP","cep": "07174470"}
| `Consultar endereço pelo CEP` | GET http://localhost:8080/endereco/{cep} | NA
| `Consultar Municipio` | GET http://localhost:8080/estados/{uf} | NA
| `Consultar Estados` | GET http://localhost:8080/estados/ | NA
