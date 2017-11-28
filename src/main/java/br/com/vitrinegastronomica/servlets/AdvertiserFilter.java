package br.com.vitrinegastronomica.servlets;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AdvertiserFilter", urlPatterns = { "/advertiser/*" })
public class AdvertiserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub  "/advertiser/*"

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws ServletException, IOException {
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

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
