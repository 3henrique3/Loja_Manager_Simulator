package com.henrique.loja.controller;

import com.henrique.loja.dto.SalvarProdutoDto;
import com.henrique.loja.dto.AtualizarPatchProdutoDto;
import com.henrique.loja.model.ProdutoModel;
import com.henrique.loja.service.ProdutoService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    Logger logger = LogManager.getLogger(ProdutoController.class);

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProduto(@RequestBody @Valid SalvarProdutoDto salvarProdutoDto) {
        if (produtoService.existsByNome(salvarProdutoDto.nome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse nome para o produto já está em uso.");
        }

        logger.debug("POST: saveProduto, dados recebidos: {}", salvarProdutoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(salvarProdutoDto));
    }

    @GetMapping
    public ResponseEntity<List <ProdutoModel>> allProdutos() {
        List<ProdutoModel> listaProdutos = produtoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaProdutos);
    }

    @GetMapping("/{produto_id}")
    public ResponseEntity<Object> retornaUmProduto(@PathVariable(value = "produto_id") UUID produto_id) {
        logger.debug("GET: retornaUmProduto, consulta: {}", produto_id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.findById(produto_id));
    }

    @PutMapping("/{produto_id}")
    public ResponseEntity<Object> updatePut(@PathVariable(value = "produto_id") UUID produto_id, @RequestBody @Valid SalvarProdutoDto salvarProdutoDto) {
        logger.debug("PUT: updatePutProduto, produto_id recebido: {}", produto_id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.updatePut(produtoService.findById(produto_id).get(), salvarProdutoDto));
    }

    @PatchMapping("/{produto_id}")
    public ResponseEntity<Object> atualizarCategoriaStatus(@PathVariable(value = "produto_id") UUID produto_id, @RequestBody @Valid AtualizarPatchProdutoDto atualizarPatchProdutoDto) {
        logger.debug("PATCH: atualizarCategoriaStatus, produto_id recebido: {}", produto_id);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.atualizarCategoriaStatus(produtoService.findById(produto_id).get(), atualizarPatchProdutoDto));
    }

    @DeleteMapping("/{produto_id}")
    public ResponseEntity<Object> deleteProduto(@PathVariable(value = "produto_id") UUID produto_id) {
        Optional<ProdutoModel> acharProdutoId = produtoService.findById(produto_id);
        ProdutoModel produtoModel = acharProdutoId.get();

        produtoService.deleteProduto(produtoService.findById(produto_id).get());
        logger.debug("DELETE: deleteProduto, produto_id recebido: {}", produto_id);
        return ResponseEntity.noContent().build();
    }
}
