package br.com.produtos.sistemacadastroprodutos.config;

import br.com.produtos.sistemacadastroprodutos.entity.UserModel;
import br.com.produtos.sistemacadastroprodutos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = repository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado: " + username));
        return UserDetailsImpl.build(userModel);
    }

}
