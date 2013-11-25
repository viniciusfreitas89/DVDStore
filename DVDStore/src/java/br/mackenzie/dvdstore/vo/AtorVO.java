/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.vo;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="ATORES")
@TableGenerator(name="ATORES_TABLE_GENERATOR", 
                table = "SEQUENCE_GENERATOR", 
                pkColumnName = "SEQUENCE_NAME",
                pkColumnValue = "ATORES_SEQUENCE",
                valueColumnName = "SEQUENCE_VALUE",
                allocationSize = 1)
@DiscriminatorValue(value = "A")
public class AtorVO extends PessoaVO{
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="MIDIA_ATORES",
                joinColumns=@JoinColumn(name="ID_ATOR"),
                inverseJoinColumns=@JoinColumn(name="ID_MIDIA"))
    @Getter @Setter
    private List<MidiaVO> midias;
}
