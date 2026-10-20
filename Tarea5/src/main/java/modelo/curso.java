package modelo;

/**
 *
 * @author Joponcios
 */
public class curso {
    
    private int codigo;
    private String nombre , tutor;
    
    public curso(int codigo , String nombre , String tutor){
        this.codigo = codigo;
        this.nombre = nombre;
        this.tutor = tutor;
    }
    
    // getters y setters
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
   public String getTutor(){
        return tutor; 
    }
    
    // set
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setTutor(String tutor){
        this.tutor = tutor;
    }
    
    
    
}
