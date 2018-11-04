package br.usjt.arqsw18.pipoca.model.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Genero {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(max=60)
	private String nome;
	
		
	private ArrayList<Filme> filmes;	
	
	public ArrayList<Filme> getFilmes() {
		return filmes;
	}
	
	public void setFilmes(ArrayList<Filme> list) {
		this.filmes = list;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Genero [id=" + id + ", nome=" + nome + "]";
	}
	
}
