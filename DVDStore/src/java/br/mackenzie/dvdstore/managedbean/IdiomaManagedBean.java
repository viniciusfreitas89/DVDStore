/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.managedbean;

import br.mackenzie.dvdstore.dao.exceptions.NonexistentEntityException;
import br.mackenzie.dvdstore.services.IdiomaService;
import br.mackenzie.dvdstore.entity.IdiomaVO;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Antonio
 */
@ManagedBean
@RequestScoped
public class IdiomaManagedBean extends ManagedBeanDefault{
    @EJB
    private IdiomaService bean;
    @Getter @Setter
    private IdiomaVO idioma;
    
    /**
     * Creates a new instance of IdiomaManagedBean
     */
    public IdiomaManagedBean() {
        idioma = new IdiomaVO();        
    }
    
    public void incluir(){
        bean.inserir(idioma);
        addSucessMessage("Cadastro realizado com sucesso.");
    }
    
    public void atualizar(Long id){
        String nome = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nome"+id);
        idioma.setId(id);
        idioma.setNome(nome);
        bean.atualizar(idioma);
        idioma = new IdiomaVO();        
    }
    
    public void excluir(Long id){
        try{
            bean.remover(id);
            addSucessMessage("Removido com sucesso.");
        }catch(NonexistentEntityException ex){
            Logger.getLogger(IdiomaManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<IdiomaVO> getIdiomas(){
        return bean.listar();
    }
}
