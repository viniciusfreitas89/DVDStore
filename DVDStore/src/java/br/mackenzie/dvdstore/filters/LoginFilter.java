package br.mackenzie.dvdstore.filters;

import br.mackenzie.dvdstore.managedbean.LoginManagedBean;
import br.mackenzie.dvdstore.vo.PessoaVO;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        System.out.println("LoginFilter Inicializado");
    }
    
    @Transactional
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        LoginManagedBean vo = (LoginManagedBean) request.getSession().getAttribute("loginManagedBean");
        if (vo == null){
            response.sendRedirect("login.xhtml");
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
