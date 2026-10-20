
package modelo;

/**
 *
 * @author Joponcios
 */
public class TareaAcademica {
   
    private String titulo , descripcion, fecha_entrega;
    
    public TareaAcademica(String titulo , String descripcion , String fecha_entrega){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_entrega = fecha_entrega;
    }
    
    // getters y setters    
    
    public String getTitulo(){
        return titulo;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getFecha_entrega(){
        return fecha_entrega;
    }
    
    // set
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void setFecha_entrega(String fecha_entrega){
        this.fecha_entrega = fecha_entrega;
    }
    
    
    
    
    
    
    
    
    
    
    
}
