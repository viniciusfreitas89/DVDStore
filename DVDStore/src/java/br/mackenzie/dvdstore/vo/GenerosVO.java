/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.vo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name="Generos")
@TableGenerator(name="GENEROS_TABLE_GENERATOR", 
                table = "SEQUENCE_GENERATOR", 
                pkColumnName = "SEQUENCE_NAME",
                pkColumnValue = "GENEROS_SEQUENCE",
                valueColumnName = "SEQUENCE_VALUE",
                allocationSize = 1)
public class GenerosVO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "GENEROS_TABLE_GENERATOR")
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String nome;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GenerosVO)) {
            return false;
        }
        GenerosVO other = (GenerosVO) object;
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
