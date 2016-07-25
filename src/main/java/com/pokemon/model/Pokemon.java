package com.pokemon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 963176444473159690L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpokemon")
	private Integer idPokemon;

	@Column(name = "color", nullable = false)
	private String color;

	@Column(name = "type")
	private String type;

	@Column(name = "name", nullable = false)
	private String name;

	public Pokemon() {
		// TODO Auto-generated constructor stub
	}

	public Pokemon(String color, String type, String name) {
		this.color = color;
		this.type = type;
		this.name = name;
	}

	public Integer getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(Integer idPokemon) {
		this.idPokemon = idPokemon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void update(String color, String name, String type) {
		this.color = color;
		this.name = name;
		this.type = type;
	}

}
