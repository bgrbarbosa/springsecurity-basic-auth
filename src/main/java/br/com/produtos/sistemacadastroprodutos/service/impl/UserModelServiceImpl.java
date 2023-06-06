package br.com.produtos.sistemacadastroprodutos.service.impl;

import br.com.produtos.sistemacadastroprodutos.components.UserMapper;
import br.com.produtos.sistemacadastroprodutos.dto.UserDto;
import br.com.produtos.sistemacadastroprodutos.entity.UserModel;
import br.com.produtos.sistemacadastroprodutos.repository.UserRepository;
import br.com.produtos.sistemacadastroprodutos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserModelServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;

    private List<UserDto> users = new ArrayList<>();

    @Override
    public UserModel insert(UserModel user) {
        return repository.save(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<UserModel>users = repository.findAll();
        return mapper.toDto(users);
    }


    @Override
    public UserModel update(UserModel user) {
        return repository.save(user);
    }

    @Override
    public Optional<UserModel> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsByUserName(String username) {
        return repository.existsByUserName(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
