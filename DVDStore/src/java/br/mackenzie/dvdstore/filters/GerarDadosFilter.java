package br.mackenzie.dvdstore.filters;

import br.mackenzie.dvdstore.dao.GenerosDAO;
import br.mackenzie.dvdstore.dao.MidiaDAO;
import br.mackenzie.dvdstore.vo.GenerosVO;
import br.mackenzie.dvdstore.vo.MidiaVO;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
public class GerarDadosFilter implements Filter {
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
        GenerosDAO gDao = new GenerosDAO(em);
        List<GenerosVO> generos = gDao.findAll(10, 0);
        MidiaDAO dao = new MidiaDAO(em);
//        for (MidiaVO vo : (List<MidiaVO>)dao.findAll()){
//            dao.delete(vo);
//        }
        List<MidiaVO> list2 = dao.findAll();
        if (list2.isEmpty()){
            Random randomGenerator = new Random();
            List<MidiaVO> list = Arrays.asList(
                            new MidiaVO("Guerra Mundial Z", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",20.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("CAMINHANDO COM DINOSSAUROS", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",25.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("Caça aos Gângsteres", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",22.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("Mama", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",24.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("O Último Desafio", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",21.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("João e Maria Caçadores de Bruxas", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",28.50f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("Guerra Mundial Z", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",20.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("CAMINHANDO COM DINOSSAUROS", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",25.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("Caça aos Gângsteres", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",22.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("Mama", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",24.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("O Último Desafio", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",21.00f, generos.get(randomGenerator.nextInt(generos.size()))),
                            new MidiaVO("João e Maria Caçadores de Bruxas", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",28.50f, generos.get(randomGenerator.nextInt(generos.size())))
                            );
            
            for (MidiaVO vo : list){
                dao.create(vo);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
