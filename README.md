# Controle de Estoque

## Descrição

Este projeto consiste em um sistema simples de Controle de Estoque desenvolvido em Java.

O sistema permite cadastrar, listar, buscar, atualizar e remover produtos por meio de um menu interativo executado no console.

O projeto utiliza a estrutura de dados HashMap para armazenar os produtos e está organizado em classes responsáveis pelo modelo, pelas regras do sistema e pela interação com o usuário.

---

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- README.md
- src
    - br
        - edu
            - aesa
                - app
                    - Main.java
                - model
                    - Produto.java
                - service
                    - EstoqueService.java

### Classes

- Produto.java: representa os produtos cadastrados no sistema.
- EstoqueService.java: responsável pelo armazenamento dos produtos e pelas operações do CRUD.
- Main.java: responsável pela interação com o usuário por meio do console.

---

## Estrutura de Dados

A estrutura de dados escolhida para o projeto foi o HashMap.

O sistema utiliza um Map de Integer para Produto.

O Integer representa o ID do produto e o objeto Produto representa os dados armazenados.

O ID foi utilizado como chave do HashMap porque é o identificador utilizado para localizar os produtos no sistema.

Essa estrutura permite realizar operações de cadastro, busca, atualização e remoção utilizando o ID do produto.

---

## Complexidade

Considerando o comportamento médio do HashMap, as principais operações possuem as seguintes complexidades:

- Cadastro: O(1)
- Busca por ID: O(1)
- Atualização: O(1)
- Remoção: O(1)
- Listagem: O(n)

O consumo de memória é aproximadamente O(n), pois depende da quantidade de produtos armazenados.

A operação de listagem possui complexidade O(n) porque é necessário percorrer todos os produtos cadastrados.

---

## Funcionalidades

O sistema possui um menu interativo com as seguintes opções:

1. Cadastrar produto
2. Listar produtos
3. Buscar produto por ID
4. Atualizar produto
5. Remover produto
0. Sair

### 1. Cadastrar produto

Permite cadastrar um novo produto informando:

- ID
- Nome
- Categoria
- Preço
- Quantidade

O sistema verifica se o ID já está cadastrado para evitar produtos duplicados.

### 2. Listar produtos

Exibe todos os produtos cadastrados no estoque.

Caso não exista nenhum produto, o sistema informa que nenhum produto foi cadastrado.

### 3. Buscar produto por ID

Permite localizar um produto utilizando seu ID.

Caso o produto não exista, o sistema informa que o produto não foi encontrado.

### 4. Atualizar produto

Permite alterar os seguintes dados de um produto:

- Nome
- Categoria
- Preço
- Quantidade

O produto é localizado pelo seu ID.

### 5. Remover produto

Permite remover um produto do estoque utilizando seu ID.

Caso o ID não exista, o sistema informa que o produto não foi encontrado.

### 0. Sair

Encerra a execução do programa.

---

## Validações

O sistema possui algumas validações para evitar entradas inválidas.

### ID

- O ID deve ser informado como número.
- No cadastro, o ID deve ser maior que zero.
- Não é permitido cadastrar dois produtos com o mesmo ID.

### Nome

O nome do produto não pode ficar vazio.

### Categoria

A categoria do produto não pode ficar vazia.

### Preço

- O preço deve ser informado como número.
- O preço não pode ser negativo.

### Quantidade

- A quantidade deve ser informada como número inteiro.
- A quantidade não pode ser negativa.

---

## CRUD

O sistema implementa as operações básicas de CRUD.

### Create

Cadastro de novos produtos.

### Read

Consulta e listagem dos produtos cadastrados.

### Update

Atualização dos dados de um produto.

### Delete

Remoção de produtos do estoque.

---

## Modelo Produto

A classe Produto possui os seguintes atributos:

- id
- nome
- categoria
- preco
- quantidade

Esses atributos representam as informações básicas de cada produto armazenado no estoque.

---

## Organização do Sistema

O projeto foi dividido em três partes principais.

### Model

A classe Produto pertence ao pacote model e representa a entidade do sistema.

### Service

A classe EstoqueService pertence ao pacote service e é responsável por armazenar os produtos no HashMap e executar as operações do CRUD.

### App

A classe Main pertence ao pacote app e é responsável pela execução do programa e pela interação com o usuário através do console.

---

## Tecnologias Utilizadas

- Java
- HashMap
- Map
- Collection
- Scanner

---

## Como Executar

1. Abrir o projeto em uma IDE compatível com Java.
2. Localizar a classe Main.java.
3. Executar o método main.
4. O menu do sistema será apresentado no console.
5. Escolher uma das opções disponíveis.
6. Informar os dados solicitados pelo sistema.

---

## Exemplo de Execução

Ao iniciar o programa, será apresentado um menu com as seguintes opções:

1 - Cadastrar produto
2 - Listar produtos
3 - Buscar produto por ID
4 - Atualizar produto
5 - Remover produto
0 - Sair

Para cadastrar um produto, o usuário informa o ID, nome, categoria, preço e quantidade.

Exemplo:

- ID: 1
- Nome: Arroz
- Categoria: Alimentos
- Preço: 25.90
- Quantidade: 10

Após o cadastro, o sistema informa que o produto foi cadastrado com sucesso.

Na listagem, os dados do produto são apresentados no console.

---

## Conclusão

O projeto apresenta um sistema básico de Controle de Estoque desenvolvido em Java, utilizando a estrutura de dados HashMap.

A utilização do ID como chave permite realizar as principais operações de forma direta, como cadastro, busca, atualização e remoção.

O projeto também possui validações para evitar entradas inválidas, IDs duplicados, produtos inexistentes e valores negativos para preço e quantidade.