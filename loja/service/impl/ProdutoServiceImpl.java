package com.henrique.loja.service.impl;

import com.henrique.loja.dto.SalvarProdutoDto;
import com.henrique.loja.dto.AtualizarPatchProdutoDto;
import com.henrique.loja.model.ProdutoModel;
import com.henrique.loja.repository.ProdutoRepository;
import com.henrique.loja.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    Logger logger = LogManager.getLogger(ProdutoServiceImpl.class);

    final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<ProdutoModel> findById(UUID produto_id) {
        Optional<ProdutoModel> produtoOptional = produtoRepository.findById(produto_id);

        if (produtoOptional.isEmpty()) {
            logger.error("ERRO: Produto não encontrado!");
        }

        return produtoOptional;
    }

    @Transactional
    @Override
    public ProdutoModel save(SalvarProdutoDto salvarProdutoDto) {
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(salvarProdutoDto, produtoModel);

        produtoModel.setDataCriacao(LocalDateTime.now(ZoneId.of("America/Recife")));
        produtoModel.setDataAtualizacao(LocalDateTime.now(ZoneId.of("America/Recife")));

        return produtoRepository.save(produtoModel);
    }

    @Transactional
    @Override
    public ProdutoModel updatePut(ProdutoModel produtoModel, SalvarProdutoDto salvarProdutoDto) {
        produtoModel.setNome(salvarProdutoDto.nome());
        produtoModel.setValor(salvarProdutoDto.valor());
        produtoModel.setCategoriaProduto(salvarProdutoDto.categoriaProduto());
        produtoModel.setStatusProduto(salvarProdutoDto.statusProduto());

        produtoModel.setDataCriacao(LocalDateTime.now(ZoneId.of("America/Recife")));
        produtoModel.setDataAtualizacao(LocalDateTime.now(ZoneId.of("America/Recife")));

        return produtoRepository.save(produtoModel);
    }

    @Transactional
    @Override
    public void deleteProduto(ProdutoModel produtoModel) {
        produtoRepository.delete(produtoModel);
    }

    @Override
    public boolean existsByNome(String nome) {
        return produtoRepository.existsByNome(nome);
    }

    @Override
    public ProdutoModel atualizarCategoriaStatus(ProdutoModel produtoModel, AtualizarPatchProdutoDto atualizarPatchProdutoDto) {
        produtoModel.setNome(atualizarPatchProdutoDto.nome());
        produtoModel.setValor(atualizarPatchProdutoDto.valor());
        produtoModel.setCategoriaProduto(atualizarPatchProdutoDto.categoriaProduto());
        produtoModel.setStatusProduto(atualizarPatchProdutoDto.statusProduto());

        produtoModel.setDataAtualizacao(LocalDateTime.now(ZoneId.of("America/Recife")));

        return produtoRepository.save(produtoModel);
    }
}
