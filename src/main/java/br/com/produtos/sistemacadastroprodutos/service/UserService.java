package br.com.produtos.sistemacadastroprodutos.service;

import br.com.produtos.sistemacadastroprodutos.dto.UserDto;
import br.com.produtos.sistemacadastroprodutos.entity.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserModel insert(UserModel user);

    List<UserDto>findAll();

    UserModel update(UserModel user);

    Optional<UserModel> buscarPorId(UUID id);

    void delete(UUID id);

    boolean existsByUserName(String username);

    boolean existsByEmail(String email);
}
