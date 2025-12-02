package com.henrique.loja.service;

import com.henrique.loja.dto.AtualizarProdutoPatchDto;
import com.henrique.loja.dto.SalvarProdutoDto;
import com.henrique.loja.model.ProdutoModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoService {
    List<ProdutoModel> findAll();

    Optional<ProdutoModel> findById(UUID produto_id);

    ProdutoModel save(SalvarProdutoDto salvarProdutoDto);

    ProdutoModel updatePut(ProdutoModel produtoModel, SalvarProdutoDto salvarProdutoDto);

    boolean existsByNome(String nome);

    void deleteProduto(ProdutoModel produtoModel);

    ProdutoModel atualizarCategoriaStatus(ProdutoModel produtoModel, AtualizarPatchProdutoDto atualizarPatchProdutoDto);
}
