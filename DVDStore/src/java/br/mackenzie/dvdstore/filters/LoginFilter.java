package br.mackenzie.dvdstore.filters;

import br.mackenzie.dvdstore.managedbean.LoginManagedBean;
import br.mackenzie.dvdstore.services.PessoaService;
import java.io.IOException;
import javax.ejb.EJB;
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
    @EJB
    private PessoaService bean;
    
    @Override
    public void init(FilterConfig filterConfig) {        
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
        if (vo == null || 
            vo.getPessoa()==null || 
            vo.getPessoa().getId() == null || 
            bean.procurar(vo.getPessoa().getId()) == null ){
            response.sendRedirect("login.xhtml");
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
