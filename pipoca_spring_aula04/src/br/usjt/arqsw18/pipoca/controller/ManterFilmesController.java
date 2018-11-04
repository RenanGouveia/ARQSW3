package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;	

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.entity.Genero;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;
import br.usjt.arqsw18.pipoca.model.service.GeneroService;

@Controller
public class ManterFilmesController {
	@Autowired
	private FilmeService fService;
	@Autowired
	private GeneroService gService;
	
	@Autowired
	private ServletContext  servletContext;

	@RequestMapping("index")
	public String iniciar() {
		return "index";
	}

	@RequestMapping("/novo_filme")
	public String novo(Model model, HttpSession session) {
		try {
			List<Genero> generos = gService.listarGeneros();
			session.setAttribute("generos", generos);
			return "CriarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/criar_filme")
	public String criarFilme(Filme filme, BindingResult erros, Model model,
			@RequestParam("posterPath1") MultipartFile posterPath) {
		try {
				Genero genero = new Genero();
				genero.setId(filme.getGenero().getId());
				genero.setNome(gService.buscarGenero(genero.getId()).getNome());
				filme.setGenero(genero);
				System.out.println("Genero: " + genero);
				filme = fService.inserirFilme(filme);
				fService.gravarImagem(servletContext, filme, posterPath);				
				model.addAttribute("filme", filme);
				return "VisualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@RequestMapping("/reiniciar_lista")
	public String reiniciarLista(HttpSession session) {
		session.setAttribute("lista", null);
		return "ListarFilmes";
	}

	@RequestMapping("/listar_filmes")
	public String listarFilmes(HttpSession session, Model model, String chave) {
		try {

			List<Filme> lista;
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

	@RequestMapping("/visualizar_filme")
	public String visualizarFilme(Filme filme, Model model) {
		try {
			filme = fService.buscarFilme(filme.getId());
			model.addAttribute("filme", filme);
			return "VisualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/visualizar/{id}")
	public String visualizarLista(@PathVariable Integer id,Filme filme, Model model) throws IOException {
		filme = fService.buscarFilme(id);
		model.addAttribute("filme",filme);
		return "VisualizarFilme";
	}
	
	
	
	@RequestMapping("/excluir_filme")
	public String excluirFilme(Integer id) throws IOException {
		fService.excluirFilme(id);
		return "redirect:/listar_filmes";
	}
	
	private List<Filme> removerDaLista(Filme filme, List<Filme> filmes){
		for(int i = 0; i < filmes.size(); i++) {
			if(filme.getId() == filmes.get(i).getId()) {
				filmes.remove(i);
				break;
			}
		}
		return filmes;
	}
	
	private List<Filme> atualizarDaLista(Filme filme, List<Filme> filmes){
		for(int i = 0; i < filmes.size(); i++) {
			if(filme.getId() == filmes.get(i).getId()) {
				filmes.remove(i);
				filmes.add(i, filme);
				break;
			}
		}
		return filmes;
	}
	
	@RequestMapping("/alterar_filme")
	public String atualizar(Filme filme, Model model, HttpSession session) {
		try {
			List<Genero> generos = gService.listarGeneros();
			session.setAttribute("generos", generos);
			filme = fService.buscarFilme(filme.getId());
			model.addAttribute("filme", filme);
			return "AtualizarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@RequestMapping("/atualizar_filme")
	public String gravarAtualizacaoFilme(@Valid Filme filme, BindingResult erros, Model model, HttpSession session) {
		try {
			if (!erros.hasErrors()) {
				Genero genero = new Genero();
				genero.setId(filme.getGenero().getId());
				genero.setNome(gService.buscarGenero(genero.getId()).getNome());
				filme.setGenero(genero);

				fService.atualizarFilme(filme);

				model.addAttribute("filme", filme);
				List<Filme> filmes = (List<Filme>) session.getAttribute("lista");
				session.setAttribute("lista", atualizarDaLista(filme, filmes));

				return "VisualizarFilme";
			} else {
				return "AtualizarFilme";
			}
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	
	@RequestMapping("/atualizar")
	public String atualizarFilme(Filme filme,Model model,
			@RequestParam("posterPath") MultipartFile file) throws IOException {
		
		fService.atualizarFilme(filme);
		fService.gravarImagem(servletContext, filme, file);
		filme = fService.buscarFilme(filme.getId());
		System.out.println(filme);
		model.addAttribute("Filme",filme);
		return "redirect:/visualizar_filme/"+ filme.getId();
		
	}

	@RequestMapping("/carregar_filmes")
	public String carregarFilme() {
		
		try {
			fService.carregarFilmes();
			return "redirect:listar_filmes";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";
				
	}
	
	@RequestMapping("/popularidade")
	public String porPopularidade(Model model) throws IOException {
		List<Filme> filmes1 = fService.listarPopulares(0.0,30.0);
		List<Filme> filmes2 = fService.listarPopulares(31.0,50.0);
		List<Filme> filmes3 = fService.listarPopulares(51.0,60.0);
		List<Filme> filmes4 = fService.listarPopulares(61.0,80.0);
		List<Filme> filmes5 = fService.listarPopulares(81.0,100.0);
		model.addAttribute("filmes1",filmes1);
		model.addAttribute("filmes2",filmes2);
		model.addAttribute("filmes3",filmes3);
		model.addAttribute("filmes4",filmes4);
		model.addAttribute("filmes5",filmes5);
		return "Populares";
	}	
	
	
}
