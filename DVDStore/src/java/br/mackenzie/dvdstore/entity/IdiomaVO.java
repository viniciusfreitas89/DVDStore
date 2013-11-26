/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name="IDIOMAS")
@TableGenerator(name="IDIOMAS_TABLE_GENERATOR", 
                table = "SEQUENCE_GENERATOR", 
                pkColumnName = "SEQUENCE_NAME",
                pkColumnValue = "IDIOMAS_SEQUENCE",
                valueColumnName = "SEQUENCE_VALUE",
                allocationSize = 1)
public class IdiomaVO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "IDIOMAS_TABLE_GENERATOR")
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String nome;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="MIDIA_IDIOMAS",
                joinColumns=@JoinColumn(name="ID_IDIOMA"),
                inverseJoinColumns=@JoinColumn(name="ID_MIDIA"))
    @Getter @Setter
    private List<MidiaVO> midias;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IdiomaVO)) {
            return false;
        }
        IdiomaVO other = (IdiomaVO) object;
        if ((this.id == null && other.id!= null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
