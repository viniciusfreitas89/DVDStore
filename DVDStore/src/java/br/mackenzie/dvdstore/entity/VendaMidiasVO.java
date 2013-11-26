/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name="VENDA_MIDIAS")
@IdClass(VendaMidiasPK.class)
public class VendaMidiasVO implements Serializable {
    @Id
    @Getter @Setter
    private Long idVenda;
    @Id
    @Getter @Setter
    private Long idMidia;
    @Getter @Setter
    private float total;
    @Getter @Setter
    private int quantidade;
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private MidiaVO midia;
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private VendasVO venda;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        hash += (idMidia != null ? idMidia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof VendaMidiasVO)) {
            return false;
        }
        VendaMidiasVO other = (VendaMidiasVO) object;
        if ((this.idVenda == null && other.idVenda!= null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda)) &&
            (this.idMidia == null && other.idMidia!= null) || (this.idMidia != null && !this.idMidia.equals(other.idMidia))) {
            return false;
        }
        return true;
    }
}