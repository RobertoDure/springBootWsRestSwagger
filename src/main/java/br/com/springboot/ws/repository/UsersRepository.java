package br.com.springboot.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.ws.model.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

	Users findByNome(String nome);
}
