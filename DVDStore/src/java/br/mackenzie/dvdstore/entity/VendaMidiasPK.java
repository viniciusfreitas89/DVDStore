/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.entity;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinicius
 */
@Entity
public class VendaMidiasPK extends PessoaVO{
    @Getter @Setter
    private Long idVenda;
    @Getter @Setter
    private Long idMidia;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        hash += (idMidia != null ? idMidia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof VendaMidiasPK)) {
            return false;
        }
        VendaMidiasPK other = (VendaMidiasPK) object;
        if ((this.idVenda == null && other.idVenda!= null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda)) &&
            (this.idMidia == null && other.idMidia!= null) || (this.idMidia != null && !this.idMidia.equals(other.idMidia))) {
            return false;
        }
        return true;
    }
}
