/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.enumpack.MidiaEnum;
import br.mackenzie.dvdstore.enumpack.OrdemBuscaEnum;
import br.mackenzie.dvdstore.services.AtorService;
import br.mackenzie.dvdstore.services.GeneroService;
import br.mackenzie.dvdstore.services.IdiomaService;
import br.mackenzie.dvdstore.services.MidiaService;
import br.mackenzie.dvdstore.vo.AtorVO;
import br.mackenzie.dvdstore.vo.MidiaVO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
/**
 * @author 71306552
 */
@ManagedBean
@RequestScoped
public class MidiaManagedBean extends ManagedBeanDefault{
    @EJB
    private MidiaService bean;
    @EJB
    private GeneroService beanGenero;
    @EJB
    private IdiomaService beanIdioma;
    @EJB
    private AtorService beanAtor;
    @Getter @Setter
    private String termoBusca;
    @Getter @Setter
    private Integer order;
    @Getter @Setter
    private MidiaVO vo;
    @Getter @Setter
    private String idGenero;
    @Getter @Setter
    private String tipoMidia;
    @Getter @Setter
    private List<Long> atores;
    @Getter @Setter
    private List<Long> idiomas;
    @Getter @Setter
    private List<MidiaVO> filmes;
    
    public MidiaManagedBean() {
        vo = new MidiaVO();
        filmes = new ArrayList<MidiaVO>();
    }
    
    public List<MidiaVO> getListarFilmes(){
        return bean.listar(12);
    }
    
    public List<MidiaEnum> getTipos(){
        return Arrays.asList(MidiaEnum.values());
    }
    
    public List<OrdemBuscaEnum> getOrderBusca(){
        return Arrays.asList(OrdemBuscaEnum.values());
    }
    
     public String mostrarFilme(){
        return "detalhe.xhtml";
    }
    
    public String mostrarFilme(Long idFilme){
        vo = bean.procurar(idFilme);
        return "detalhe.xhtml";
    }
    
    public void incluir(){
        for (Long id : atores){
            vo.getAtores().add(beanAtor.procurar(id));
        }
        for (Long id : idiomas){
            vo.getIdiomas().add(beanIdioma.procurar(id));
        }
        if (tipoMidia!=null && !tipoMidia.isEmpty()){
            vo.setTipo(MidiaEnum.valueOf(Integer.parseInt(tipoMidia)));
        }
        if (idGenero!=null && !idGenero.isEmpty()){
           vo.setGenero(beanGenero.procurar(Long.parseLong(idGenero)));
        }
        
        bean.inserir(vo);
        
        addSucessMessage("Cadastro realizado com sucesso.");
    }
    
    public String filtrarPorTitulo(){
        filmes = bean.filtrarPorTitulo(termoBusca, OrdemBuscaEnum.valueOf(order), null);
        return "busca.xhtml";
    }
    
    public String filtrarPorTituloGenero(Long idGenero){
        termoBusca = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("termoBusca");
        String ord = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("order");
        order = Integer.parseInt(ord);
            filmes = bean.filtrarPorTitulo(termoBusca, OrdemBuscaEnum.valueOf(order), beanGenero.procurar(idGenero));
        return "busca.xhtml";
   }
}
