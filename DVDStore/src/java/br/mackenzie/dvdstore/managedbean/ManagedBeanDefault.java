/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.managedbean;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vinicius
 */
public class ManagedBeanDefault {
    protected void addSucessMessage(String sucesso) {
        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, sucesso, sucesso);
        FacesContext.getCurrentInstance().addMessage(null, m);
    }
    protected void addErrorMessage(String sucesso) {
        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, sucesso, sucesso);
        FacesContext.getCurrentInstance().addMessage(null, m);
    }
    
    protected <T> T getBean(final String beanName, final Class<T> clazz) {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        return (T) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, beanName);
    }
}
