package br.mackenzie.dvdstore.filters;

import br.mackenzie.dvdstore.dao.MidiaDAO;
import br.mackenzie.dvdstore.vo.MidiaVO;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author Vinicius
 */
public class LoginFilter implements Filter {
    @PersistenceContext()
    private EntityManager em;
    
    private FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        
        System.out.println("EM: "+em);
        System.out.println("GerarDadosFilter Inicializado");
    }
    
    @Transactional
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        inserirMidias();
        
        chain.doFilter(request, response);
    }

    private void inserirMidias(){
    }

    @Override
    public void destroy() {
    }
}
