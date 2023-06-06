package br.com.produtos.sistemacadastroprodutos.repository;

import br.com.produtos.sistemacadastroprodutos.entity.UserModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends JpaRepository<UserModel, UUID> {

    boolean existsByUserName(String username);
    boolean existsByEmail(String email);

    @EntityGraph(attributePaths = "roles", type = EntityGraph.EntityGraphType.FETCH)
    Optional<UserModel> findByUserName(String username);
}
