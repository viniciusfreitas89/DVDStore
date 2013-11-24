/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.services.MidiaService;
import br.mackenzie.dvdstore.vo.CarrinhoVO;
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
public class CarrinhoManagedBean extends ManagedBeanDefault{
    @EJB
    private MidiaService bean;
    @Getter @Setter
    private List<CarrinhoVO> itens;
    @Getter @Setter
    private Long idFilme;
    
    public CarrinhoManagedBean() {
        itens = new ArrayList<CarrinhoVO>();
    }
    
    @Transactional
    public String adicionar(){
        String idFilme = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFilme");
        if (idFilme!=null && !idFilme.isEmpty()){
            adicionarItem(Long.parseLong(idFilme));
        }
        return "carrinho.xhtml";
    }
    
    public void incrementarQuantidade(Long idFilme){
        int index = itens.indexOf(new CarrinhoVO(idFilme));
        if (index > -1){
            CarrinhoVO item = itens.get(index);
            item.setQuantidade(item.getQuantidade()+1);
            item.setTotal(item.getValorUnitario()*item.getQuantidade());
        }
    }
    
    public void decrementarQuantidade(Long idFilme){
        int index = itens.indexOf(new CarrinhoVO(idFilme));
        if (index > -1){
            CarrinhoVO item = itens.get(index);
            if (item.getQuantidade()>1){
                item.setQuantidade(item.getQuantidade()-1);
                item.setTotal(item.getValorUnitario()*item.getQuantidade());
            }
        }
    }
    
    private void adicionarItem(Long idFilme){
        MidiaVO midia = bean.procurar(idFilme);
        CarrinhoVO item = new CarrinhoVO();
        item.setId(midia.getId());
        int index = itens.indexOf(item);
        if (index == -1){
            itens.add(item);
            item.setTitulo(midia.getTitulo());
            item.setValorUnitario(midia.getValorUnitario());
            item.setTotal(item.getValorUnitario());
        }else{
            item = itens.get(index);
            item.setQuantidade(itens.get(index).getQuantidade()+1);
            item.setTotal(item.getValorUnitario()*item.getQuantidade());
        }
    }
}
