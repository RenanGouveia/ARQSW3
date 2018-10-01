package br.usjt.arqsw18.pipoca;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter{
	
	@Override
    public boolean preHandle(HttpServletRequest request, 
            HttpServletResponse response,
            Object controller) throws Exception {

            String uri = request.getRequestURI();
            if(uri.endsWith("/") ||
                    uri.endsWith("logar")){
                return true;
            }

            if(request.getSession()
                    .getAttribute("usuario") != null) {
                return true;
            }

            response.sendRedirect("/pipoca_spring_aula04/");
            return false;
    }
}