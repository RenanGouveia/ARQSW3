package br.usjt.arqsw18.pipoca.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
	HttpServletResponse response,
	Object controller) throws Exception {
		
		String uri = request.getRequestURI();
		if(uri.endsWith("index") || uri.endsWith("login")){
				return true;
		}
		if(request.getSession().getAttribute("usuario") != null) {
			return true;
		}
		
		response.sendRedirect("/pipoca_spring_aula02/index");
		return false;
	}

}
