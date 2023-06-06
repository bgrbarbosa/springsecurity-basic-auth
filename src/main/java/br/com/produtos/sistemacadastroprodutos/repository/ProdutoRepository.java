package br.com.produtos.sistemacadastroprodutos.repository;



import br.com.produtos.sistemacadastroprodutos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
