/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.managedbean;

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
}
