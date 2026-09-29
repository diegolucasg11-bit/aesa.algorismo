package br.edu.aesa.app;

import br.edu.aesa.model.Produto;
import br.edu.aesa.service.EstoqueService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EstoqueService estoqueService = new EstoqueService();

        int opcao;

        do {

            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto por ID");
            System.out.println("4 - Atualizar produto");
            System.out.println("5 - Remover produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
            opcao = scanner.nextInt();

            } else {
                System.out.println("Digite apenas números.");
                scanner.next();
                opcao = -1;
            }

            if (opcao == 1) {

                //id

                System.out.println("Digite o ID do produto: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("Digite apenas números.");
                    scanner.next();
                }

                int id = scanner.nextInt();

                while (id <= 0) {
                    System.out.println("O ID deve ser maior que zero.");
                    System.out.println("Digite o ID do produto novamente: ");
                    id = scanner.nextInt();
                }

                //nome

                scanner.nextLine();

                String nome;

                do {
                    System.out.println("Digite o nome do produto: ");
                     nome = scanner.nextLine();

                     if (nome.trim().isEmpty()) {
                         System.out.println("O nome não pode ficar vazio.");
                     }

                } while (nome.trim().isEmpty());

                //categoria

                String categoria;

                do {
                    System.out.println();

                    System.out.println("Digite a categoria: ");
                     categoria = scanner.nextLine();

                     if (categoria.trim().isEmpty()) {
                         System.out.println("A categoria não pode ficar vazia.");
                     }
                } while (categoria.trim().isEmpty());

                //preço

                System.out.println("Digite o preço: ");
                while (!scanner.hasNextDouble()) {

                    System.out.println("Digite apenas números.");
                    scanner.next();
                }

                double preco = scanner.nextDouble();

                while (preco < 0) {

                    System.out.println("O preço não pode ser negativo.");
                    System.out.println("Digite o preço novamente: ");
                    preco = scanner.nextDouble();
                }

                //quantidade

                System.out.println("Digite a quantidade: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Digite apenas números inteiros.");
                    scanner.next();
                }

                int quantidade = scanner.nextInt();

                while (quantidade < 0) {
                    System.out.println("A quantidade não pode ser negativa.");
                    System.out.println("Digite a quantidade novamente: ");
                    quantidade = scanner.nextInt();
                }

                //criar produto

                Produto produto = new Produto(id, nome, categoria, preco, quantidade);

                //cadastrar produto

                boolean cadastrado = estoqueService.cadastrar(produto);

                if (cadastrado) {
                    System.out.println("Produto cadastrado com sucesso!");

                } else {
                    System.out.println("Erro: já existe um produto com esse ID.");
                }
            }

            if (opcao == 2) {

                if (estoqueService.listarTodos().isEmpty()) {

                    System.out.println("Nenhum produto cadastrado.");

                } else {

                    for (Produto produto : estoqueService.listarTodos()) {
                        System.out.println("ID: " + produto.getId());
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Categoria: " + produto.getCategoria());
                        System.out.println("Preço: R$ " + produto.getPreco());
                        System.out.println("Quantidade: " + produto.getQuantidade());
                        System.out.println("-------------------------");
                    }
                }
            }

            if (opcao == 3) {

                System.out.println("Digite o ID do produto: ");
                int id = scanner.nextInt();

                Produto produto = estoqueService.buscarPorId(id);

                if (produto == null) {

                    System.out.println("Produto não encontrado.");

                } else {
                    System.out.println("ID: " + produto.getId());
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Categoria: " + produto.getCategoria());
                    System.out.println("Preço: R$ " + produto.getPreco());
                    System.out.println("Quantidade: " + produto.getQuantidade());
                }
            }

            if (opcao == 4) {

                System.out.println("Digite o ID do produto que deseja atualizar: ");
                int id = scanner.nextInt();

                Produto produto = estoqueService.buscarPorId(id);

                if (produto == null) {

                    System.out.println("Produto não encontrado.");

                } else {

                    System.out.println("Digite o novo nome: ");
                    String nome = scanner.next();

                    System.out.println("Digite a nova categoria: ");
                    String categoria = scanner.next();

                    System.out.println("Digite o novo preço: ");
                    double preco = scanner.nextDouble();

                    System.out.println("Digite a nova quantidade: ");
                    int quantidade = scanner.nextInt();

                    boolean atualizado = estoqueService.atualizar(id,nome,categoria,preco,quantidade);

                    if (atualizado) {
                        System.out.println("Produto atualizado com sucesso!");
                    }

                }
            }

            if (opcao == 5) {

                System.out.println("Digite o ID do produto que deseja remover: ");
                int id = scanner.nextInt();

                boolean removido = estoqueService.remover(id);

                if (removido) {
                    System.out.println("Produto removido com sucesso!");

                } else {
                    System.out.println("Produto não encontrado.");
                }
            }

            if (opcao < 0 || opcao > 5) {

                System.out.println("Opção inválida. Escolha uma opção entre 0 e 5.");
            }

        } while (opcao != 0);
    }
}
