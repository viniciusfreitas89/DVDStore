package br.mackenzie.dvdstore.filters;

import br.mackenzie.dvdstore.dao.MidiaDAO;
import br.mackenzie.dvdstore.vo.MidiaVO;
import com.sun.xml.ws.api.tx.at.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Vinicius
 */
public class GerarDadosFilter implements Filter {
    @PersistenceContext()
    private EntityManager em;
    @Resource 
    private UserTransaction utx; 
    
    private FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        
        System.out.println("EM: "+em);
        System.out.println("GerarDadosFilter Inicializado");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        try {            
            utx.begin();
            inserirMidias();
            utx.commit();
            chain.doFilter(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GerarDadosFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inserirMidias(){
        MidiaDAO dao = new MidiaDAO(em);
//        for (MidiaVO vo : (List<MidiaVO>)dao.findAll()){
//            dao.delete(vo);
//        }
//        List<MidiaVO> list2 = dao.findAll();
//        if (list2.isEmpty()){
            List<MidiaVO> list = Arrays.asList(
                            new MidiaVO("Guerra Mundial Z", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",20.00f),
                            new MidiaVO("CAMINHANDO COM DINOSSAUROS", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",25.00f),
                            new MidiaVO("Caça aos Gângsteres", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",22.00f),
                            new MidiaVO("Mama", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",24.00f),
                            new MidiaVO("O Último Desafio", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",21.00f),
                            new MidiaVO("João e Maria Caçadores de Bruxas", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",28.50f),
                            new MidiaVO("Guerra Mundial Z", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",20.00f),
                            new MidiaVO("CAMINHANDO COM DINOSSAUROS", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",25.00f),
                            new MidiaVO("Caça aos Gângsteres", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",22.00f),
                            new MidiaVO("Mama", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",24.00f),
                            new MidiaVO("O Último Desafio", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",21.00f),
                            new MidiaVO("João e Maria Caçadores de Bruxas", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",28.50f)
                            );
            
            for (MidiaVO vo : list){
                dao.create(vo);
            }
//        }
    }

    @Override
    public void destroy() {
    }
}
