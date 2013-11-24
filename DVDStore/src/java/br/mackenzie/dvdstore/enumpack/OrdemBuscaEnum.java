package br.mackenzie.dvdstore.enumpack;

/**
 *
 * @author Vinicius
 */
public enum OrdemBuscaEnum {
    NONE(0, "Ordenar por...", ""),
    MENOR_PRECO(1, "Menor Preço", "valorUnitario asc"),
    MAIOR_PRECO(2, "Maior Preço", "valorUnitario desc"),
    TITULO(3, "Titulo", "titulo asc"),
    MAIS_VENDIDOS(4, "Mais Vendidos", "");
    
    private Integer id;
    private String description;
    private String fieldOrder;
    
    OrdemBuscaEnum(Integer id, String description, String fieldOrder){
        this.id = id;
        this.description = description;
        this.fieldOrder = fieldOrder;
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
    public String getFieldOrder() {
        return fieldOrder;
    }
    public void setFieldOrder(String fieldOrder) {
        this.fieldOrder = fieldOrder;
    }
}