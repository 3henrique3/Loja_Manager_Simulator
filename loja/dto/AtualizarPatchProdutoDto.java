package com.henrique.loja.dto;

public record AtualizarPatchProdutoDto (
  String nome,

  @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que 0.0 (zero).")
  Double valor,

  CategoriaProduto categoriaProduto,

  StatusProduto statusProduto
){}