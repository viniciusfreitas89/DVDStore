/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.dao.exceptions.NonexistentEntityException;
import br.mackenzie.dvdstore.services.GeneroService;
import br.mackenzie.dvdstore.vo.GenerosVO;
import com.sun.xml.ws.api.tx.at.Transactional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71306552
 */
@ManagedBean
@RequestScoped
public class GeneroManagedBean {
    @EJB
    private GeneroService bean;
    @Getter @Setter
    private GenerosVO genero;
    
    public GeneroManagedBean() {
        genero = new GenerosVO();
    }
    
    public void incluir(){
        bean.inserir(genero);
        addSucessMessage("Cadastro realizado com sucesso.");
    }
    
    public void atualizar(Long id){
        genero.setId(id);
        genero.setNome(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nome"));
        bean.atualizar(genero);
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
    
    public List<GenerosVO> getGeneros(){
        return bean.listar();
    }
    
    private void addSucessMessage(String sucesso) {
        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, sucesso, sucesso);
        FacesContext.getCurrentInstance().addMessage(null, m);
    }
}