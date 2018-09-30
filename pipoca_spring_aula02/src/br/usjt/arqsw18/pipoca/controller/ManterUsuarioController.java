package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw18.pipoca.model.entity.Usuario;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;
import br.usjt.arqsw18.pipoca.model.service.GeneroService;
import br.usjt.arqsw18.pipoca.model.service.UsuarioService;

@Controller
public class ManterUsuarioController {

	private UsuarioService uService;
	
	@Autowired
	public ManterUsuarioController(UsuarioService uService){
		this.uService = uService;
	}
	
	@RequestMapping("/index")
	public String iniciar() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(Usuario usuario, BindingResult erros,HttpSession session)  throws IOException{
		System.out.println("CONTROLLER " + usuario);
		usuario = uService.login(usuario);
		
		if(usuario == null) {
			return "index";
		}else {
			session.setAttribute("usuario", usuario);
			return "ListarFilmes";	
		}
		
		
	}
}
