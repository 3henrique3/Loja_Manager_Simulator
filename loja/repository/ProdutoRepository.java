package com.henrique.loja.repository;

import com.henrique.loja.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
    Optional<ProdutoModel> findById(UUID produto_id);

    boolean existsByNome(String nome);
}
