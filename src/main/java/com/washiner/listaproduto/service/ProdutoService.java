package com.washiner.listaproduto.service;

import com.washiner.listaproduto.model.Produto;
import com.washiner.listaproduto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
                   //do tipo             //atributo
    private final ProdutoRepository produtoRepository; //-> Come se lê essa linha? -> "Estou declarando um atributo chamado produtoRepository,
                                                       // que é do tipo ProdutoRepository. Esse atributo é privado e final, o que significa que
                                                       // ele só pode ser acessado dentro desta classe (ProdutoService) e que seu valor não
                                                       // pode ser alterado após ser inicializado."
                                                       // Ela está criando um atributo dentro da classe ProdutoService. Esse atributo será usado para acessar os métodos da classe ProdutoRepository.
                                                       // Declara um atributo do tipo ProdutoRepository.
                                                       //Ele é privado, ou seja, só pode ser acessado dentro da classe ProdutoService.
                                                       //Ele é final, o que significa que seu valor não pode ser alterado depois de inicializado no construtor.
                              //tipo             //parametro chamado (ou seja um objeto)
    public ProdutoService(ProdutoRepository produtoRepository){ // -> "Este é o construtor da classe ProdutoService.
                                                                // Ele recebe um objeto do tipo ProdutoRepository como parâmetro
                                                                // e armazena esse objeto no atributo da classe."
                                     // parametro que recebemos do contrutor
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos(){ // -> "Este é um método público chamado getAllProdutos, que retorna uma lista de produtos. Ele chama o método findAll() do produtoRepository para buscar todos os produtos do banco de dados."
        return produtoRepository.findAll();
    }

    public Produto saveProduto(Produto produto){ // -> Este é um método público chamado saveProduto, que recebe um objeto do tipo Produto, salva esse produto no banco de dados utilizando o produtoRepository, e depois retorna o próprio produto salvo (que pode ter sido alterado, como no caso de um ID gerado automaticamente pelo banco).
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, Produto produto){ // -> Este é um método público chamado updateProduto. Ele recebe o ID de um produto e um objeto Produto com as novas informações. O método busca o produto pelo ID no banco de dados. Se o produto for encontrado, ele atualiza o nome e a descrição do produto com os novos valores e salva o produto novamente no banco de dados. Se o produto não for encontrado, o método lança um erro.
        Produto existeProduto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
        existeProduto.setNome(produto.getNome());
        existeProduto.setDescricao(produto.getDescricao());
        return produtoRepository.save(existeProduto);
    }

    public String deletarProduto(Long id){
        produtoRepository.deleteById(id);
        return "produto com id " + id + " Deletado com sucesso !!";
    }
}
