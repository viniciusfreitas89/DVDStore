package br.mackenzie.dvdstore.entity;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinicius
 */
public class CarrinhoVO extends MidiaVO{
    @Getter @Setter
    private int quantidade;
    @Getter @Setter
    private float total;
    
    public CarrinhoVO(){
        this.quantidade = 1;
    }
    public CarrinhoVO(Long id){
        this();
        this.setId(id);
    }
}
