package br.com.springboot.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.ws.model.FootballMatch;



public interface FootballMatchRepository extends JpaRepository<FootballMatch, String>{

	FootballMatchRepository findByCodigo(long codigo);

	
}
