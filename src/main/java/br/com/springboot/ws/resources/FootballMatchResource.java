package br.com.springboot.ws.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.ws.model.FootballMatch;
import br.com.springboot.ws.repository.FootballMatchRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST Match")
@RestController
@RequestMapping("/match")
public class FootballMatchResource {

	@Autowired
	private FootballMatchRepository rep;
	
	@ApiOperation(value="Return a list of match")
	@GetMapping(produces="application/json")
	public @ResponseBody  ArrayList<FootballMatch> listaMatch(){
		List<FootballMatch> listFootballMatch =  rep.findAll();
		ArrayList<FootballMatch> matchs = new ArrayList<FootballMatch>();
		for(FootballMatch match : listFootballMatch){
			long codigo = match.getCodigo();
			match.add(linkTo(methodOn(FootballMatchResource.class).match(codigo)).withSelfRel());
			matchs.add(match);
		}
		return matchs;
	}
	
	@ApiOperation(value="Return an especific match")
	@GetMapping(value="/{codigo}", produces="application/json")
	public @ResponseBody FootballMatch match(@PathVariable(value="codigo") long codigo){
		FootballMatch match = (FootballMatch) rep.findByCodigo(codigo);
		match.add(linkTo(methodOn(FootballMatchResource.class).listaMatch()).withRel("Lista de Partidas"));
		return match;
	}
	
	@ApiOperation(value="Save a match")
	@PostMapping()
	public FootballMatch cadastraEvento(@RequestBody @Valid FootballMatch match){
		rep.save(match);
		long codigo = match.getCodigo();
		match.add(linkTo(methodOn(FootballMatchResource.class).match(codigo)).withSelfRel());
		return match;
	}
	
	@ApiOperation(value="Delete a match")
	@DeleteMapping()
	public FootballMatch deletaEvento(@RequestBody FootballMatch match){
		rep.delete(match);
		return match;
	}

}
