package br.com.springboot.ws.auth.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import br.com.springboot.ws.model.Users;
import br.com.springboot.ws.repository.UsersRepository;


@Repository
public class DetailsServiceAPL  implements UserDetailsService{

	@Autowired
	private UsersRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Users user = ur.findByNome(nome);
		
	    if (user == null) {
	      throw new UsernameNotFoundException("User not found");
	    }
		return user;
	}
	

}
