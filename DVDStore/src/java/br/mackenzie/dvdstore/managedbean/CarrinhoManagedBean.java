/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.services.MidiaService;
import br.mackenzie.dvdstore.services.VendaService;
import br.mackenzie.dvdstore.entity.CarrinhoVO;
import br.mackenzie.dvdstore.entity.MidiaVO;
import br.mackenzie.dvdstore.entity.PessoaVO;
import br.mackenzie.dvdstore.entity.VendaMidiasVO;
import br.mackenzie.dvdstore.entity.VendasVO;
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
    @EJB
    private VendaService beanVenda;
    @Getter @Setter
    private VendasVO venda;
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
    
    public String finalizarVenda(){
        venda = new VendasVO();
        LoginManagedBean login = getBean("loginManagedBean", LoginManagedBean.class);
        PessoaVO pessoa = login.getPessoa();
        
        if (pessoa!=null){
            venda.setCliente(pessoa);
            beanVenda.inserir(venda);
            float total = 0;
            for (CarrinhoVO item : itens){
                VendaMidiasVO vo = new VendaMidiasVO();
                vo.setIdMidia(item.getId());
                vo.setIdVenda(venda.getId());
                vo.setQuantidade(item.getQuantidade());
                vo.setTotal(item.getTotal());
                venda.getVendaMidias().add(vo);
                total += item.getTotal();
            }
            venda.setTotal(total);
            beanVenda.atualizar(venda);
        }else{
            return "login.xhtml";
        }
        
        return "finalizacaoCompra.xhtml";
    }
}
