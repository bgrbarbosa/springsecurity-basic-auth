package br.com.produtos.sistemacadastroprodutos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduto;

    @Column(nullable = false)
    private String descProduto;

    @Column(nullable = false)
    private String catProduto;

    @Column(nullable = false)
    private double precoProduto;

    @Column(nullable = false)
    private String codBarras;
}
