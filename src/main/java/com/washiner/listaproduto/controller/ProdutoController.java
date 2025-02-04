package com.washiner.listaproduto.controller;

import com.washiner.listaproduto.model.Produto;
import com.washiner.listaproduto.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> getAllProdutos(){
        return produtoService.getAllProdutos();
    }
    @PostMapping
    public Produto saveProduto(@RequestBody Produto produto){
        return produtoService.saveProduto(produto);
    }
}
