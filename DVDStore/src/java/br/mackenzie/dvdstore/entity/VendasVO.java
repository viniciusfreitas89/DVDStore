/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="VENDAS")
@TableGenerator(name="VENDAS_TABLE_GENERATOR", 
                table = "SEQUENCE_GENERATOR", 
                pkColumnName = "SEQUENCE_NAME",
                pkColumnValue = "VENDAS_SEQUENCE",
                valueColumnName = "SEQUENCE_VALUE",
                allocationSize = 1)
public class VendasVO {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "VENDAS_TABLE_GENERATOR")
    @Getter @Setter
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private PessoaVO cliente;
    @Getter @Setter
    private float total;
    @OneToMany(mappedBy = "venda", cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @Getter @Setter
    private List<VendaMidiasVO> vendaMidias;
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof VendasVO)) {
            return false;
        }
        VendasVO other = (VendasVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
