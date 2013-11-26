/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 71306552
 */
@Entity
@Table(name="PESSOAS")
@TableGenerator(name="PESSOAS_TABLE_GENERATOR", 
                table = "SEQUENCE_GENERATOR", 
                pkColumnName = "SEQUENCE_NAME",
                pkColumnValue = "PESSOAS_SEQUENCE",
                valueColumnName = "SEQUENCE_VALUE",
                allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_PESSOA",
                     discriminatorType = DiscriminatorType.STRING,
                     length = 1)
@DiscriminatorValue(value = "P")
@NamedQueries({
    @NamedQuery(name="Pessoa.filtrar.login.senha", query = "SELECT p FROM PessoaVO p WHERE LOWER(p.email) = :param1 AND p.senha = :param2"),
    @NamedQuery(name="Pessoa.filtrar.login", query = "SELECT p FROM PessoaVO p WHERE LOWER(p.email) = :param1")
})
public class PessoaVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PESSOAS_TABLE_GENERATOR")
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String nome;
    @Getter @Setter
    private String cpf;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String senha;
    @Getter @Setter
    private String logradouro;
    @Getter @Setter
    private String bairro;
    @Getter @Setter
    private Integer numero;
    @Getter @Setter
    private String cep;
    @Getter @Setter
    private String telefone;
    @Getter @Setter
    private String cidade;
    @Getter @Setter
    private String uf;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @Getter @Setter
    private List<VendasVO> vendas;
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PessoaVO)) {
            return false;
        }
        PessoaVO other = (PessoaVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+": "+nome;
    }
    
}
