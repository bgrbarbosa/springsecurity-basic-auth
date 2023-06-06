package br.com.produtos.sistemacadastroprodutos.repository;

import br.com.produtos.sistemacadastroprodutos.entity.RoleModel;
import br.com.produtos.sistemacadastroprodutos.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleModel, UUID> {
      Optional<RoleModel>findByRoleName(RoleType roleType);
}
