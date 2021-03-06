package br.mackenzie.dvdstore.enumpack;

/**
 *
 * @author Vinicius
 */
public enum MidiaEnum {
    DVD(1, "DVD"),
    BLU_RAY(2, "Blu-Ray");
    
    private Integer id;
    private String description;
    
    MidiaEnum(Integer id, String description){
        this.id = id;
        this.description = description;
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