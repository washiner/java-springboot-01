package com.washiner.listaproduto.repository;

import com.washiner.listaproduto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Produto, Long> {
}
