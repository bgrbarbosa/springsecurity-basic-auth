package br.com.produtos.sistemacadastroprodutos.dto;

import br.com.produtos.sistemacadastroprodutos.entity.RoleModel;
import br.com.produtos.sistemacadastroprodutos.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private UUID userId;
    private String userName;
    private String email;
    private String senha;
    private UserType userType;

    private Set<RoleModel> roles = new HashSet<>();
}
