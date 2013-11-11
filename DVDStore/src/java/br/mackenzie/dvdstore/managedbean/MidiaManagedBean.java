/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.services.MidiaService;
import br.mackenzie.dvdstore.vo.MidiaVO;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71306552
 */
@ManagedBean
@RequestScoped
public class MidiaManagedBean {
    @EJB
    private MidiaService bean;
    @Getter @Setter
    private Long idFilme;
    
    public MidiaManagedBean() {
    }
    
    public List<MidiaVO> getListarFilmes(){
        return bean.listar();
    }
    
    public String mostrarFilme(){
        System.out.println("Id: "+idFilme);
        return "detalhe.xhtml";
//        return bean.procurar(idFilme);
    }
}
