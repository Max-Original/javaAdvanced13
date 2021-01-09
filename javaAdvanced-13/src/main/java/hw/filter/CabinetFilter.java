package hw.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import hw.domain.UserRole;
import hw.shared.FilterService;


@WebFilter("/welcomeToTheCabinet.jsp")
public class CabinetFilter implements Filter {

	private FilterService filterService = FilterService.getFilterService();
    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		filterService.doFilterValidation(request, response, chain, Arrays.asList(UserRole.USER , UserRole.ADMINISTRATOR));
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

//http://localhost:8080/javaAdvanced-10/welcomeToTheCabinet.jsp
//http://localhost:8080/javaAdvanced-10/product?id=1
//http://localhost:8080/javaAdvanced-10/createProduct.jsp
//http://localhost:8080/javaAdvanced-10/basket.jsp