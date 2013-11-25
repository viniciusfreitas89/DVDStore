package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.dao.exceptions.NonexistentEntityException;
import br.mackenzie.dvdstore.services.AtorService;
import br.mackenzie.dvdstore.vo.AtorVO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@RequestScoped
public class AtorManagedBean extends ManagedBeanDefault{
    @EJB
    private AtorService bean;
    @Getter @Setter
    private AtorVO ator;
    
    public AtorManagedBean() {
        ator = new AtorVO();
    }
    
    public void incluir(){
        bean.inserir(ator);
        addSucessMessage("Cadastro realizado com sucesso.");
    }
    
    public void atualizar(Long id){
        String nome = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nome"+id);
        ator.setId(id);
        ator.setNome(nome);
        bean.atualizar(ator);
        ator = new AtorVO();
        
        addSucessMessage("Atualizado com sucesso.");
    }
    
    public void excluir(Long id){
        try {
            bean.remover(id);
            addSucessMessage("Removido com sucesso.");
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GeneroManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            addSucessMessage("Item não encontrado.");
        }
    }
    
    public List<AtorVO> getAtores(){
        return bean.listar();
    }
}
