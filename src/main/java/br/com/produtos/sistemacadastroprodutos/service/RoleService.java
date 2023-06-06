package br.com.produtos.sistemacadastroprodutos.service;

import br.com.produtos.sistemacadastroprodutos.entity.Produto;
import br.com.produtos.sistemacadastroprodutos.entity.RoleModel;
import br.com.produtos.sistemacadastroprodutos.enums.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<RoleModel> findByRoleName(RoleType roleType);

    Page<RoleModel> findAll(Pageable pageable);
}
