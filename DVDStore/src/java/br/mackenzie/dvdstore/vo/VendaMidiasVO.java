/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.vo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name="VENDA_MIDIAS")
@IdClass(Venda_Midias_PK.class)
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
    @ManyToOne()
    @JoinColumn(name = "ID")
    @Getter @Setter
    private MidiaVO midia;
    @ManyToOne()
    //@JoinColumn(name = "ID")
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
