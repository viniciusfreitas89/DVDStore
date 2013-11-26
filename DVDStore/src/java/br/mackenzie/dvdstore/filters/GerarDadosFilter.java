package br.mackenzie.dvdstore.filters;

import br.mackenzie.dvdstore.dao.AtorDAO;
import br.mackenzie.dvdstore.dao.GenerosDAO;
import br.mackenzie.dvdstore.dao.IdiomaDAO;
import br.mackenzie.dvdstore.dao.MidiaDAO;
import br.mackenzie.dvdstore.dao.PessoaDAO;
import br.mackenzie.dvdstore.services.PessoaService;
import br.mackenzie.dvdstore.entity.AtorVO;
import br.mackenzie.dvdstore.entity.GenerosVO;
import br.mackenzie.dvdstore.entity.IdiomaVO;
import br.mackenzie.dvdstore.entity.MidiaVO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
    
    String path;
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
        
        path = request.getRealPath("resources/images");
        
        inserirMidias();
        
        
        chain.doFilter(request, response);
    }

    private void inserirMidias(){
        GenerosDAO gDao = new GenerosDAO(em);
        List<GenerosVO> generos = gDao.findAll(10, 0);
        MidiaDAO dao = new MidiaDAO(em);
        
        
        
        List<MidiaVO> list2 = dao.findAll();
        if (list2.isEmpty()){
            List<byte[]> listaBt = new ArrayList<byte[]>();
            try {
                listaBt.add(read(new File(path+"/1.jpg")));
                listaBt.add(read(new File(path+"/2.jpg")));
                listaBt.add(read(new File(path+"/3.jpg")));
            } catch (IOException ex) {
                Logger.getLogger(GerarDadosFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Random randomGenerator = new Random();
            List<MidiaVO> list = Arrays.asList(
                            new MidiaVO("Guerra Mundial Z", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",20.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas(), gerarImg(listaBt)),
                            new MidiaVO("CAMINHANDO COM DINOSSAUROS", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",25.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas(), gerarImg(listaBt)),
                            new MidiaVO("Caça aos Gângsteres", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",22.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas()),
                            new MidiaVO("Mama", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",24.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas(), gerarImg(listaBt)),
                            new MidiaVO("O Último Desafio", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",21.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas()),
                            new MidiaVO("João e Maria Caçadores de Bruxas", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",28.50f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas()),
                            new MidiaVO("Guerra Mundial Z", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",20.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas(), gerarImg(listaBt)),
                            new MidiaVO("CAMINHANDO COM DINOSSAUROS", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",25.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas()),
                            new MidiaVO("Caça aos Gângsteres", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",22.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas()),
                            new MidiaVO("Mama", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",24.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas(), gerarImg(listaBt)),
                            new MidiaVO("O Último Desafio", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",21.00f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas(), gerarImg(listaBt)),
                            new MidiaVO("João e Maria Caçadores de Bruxas", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit",28.50f, generos.get(randomGenerator.nextInt(generos.size())), gerarIdiomas(), gerarImg(listaBt))
                            );
            
            for (MidiaVO vo : list){
                dao.create(vo);
            }
        }
    }
    
    @Transactional
    private byte[] gerarImg(List<byte[]> listaBt){
         Random randomGenerator = new Random();
         return listaBt.get(randomGenerator.nextInt(listaBt.size()));
    }
    
    @Transactional
    private List<IdiomaVO> gerarIdiomas(){
        IdiomaDAO iDao = new IdiomaDAO(em);
        List<IdiomaVO> idiomas = iDao.findAll(10, 0);
        Random randomGenerator = new Random();
        
        List<IdiomaVO> idiomasMidias = new ArrayList<IdiomaVO>();
        int size = randomGenerator.nextInt(idiomas.size());
        if (size == 0){size++;}
        
        for (int i = 0; i < size; i++){
            IdiomaVO vo = idiomas.get(randomGenerator.nextInt(idiomas.size()));
            if (!idiomasMidias.contains(vo)){
                idiomasMidias.add(vo);
            }
        }
        return idiomasMidias;
    }

    @Override
    public void destroy() {
    }
    
    
    public byte[] read(File file) throws IOException{
        FileInputStream fin = null;
        FileChannel ch = null;
        byte[] bytes = null;
        try {
            fin = new FileInputStream(file);
            ch = fin.getChannel();
            int size = (int) ch.size();
            MappedByteBuffer buf = ch.map(FileChannel.MapMode.READ_ONLY, 0, size);
            bytes = new byte[size];
            buf.get(bytes);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (ch != null) {
                    ch.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
       return bytes;
    }
}
