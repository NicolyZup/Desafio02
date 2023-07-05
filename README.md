# Desafio 2
Repositório para entrega do Desafio 2 do programa catalisa.

## Desafio proposto
Faça um sistema responsável por registros de vendas de uma organização. Toda
venda possui um cliente, vendedor responsável, valor a ser pago e data de registro.

Entrega Mínima:

● O projeto permite cadastrar diversas vendas no sistema.

● O sistema não permite cadastrar vendas para clientes não cadastrados.

● O sistema não permite cadastrar vendas de vendedores não cadastrados.

● O sistema permite listar todas as vendas cadastradas.

● O sistema permite listar todos os vendedores cadastrados.

● O sistema permite listar todos os clientes cadastrados.

Entrega média:

● O sistema não permite cadastrar clientes com e-mail inválido (sem @).

● O sistema não permite cadastrar vendedores com e-mail inválido (sem @).

● O sistema não permite cadastrar clientes com CPFs repetidos.

● O sistema não permite cadastrar vendedores com CPFs repetidos.

● O sistema não permite cadastrar clientes com e-mails repetidos.

● O sistema não permite cadastrar vendedores com e-mails repetidos.

Entrega Máxima:

● O sistema permite pesquisar todas as compras de um cliente em específico
através de seu CPF.

● O sistema permite pesquisar todas as vendas de um vendedor em específico
através de seu e-mail.

● O sistema contém uma cobertura de testes de 100%.

## Organização do sistema
- database: Pasta que armazena banco de dados das classes clientes, vendedores e vendas.
- controllers: Pasta que armazena as classes que fazem as validações de clientes, vendedores e vendas.
- models: Pasta que armazena as modelagens de cliente, vendedor e venda.
- loja: Classe executável, realiza interações com o usuário.
- test: Pasta com os respectivos testes das classes da pasta controllers.

## Ferramentas
- [Java](https://www.java.com/pt-BR/)
- [Mockito](https://site.mockito.org/)
- [JUnit](https://junit.org/junit5/)

## Conteúdos estudados e aplicados
- conceitos POO;
- principios SOLID;
- estruturas de repetição: foreach, do/while;
- estruturas de decisão: switch/case, if/else;

## Testes
- Os testes foram aplicados para as classes da pasta controllers, na qual contém maior parte da lógica e validações do sistema. A cobertura total foi de 90% das classes e 30% das linhas.
  
![image](https://github.com/NicolyZup/Desafio02/assets/133882322/6b6144d5-8edf-4c74-8269-abcce49a15f4)


