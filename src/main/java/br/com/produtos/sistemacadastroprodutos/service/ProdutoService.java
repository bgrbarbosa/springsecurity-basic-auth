package br.com.produtos.sistemacadastroprodutos.service;




import br.com.produtos.sistemacadastroprodutos.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoService {

    Produto insert(Produto produto);

    Page<Produto> findAll(Pageable pageable);

    Produto update(Produto produto);

    Optional<Produto> buscarPorId(UUID id);

    void delete(UUID id);

}
