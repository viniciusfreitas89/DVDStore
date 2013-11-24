/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.enumpack.MidiaEnum;
import br.mackenzie.dvdstore.enumpack.OrdemBuscaEnum;
import br.mackenzie.dvdstore.services.GeneroService;
import br.mackenzie.dvdstore.services.MidiaService;
import br.mackenzie.dvdstore.vo.AtoresTesteVO;
import br.mackenzie.dvdstore.vo.IdiomaVO;
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
    
    public String mostrarFilme(Long idFilme){
        vo = bean.procurar(idFilme);
        return "detalhe.xhtml";
    }
    
    public void incluir(){
        for (Long item : atores){
            AtoresTesteVO obj = new AtoresTesteVO();
            obj.setId(item);
            vo.getAtores().add(obj);
        }
        for (Long item : idiomas){
            IdiomaVO obj = new IdiomaVO();
            obj.setId(item);
            vo.getIdiomas().add(obj);
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
        filmes = bean.filtrarPorTitulo(termoBusca, OrdemBuscaEnum.valueOf(order));
        return "busca.xhtml";
    }
    
    public String filtrarPorTituloGenero(){
        termoBusca = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("termoBusca");
        String ord = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("order");
        order = Integer.parseInt(ord);
        System.out.println();
        System.out.println();
        System.out.println("##############");
        System.out.println(termoBusca);
        System.out.println(order);
        filmes = bean.filtrarPorTitulo(termoBusca, OrdemBuscaEnum.valueOf(order));
        return "busca.xhtml";
    }
}
