/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.teste;

import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author An
 */
@ManagedBean
@RequestScoped
public class ProdutoManagedBean {

    /**
     * Creates a new instance of ProdutoManagedBean
     */
    public ProdutoManagedBean() {
    }
    
    public List<ProdutoBean> getProdutosBean(){        
            return Arrays.asList(
                    new ProdutoBean(1,"Guerra Mundial Z", "Ação","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",20.00),
                    new ProdutoBean(2,"CAMINHANDO COM DINOSSAUROS", "Aventura","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",25.00),
                    new ProdutoBean(3,"Caça aos Gângsteres", "Drama","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",22.00),
                    new ProdutoBean(4,"Mama", "Terror","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",24.00),
                    new ProdutoBean(5,"O Último Desafio", "Ação","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",21.00),
                    new ProdutoBean(6,"João e Maria Caçadores de Bruxas", "Fantasia","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",28.50),
                    new ProdutoBean(7,"Guerra Mundial Z", "Ação","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",20.00),
                    new ProdutoBean(8,"CAMINHANDO COM DINOSSAUROS", "Aventura","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",25.00),
                    new ProdutoBean(9,"Caça aos Gângsteres", "Drama","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",22.00),
                    new ProdutoBean(10,"Mama", "Terror","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",24.00),
                    new ProdutoBean(11,"O Último Desafio", "Ação","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",21.00),
                    new ProdutoBean(12,"João e Maria Caçadores de Bruxas", "Fantasia","Lorem ipsum dolor sit amet, consectetuer adipiscing elit",28.50)
                    );
        
    }
}
