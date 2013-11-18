/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.services.MidiaService;
import br.mackenzie.dvdstore.vo.MidiaVO;
import com.sun.xml.ws.api.tx.at.Transactional;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71306552
 */
@ManagedBean
@SessionScoped
public class CarrinhoManagedBean {
    @EJB
    private MidiaService bean;
    @Getter @Setter
    private List<MidiaVO> midias;
    @Getter @Setter
    private Long idFilme;
    
    public CarrinhoManagedBean() {
        midias = new ArrayList<MidiaVO>();
    }
    
    @Transactional
    public String adicionar(){
        String idFilme = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFilme");
        System.out.println("###idFilme: "+idFilme);
        if (idFilme!=null && !idFilme.isEmpty()){
            MidiaVO vo = bean.procurar(Long.parseLong(idFilme));
            midias.add(vo);
        }
        return "carrinho.xhtml";
    }
}
