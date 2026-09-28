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

            opcao = scanner.nextInt();

            if (opcao == 1) {

                System.out.println("Digite o ID do produto: ");
                int id = scanner.nextInt();

                System.out.println("Digite o nome do produto: ");
                String nome = scanner.next();

                System.out.println("Digite a categoria: ");
                String categoria = scanner.next();

                System.out.println("Digite o preço: ");
                double preco = scanner.nextDouble();

                System.out.println("Digite a quantidade: ");
                int quantidade = scanner.nextInt();

                Produto produto = new Produto(id, nome, categoria, preco, quantidade);

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

        } while (opcao != 0);
    }
}
