# Desafio Pic Pay Simplificado Back-End

O desafio proposto pela picpay consiste em criar uma API RESTFull que atuará como um protótipo simplificado da picpay.
Resumidamente, o sistema deverá realizar transações entre usuários, lidando de maneira segura e íntegra com os dados.

Veja você mesmo o desafio [desafio](https://github.com/PicPay/picpay-desafio-backend).

Desenvolvido por [João Vieira](www.linkedin.com/in/joaovieiradev).

Api documentada no endpoint: http://localhost:8080/swagger-ui.html.

## 📦 Funcionalidades

- CRUD de Usuários.
- Efetuação e persistência de transações.
- Validações de regras de negócio referentes a transações.
- Tratamento global de exceções.
- Criptografia de senhas com SpringSecurity

## ⚙️ Arquitetura, padrões e boas práticas 

- Banco de dados relacional buscando a finalidade de integridade com dados sensíveis (ACID).
- Código limpo e seguindo princípios SOLID.
- Arquitetura de camadas. 
- Utilização de DTOs.
- Nomenclaturas de ENDPOINTS padrão REST.

## 📌 Regras de negócio

- Emails e documentos cadastrados são únicos.
- Existem usuários lojistas e comuns.
- Apenas usuários comuns podem efetuar transações, lojistas apenas recebem.
- Validar saldo do usuário com o valor da transação.
- Por questão de segurança, apenas usuários que ainda não possuem transações cadastradas podem ser deletados.
- Apenas alterações de dados não sensíveis são permitidos.

## Tecnologias utilizadas 💻 

- Java
- Spring boot
- Spring Data JPA
- Spring Security
- MySQL
- Swagger








 
