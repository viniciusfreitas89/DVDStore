/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.vo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import br.mackenzie.dvdstore.enumpack.MidiaEnum;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
/**
 *
 * @author 71306552
 */
@Entity
@Table(name="MIDIAS")
//@NamedQueries(@NamedQuery="SELECT * FROM ")
@TableGenerator(name="MIDIAS_TABLE_GENERATOR", 
                table = "SEQUENCE_GENERATOR", 
                pkColumnName = "SEQUENCE_NAME",
                pkColumnValue = "MIDIAS_SEQUENCE",
                valueColumnName = "SEQUENCE_VALUE",
                allocationSize = 1)
@NamedQueries({
    @NamedQuery(name="Midia.filtrar.titulo", query = "SELECT m FROM MidiaVO m WHERE LOWER(m.titulo) LIKE :param1"),
    @NamedQuery(name="Midia.filtrar.titulo.ordenado.titulo", query = "SELECT m FROM MidiaVO m WHERE LOWER(m.titulo) LIKE :param1 ORDER BY m.titulo"),
    @NamedQuery(name="Midia.filtrar.titulo.ordenado.maior-preco", query = "SELECT m FROM MidiaVO m WHERE LOWER(m.titulo) LIKE :param1 ORDER BY m.valorUnitario desc"),
    @NamedQuery(name="Midia.filtrar.titulo.ordenado.menor-preco", query = "SELECT m FROM MidiaVO m WHERE LOWER(m.titulo) LIKE :param1 ORDER BY m.valorUnitario asc"),
    @NamedQuery(name="Midia.filtrar.titulo.ordenado.mais-vendido", query = "SELECT m FROM MidiaVO m WHERE LOWER(m.titulo) LIKE :param1 ORDER BY m.valorUnitario asc")
})
public class MidiaVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MIDIAS_TABLE_GENERATOR")
    @Getter @Setter
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn(name = "id_genero", referencedColumnName = "id")
    @Getter @Setter
    private GenerosVO genero;
    @Getter @Setter
    private String titulo;
    @Getter @Setter
    private String descricao;
    @Column(name="valor_unitario")
    @Getter @Setter
    private Float valorUnitario;
    @Getter @Setter
    private Integer estoque;
    @Column(name="path_imagem_capa")
    @Getter @Setter
    private String pathImagem;
    @Basic(fetch = FetchType.LAZY)
    @Lob()
    @Getter @Setter
    private Byte[] arquivo;
    @Enumerated
    @Getter @Setter
    private MidiaEnum tipo;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "MIDIA_ATORES", 
               joinColumns = {@JoinColumn(name = "ID_MIDIA")},
               inverseJoinColumns = {@JoinColumn(name = "ID_ATOR")})
    @Getter @Setter
    private List<AtoresTesteVO> atores;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinTable(name = "MIDIA_IDIOMAS", 
               joinColumns = {@JoinColumn(name = "ID_MIDIA")},
               inverseJoinColumns = {@JoinColumn(name = "ID_IDIOMA")})
    @Getter @Setter 
    private List<IdiomaVO> idiomas;
    
    public MidiaVO(){
        this.tipo = MidiaEnum.DVD;
        
        idiomas = new ArrayList<IdiomaVO>();
        atores = new ArrayList<AtoresTesteVO>();
    }
    public MidiaVO(Long id, String titulo, String descricao, Float valorUnitario){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.tipo = MidiaEnum.DVD;
        
        idiomas = new ArrayList<IdiomaVO>();
        atores = new ArrayList<AtoresTesteVO>();
    }
    public MidiaVO(String titulo, String descricao, Float valorUnitario){
        this.titulo = titulo;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.tipo = MidiaEnum.DVD;
        
        idiomas = new ArrayList<IdiomaVO>();
        atores = new ArrayList<AtoresTesteVO>();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MidiaVO)) {
            return false;
        }
        MidiaVO other = (MidiaVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return titulo;
    }
    
}
