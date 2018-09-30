package br.usjt.arqsw18.pipoca.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw18.pipoca.model.dao.GeneroDAO;
import br.usjt.arqsw18.pipoca.model.entity.Genero;


@Service
public class GeneroService {
	
	@Autowired
	private GeneroDAO dao;
	
	public Genero buscarGenero(int id) throws IOException {
		return dao.buscarGenero(id);
	}
	
	public List<Genero> listarGeneros() throws IOException{
		return dao.listarGeneros();
	}
	
	public List<Genero> listaGenFilmes() throws IOException{
		
		List <Genero> generos = dao.listarGeneros();
		System.out.println(generos);
		
		for(int i = 0; i<generos.size();i++ ) {
		
			generos.get(i).setFilmes(dao.listarFilmes(generos.get(i))); 
		}
		
		return generos;
	}
}
