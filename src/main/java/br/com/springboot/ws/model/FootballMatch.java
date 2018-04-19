package br.com.springboot.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Roberto Duré
 * 19/04/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class FootballMatch extends ResourceSupport{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@NotBlank
	private String nomeClubeMandante;
	
	@NotBlank
	private String nomeClubeVisitante;
	
	@NotBlank
	private String local;
	
	@NotBlank
	private String data;
	
	@NotBlank
	private String horario;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNomeClubeMandante() {
		return nomeClubeMandante;
	}

	public void setNomeClubeMandante(String nomeClubeMandante) {
		this.nomeClubeMandante = nomeClubeMandante;
	}

	public String getNomeClubeVisitante() {
		return nomeClubeVisitante;
	}

	public void setNomeClubeVisitante(String nomeClubeVisitante) {
		this.nomeClubeVisitante = nomeClubeVisitante;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
}
