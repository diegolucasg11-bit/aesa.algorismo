package br.edu.aesa.service;

import br.edu.aesa.model.Produto;
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

}
