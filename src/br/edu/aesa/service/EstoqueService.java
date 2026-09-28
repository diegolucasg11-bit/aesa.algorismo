package br.edu.aesa.service;

import br.edu.aesa.model.Produto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EstoqueService {

    private Map<Integer, Produto> produtos = new HashMap<>();

    public boolean cadastrar(Produto produto) {
        if (produtos.containsKey(produto.getId())) {
            return false;
        }
        produtos.put(produto.getId(), produto);
        return true;
    }

    public Produto buscarPorId(int id) {
            return produtos.get(id);
    }

    public Collection<Produto> listarTodos() {
        return produtos.values();
    }

    public boolean atualizar(int id, String nome, String categoria, double preco, int quantidade) {
            Produto produto = produtos.get(id);

            if (produto == null) {
                return false;
            }

            produto.setNome(nome);
            produto.setCategoria(categoria);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);

            return true;
    }

    public boolean remover(int id) {
        Produto produto = produtos.remove(id);

        if (produto == null) {
            return false;
        }

        return true;
    }
}
