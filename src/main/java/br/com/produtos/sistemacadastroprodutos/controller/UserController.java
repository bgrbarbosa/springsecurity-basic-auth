package br.com.produtos.sistemacadastroprodutos.controller;


import br.com.produtos.sistemacadastroprodutos.dto.UserDto;
import br.com.produtos.sistemacadastroprodutos.entity.UserModel;
import br.com.produtos.sistemacadastroprodutos.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<UserDto>> listarUsuarios(){
        log.info("Consultando lista de usuários!!");
        List<UserDto>userModel = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userModel);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "userId") UUID userId){
        Optional<UserModel> userModel = userService.buscarPorId(userId);
        if(!userModel.isPresent()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        } else{
            return  ResponseEntity.status(HttpStatus.OK).body(userModel.get());
        }
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarUsuario(@RequestBody UserDto dto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(dto, userModel);

        if (userService.existsByUserName(dto.getUserName())){
            log.warn("Username {} is Already Taken ", dto.getUserName());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Username já existente");
        }

        if (userService.existsByEmail(dto.getEmail())){
            log.warn("Username {} is Already Taken ", dto.getEmail());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Email já existente");
        }
        userModel.setSenha(passwordEncoder.encode(dto.getSenha()));
        userService.insert(userModel);
        log.info("Registro: " + userModel + " criado com sucesso!!");
        return  ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }

    @PutMapping
    public ResponseEntity<Object>atualizarUsuario(@RequestBody UserDto userDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        if (!userService.buscarPorId(userModel.getUserId()).isPresent()){
            log.info("Registro não foi encontrado!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!!!");
        }else {
            userService.update(userModel);
            return  ResponseEntity.status(HttpStatus.CREATED).body(userModel);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object>deleteUser(@PathVariable(value = "id")UUID id){
        Optional<UserModel>userModel = userService.buscarPorId(id);
        if (!userModel.isPresent()) {
            log.info("Registro não foi encontrado!!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User não encontrado!!!");
        }else {
            userService.delete(id);
            log.info("Registro: " + id + " com sucesso!!");
            return ResponseEntity.status(HttpStatus.OK).body("User deletado com sucesso!!!");
        }
    }
}
