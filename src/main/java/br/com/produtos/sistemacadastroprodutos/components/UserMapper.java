package br.com.produtos.sistemacadastroprodutos.components;

import java.util.ArrayList;
import java.util.List;


import br.com.produtos.sistemacadastroprodutos.dto.UserDto;
import br.com.produtos.sistemacadastroprodutos.entity.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;



@Component
public class UserMapper {
	
	private final ModelMapper modelMapper = new ModelMapper();
	
    
	public List<UserDto> toDto(List<UserModel> users) {
    	
    	List<UserModel>listUsers = new ArrayList<>();
    	List<UserDto>listUsersDto = new ArrayList<>();
    	for (int i=0; i<users.size();i++) {
    		listUsersDto.add(modelMapper.map(users.get(i), UserDto.class));
    	}
    	return listUsersDto;
    }

    public List<UserModel>toEntity(List<UserDto> usersDto) {
    	
    	List<UserModel>listUsers = new ArrayList<>();
    	List<UserDto>listUsersDto = new ArrayList<>();
    	for (int i=0; i<usersDto.size();i++) {
    		listUsers.add(modelMapper.map(usersDto.get(i), UserModel.class));
    	}
    	return listUsers;
    }

}
