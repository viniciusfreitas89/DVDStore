/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.vo;

import br.mackenzie.dvdstore.enumpack.TipoPessoaEnum;
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
    private TipoPessoaEnum tipo;
    @Getter @Setter
    private String cidade;
    @Getter @Setter
    private String uf;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
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
        return "br.mackenzie.dvdstore.vo.PessoaVO[ id=" + id + " ]";
    }
    
}
