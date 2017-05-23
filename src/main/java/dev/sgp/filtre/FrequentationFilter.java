package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

@WebFilter(urlPatterns = { "/*" }, description = "Filtre pour compter le nombre de vues")
public class FrequentationFilter implements Filter {
	
	private VisiteWebService visiteService = Constantes.VISITE_SERVICE;
	

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
		throws IOException, ServletException {
		
		String path = ((HttpServletRequest) req).getRequestURI();
		
		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();
		
		visiteService.sauvegarderVisite(new VisiteWeb(path, after - before));
		
	}

	@Override
	public void destroy() {}

}