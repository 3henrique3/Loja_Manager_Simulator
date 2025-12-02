package com.henrique.loja.dto;

import com.henrique.loja.enums.CategoriaProduto;
import com.henrique.loja.enums.StatusProduto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SalvarProdutoDto (
  UUID id,

  @NotNull
  @NotBlank(message = "É necessário informar o nome do produto.")
  String nome,

  @NotNull(message = "É necessário informar o valor do produto.")
  @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que 0.0 (zer0).")
  double valor,

  @NotNull(message = "É obrigatório informar a categoria do produto.")
  CategoriaProduto categoriaProduto,

  @NotNull(message = "É necessário informar os status do produto.")
  StatusProduto statusProduto
){}
