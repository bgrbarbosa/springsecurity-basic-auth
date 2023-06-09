package br.com.produtos.sistemacadastroprodutos.controller;


import br.com.produtos.sistemacadastroprodutos.entity.RoleModel;
import br.com.produtos.sistemacadastroprodutos.service.RoleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@Log4j2
public class RolesController {

    @Autowired
    RoleService service;

    @GetMapping
    public ResponseEntity<Page<RoleModel>> listarRoles(@PageableDefault(page = 0, size = 10,
            sort = "roleName", direction = Sort.Direction.ASC) Pageable pageable){
        log.info("Consultando lista de roles!!");
        Page<RoleModel> roleModel = service.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(roleModel);
    }


}
