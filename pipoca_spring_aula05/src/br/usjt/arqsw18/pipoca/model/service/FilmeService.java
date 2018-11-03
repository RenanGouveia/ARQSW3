package br.usjt.arqsw18.pipoca.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.usjt.arqsw18.pipoca.model.dao.FilmeDAO;
import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.entity.Genero;

@Service
public class FilmeService {
	private FilmeDAO dao;
	public static final String apiKey = "9db7c03c5b831c2c9aec1a0645bfc617";
	public static final String URL = "https://api.themoviedb.org/3/movie/popular?api_key="+apiKey+"&language=en-US";
	public static final String img = "https://image.tmdb.org/t/p/w500";
	private GeneroService gs;
	
	@Autowired
	public FilmeService(FilmeDAO fdao, GeneroService gs) {
		dao = fdao;
		gs = gs;
	}
	
	public Filme buscarFilme(int id) throws IOException{
		return dao.buscarFilme(id);
	}
	
	@Transactional
	public Filme inserirFilme(Filme filme) throws IOException {
		int id = dao.inserirFilme(filme);
		filme.setId(id);
		return filme;
	}
	
	@Transactional
	public void excluirFilme(Filme filme) throws IOException {
		dao.removerFilme(filme);
	}
	
	@Transactional
	public void atualizarFilme(Filme filme) throws IOException {
		dao.atualizarFilme(filme);
	}

	public List<Filme> listarFilmes(String chave) throws IOException{
		return dao.listarFilmes(chave);
	}

	public List<Filme> listarFilmes() throws IOException{
		return dao.listarFilmes();
	}
	
	@Transactional
	public void carregarFilmes() throws IOException {
		RestTemplate rt = new RestTemplate();
		
		ResultadoTMDb resultado = rt.getForObject(URL,ResultadoTMDb.class);
		System.out.println(resultado);
		System.out.println("----------------------");
		ArrayList<FilmeTMDb> lista = resultado.getResults();
		
		for(FilmeTMDb filmeTMDb:lista) {
			Filme filme = new Filme();
			
			filme.setTitulo(filmeTMDb.getTitle());
			filme.setDescricao(filmeTMDb.getOverview());
			filme.setPopularidade(filmeTMDb.getPopularity());
			filme.setPosterPath(filmeTMDb.getPoster_path());
			System.out.println("Antes Popularidade");
			filme.setPopularidade(10.0);
			System.out.println("Popularidade: " + filme.getPopularidade());
			System.out.println("Depois Popularidade");
			Genero genero = gs.buscarGenero(filmeTMDb.getGenre_ids()[1]);
			System.out.println("Gênero ID" + genero);			
			filme.setGenero(genero);
			dao.inserirFilme(filme);
		
		}
	}
}
