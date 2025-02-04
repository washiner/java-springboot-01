package com.washiner.listaproduto.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "produto") // Nome da tabela no banco
public class Produto { // Nome da classe com inicial maiúscula (Padrão Java)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática de ID
    private Long id;

    @Column(name = "nome", nullable = false, length = 100) // Nome do produto (não pode ser nulo)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 150) // Descrição do produto
    private String descricao;

    // 🔹 Construtor Padrão (Obrigatório para JPA)
    public Produto() {}

    // 🔹 Construtor com Parâmetros
    public Produto(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    // 🔹 Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // 🔹 Métodos para comparar objetos (importante para coleções e operações com JPA)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // 🔹 Método toString para facilitar depuração
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}