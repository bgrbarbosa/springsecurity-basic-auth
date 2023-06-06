package br.com.produtos.sistemacadastroprodutos.service.impl;

import br.com.produtos.sistemacadastroprodutos.entity.RoleModel;
import br.com.produtos.sistemacadastroprodutos.enums.RoleType;
import br.com.produtos.sistemacadastroprodutos.repository.RoleRepository;
import br.com.produtos.sistemacadastroprodutos.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<RoleModel> findByRoleName(RoleType roleType) {
        return roleRepository.findByRoleName(roleType);
    }

    @Override
    public Page<RoleModel> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }


}
