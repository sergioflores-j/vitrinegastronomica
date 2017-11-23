package br.com.vitrinegastronomica.servlets;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/advertiser/*")
public class AdvertiserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {    
	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    HttpSession session = request.getSession(false);
	    String loginURI = request.getContextPath() + "/user/login.xhtml";

	    boolean loggedIn = session != null && session.getAttribute("advertiser") != null;
	    boolean loginRequest = request.getRequestURI().equals(loginURI);
	    boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

	    if (loggedIn || loginRequest || resourceRequest) {
	        chain.doFilter(request, response);
	    } else {
	        response.sendRedirect(loginURI);
	    }
	}
	
}
