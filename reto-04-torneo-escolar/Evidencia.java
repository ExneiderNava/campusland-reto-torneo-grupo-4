public class Evidencia<T> {
    private final String descripcion;
    private final T contenido;

    public Evidencia(String descripcion, T contenido){
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public T getContenido(){
        return this.contenido;
    }

    public String mostrar(){
        return this.descripcion + ": " + this.contenido;
    }
}
