/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.teste;

/**
 *
 * @author Anntonio
 */
public class ProdutoBean {
    private int id;
    private String titulo;
    private String genero;
    private String comentario;
    private double valor;

    
    public ProdutoBean(int id, String titulo, String genero, String comentario, double valor){
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.comentario = comentario;
        this.valor = valor;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    
}
