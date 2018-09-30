package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.entity.Genero;
import br.usjt.arqsw18.pipoca.model.entity.Usuario;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;
import br.usjt.arqsw18.pipoca.model.service.GeneroService;
import br.usjt.arqsw18.pipoca.model.service.UsuarioService;

@Controller
public class ManterFilmesController {
	private FilmeService fService;
	private GeneroService gService;
	private UsuarioService uService;

	@Autowired
	public ManterFilmesController(FilmeService fService, GeneroService gService, UsuarioService uService) {
		this.fService = fService;
		this.gService = gService;
		this.uService = uService;
	}
	
	@RequestMapping("/home")
	public String iniciar() {
		return "ListarFilmes";
	}
	@RequestMapping("/novo_filme")
	public String novo(Model model) {
		try {
			this.gService = gService;
			ArrayList<Genero> generos = gService.listarGeneros();
			model.addAttribute("generos", generos);
			return "CriarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/criar_filme")
	public String criarFilme(Filme filme, Model model) {
		try {
			
			Genero genero = new Genero();
			genero.setId(filme.getGenero().getId());
			genero.setNome(gService.buscarGenero(genero.getId()).getNome());
			filme.setGenero(genero);

			filme = fService.inserirFilme(filme);

			model.addAttribute("filme", filme);

			return "VisualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/visualizar_filme/{id}")
	public String visualizarLista(@PathVariable Integer id,Filme filme, Model model) throws IOException {
		filme = fService.buscarFilme(id);
		model.addAttribute("filme",filme);
		return "VisualizarFilme";
	}

	@RequestMapping("/reiniciar_lista")
	public String reiniciarLista(HttpSession session) {
		session.setAttribute("lista", null);
		return "ListarFilmes";
	}

	@RequestMapping("/listar_filmes")
	public String listarFilmes(HttpSession session, Model model, String chave, Usuario usuario) {
		try {
			
			ArrayList<Filme> lista;
			if (chave != null && chave.length() > 0) {
				lista = fService.listarFilmes(chave);
			} else {
				lista = fService.listarFilmes();
			}
			
			session.setAttribute("lista", lista);
			return "ListarFilmes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/excluir_filme")
	public String excluirFilme(Integer id) throws IOException {
		fService.excluirFilme(id);
		return "redirect:/listar_filmes";
	}
	
	@RequestMapping("/alterar_filme/{id}")
	public String editarFilme(@PathVariable Integer id,Filme filme,Model model,BindingResult errors) throws IOException {
			filme = fService.buscarFilme(id);
			ArrayList<Genero> generos = gService.listarGeneros();
			model.addAttribute("filme",filme);
			model.addAttribute("generos",generos);
			return "EditarFilme";
	}
	
	@RequestMapping("/atualizar_filme")
	public String atualizarFilme(Filme filme,Model model) throws IOException {
		fService.updateFilme(filme);
		filme = fService.buscarFilme(filme.getId());
		System.out.println(filme);
		model.addAttribute("Filme",filme);
		return "pipoca_spring_aula02/visualizar_filme/"+ filme.getId();
		
	}
	
	@RequestMapping("/generos")
	public String porGeneros(Model model) throws IOException {
		ArrayList <Genero> porGeneros = gService.listaGenFilmes();
		model.addAttribute("porGeneros",porGeneros);
		return "Generos";
	}
	
	@RequestMapping("/popularidade")
	public String porPopularidade(Model model) throws IOException {
		ArrayList<Filme> filmes1 = fService.listarPopulares(0,30);
		ArrayList<Filme> filmes2 = fService.listarPopulares(31,50);
		ArrayList<Filme> filmes3 = fService.listarPopulares(51,60);
		ArrayList<Filme> filmes4 = fService.listarPopulares(61,80);
		ArrayList<Filme> filmes5 = fService.listarPopulares(81,100);
		model.addAttribute("filmes1",filmes1);
		model.addAttribute("filmes2",filmes2);
		model.addAttribute("filmes3",filmes3);
		model.addAttribute("filmes4",filmes4);
		model.addAttribute("filmes5",filmes5);
		return "Popularidade";
	}
	
	@RequestMapping("/dtLancamentos")
	public String porDtLancamento(Model model) throws IOException {
		
		ArrayList<Filme> filmesAno = fService.porData("ano",1);
		
		ArrayList<Filme> filmesPenultimo = fService.porData("ano",2);
		ArrayList<Filme> filmesMes = fService.porData("mes",1);
		model.addAttribute("filmesAno",filmesAno);
		model.addAttribute("filmesMes",filmesMes);
		model.addAttribute("filmesPenultimo",filmesPenultimo);
		return "DataLancamento";
	}
	

}
