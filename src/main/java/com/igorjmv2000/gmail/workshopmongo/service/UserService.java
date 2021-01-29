package com.igorjmv2000.gmail.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igorjmv2000.gmail.workshopmongo.domain.User;
import com.igorjmv2000.gmail.workshopmongo.dto.UserDTO;
import com.igorjmv2000.gmail.workshopmongo.repositories.UserRepository;
import com.igorjmv2000.gmail.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User entity) {
		return repository.insert(entity);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User entity) {
		User newEntity = repository.findById(entity.getId()).get();
		updateData(newEntity, entity);
		return repository.save(newEntity);
	}
	
	private void updateData(User newEntity, User entity) {
		newEntity.setName(entity.getName());
		newEntity.setEmail(entity.getEmail());
	}

	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}
}
