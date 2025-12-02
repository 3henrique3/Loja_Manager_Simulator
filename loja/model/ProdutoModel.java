package com.henrique.loja.model;

import com.henrique.loja.enums.CategoriaProduto;
import com.henrique.loja.enums.StatusProduto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "produtos")
public class ProdutoModel implements Serializable {
    @Serial
    private static final long serialVersionUid = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoriaProduto", nullable = false)
    private CategoriaProduto categoriaProduto;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusProduto", nullable = false)
    private StatusProduto statusProduto;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @CreationTimestamp
    @Column(name = "data_atualizacao", nullable = false, updatable = false)
    private LocalDateTime dataAtualizacao;
}
