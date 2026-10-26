import java.util.Locale;

public abstract class Equipo {
    private final String id;
    private final String nombre;
    private int ganados;
    private int empatados;
    private int Perdidos;

    public Equipo(String id, String nombre) {
        if (id == null || id.strip().isEmpty()){
            this.id = "SIN_ID";
        } else {
            this.id = id.strip().toUpperCase(Locale.ROOT);
        }

        if (nombre == null || nombre.strip().isEmpty()){
            this.nombre = "SIN_NOMBRE";
        } else {
            this.nombre = nombre.strip();
        }

        this.ganados = 0;
        this.empatados = 0;
        this.Perdidos = 0;
    }

    public boolean registrarResultado(String resultado) {
        if (resultado == null){
            return false;
        }

        String normalizado = resultado.strip().toUpperCase(Locale.ROOT);

        if (totalPartidos() >= 20){
            return false;
        }

        if(normalizado.equals("G")){
            this.ganados++;
            return true;
        } else if (normalizado.equals("E")) {
            this.empatados++;
            return true;
        } else if (normalizado.equals("P")) {
            this.Perdidos++;
            return true;
        } else  {
            return false;
        }

    }

    public int totalPartidos() {
        return this.ganados + this.empatados + this.Perdidos;
    }

    public abstract int calcularPuntos();
    public abstract String getCategoria();

    public String getId(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getGanados(){
        return this.ganados;
    }
    public int getEmpatados(){
        return this.empatados;
    }
    public int getPerdidos(){
        return this.Perdidos;
    }
}
