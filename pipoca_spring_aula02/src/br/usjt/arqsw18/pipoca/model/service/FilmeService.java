package br.usjt.arqsw18.pipoca.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw18.pipoca.model.dao.FilmeDAO;
import br.usjt.arqsw18.pipoca.model.entity.Filme;
@Service
public class FilmeService {	
	private FilmeDAO dao;
	
	@Autowired
	public FilmeService(FilmeDAO dao) {
	this.dao = dao;
	}
	
	public Filme buscarFilme(int id) throws IOException{
		return dao.buscarFilme(id);
	}
	
	public Filme inserirFilme(Filme filme) throws IOException {
		int id = dao.inserirFilme(filme);
		filme.setId(id);
		return filme;
	}

	public ArrayList<Filme> listarFilmes(String chave) throws IOException{
		return dao.listarFilmes(chave);
	}

	public ArrayList<Filme> listarFilmes() throws IOException{
		return dao.listarFilmes();
	}
	
	public void excluirFilme(Integer id) throws IOException{
		dao.excluirFilme(id);
	}
	
	public void updateFilme(Filme filme) throws IOException {
		System.out.print("Entrou na fService");
		dao.updateFilme(filme);
	}
	
	public ArrayList<Filme> listarPopulares(Integer inicio,Integer fim) throws IOException{
		return dao.listarPopulares(inicio, fim);
	}
	
	public ArrayList<Filme> porData(String chave,Integer periodo) throws IOException{
		Date data = new Date();
		Calendar calendar = Calendar.getInstance();
		if(chave.equals("ano")) {
			calendar.add(Calendar.YEAR,(periodo)*-1);
			calendar.set(Calendar.MONTH,0);
			calendar.set(Calendar.DAY_OF_MONTH,1);
		}
		else {
			calendar.add(Calendar.MONTH,-1*(periodo));
			calendar.set(Calendar.DAY_OF_MONTH,1);
		}
		data = calendar.getTime();
		System.out.println(data);
		return dao.porData(data); 
	}

}
