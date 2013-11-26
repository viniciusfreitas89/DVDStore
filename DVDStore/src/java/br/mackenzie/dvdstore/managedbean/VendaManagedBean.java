package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.entity.VendasVO;
import br.mackenzie.dvdstore.services.VendaService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@RequestScoped
public class VendaManagedBean extends ManagedBeanDefault{
    @EJB
    private VendaService bean;
    @Getter @Setter
    private VendasVO venda;
    
    public VendaManagedBean() {
        venda = new VendasVO();
    }
       
    public List<VendasVO> getVendas(){
        return bean.listar();
    }
}