/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.enumpack;

/**
 *
 * @author Vinicius
 */
public enum TipoPessoaEnum {
    CLIENTE(1),
    AUTOR(2);
    
    private Integer id;
    
    TipoPessoaEnum(Integer id){
        this.id = id;
    }
    
    public static TipoPessoaEnum valueOf(Integer id){
       TipoPessoaEnum[] values = values();
       for (TipoPessoaEnum obj : values){
           if (obj.id.equals(id)){
               return obj;
           }
       }
       return null;
    }
}
