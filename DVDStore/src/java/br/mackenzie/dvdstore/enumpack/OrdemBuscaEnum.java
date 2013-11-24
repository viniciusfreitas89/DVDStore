package br.mackenzie.dvdstore.enumpack;

/**
 *
 * @author Vinicius
 */
public enum OrdemBuscaEnum {
    MENOR_PRECO(1, "Menor Preço"),
    MAIOR_PRECO(2, "Maior Preço"),
    TITULO(3, "Titulo"),
    MAIS_VENDIDOS(4, "Mais Vendidos");
    
    private Integer id;
    private String description;
    
    OrdemBuscaEnum(Integer id, String description){
        this.id = id;
        this.description = description;
    }
    
    public static OrdemBuscaEnum valueOf(Integer id){
       OrdemBuscaEnum[] values = values();
       for (OrdemBuscaEnum obj : values){
           if (obj.id.equals(id)){
               return obj;
           }
       }
       return null;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}