package br.com.produtos.sistemacadastroprodutos.service.impl;




import br.com.produtos.sistemacadastroprodutos.entity.Produto;
import br.com.produtos.sistemacadastroprodutos.repository.ProdutoRepository;
import br.com.produtos.sistemacadastroprodutos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository repository;

    @Override
    public Produto insert(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public Page<Produto> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Produto update(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }


}
