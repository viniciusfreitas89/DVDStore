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
public enum MidiaEnum {
    DVD(1);
    
    private Integer id;
    
    MidiaEnum(Integer id){
        this.id = id;
    }
    
    public static MidiaEnum valueOf(Integer id){
       MidiaEnum[] values = values();
       for (MidiaEnum obj : values){
           if (obj.id.equals(id)){
               return obj;
           }
       }
       return null;
    }
}
