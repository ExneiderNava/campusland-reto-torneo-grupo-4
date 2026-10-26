import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Torneo {
    private final List<Equipo> equipos;
    private final int[] asistencia;

    public Torneo() {
        this.equipos = new ArrayList<>();
        this.asistencia = new int[5];
    }

    public boolean registrarEquipo(Equipo nuevoEquipo) {
        if (nuevoEquipo == null) {
            return false;
        }

        if (buscarPorId(nuevoEquipo.getId()) != null){
            return false;
        }
        this.equipos.add(nuevoEquipo);
        return true;
    }

    public Equipo buscarPorId(String id){
        if (id == null){
            return null;
        }
        String idNormalizado = id.strip().toUpperCase(Locale.ROOT);
        for(Equipo equipo : this.equipos){
            if(equipo.getId().equals(idNormalizado)){
                return equipo;
            }
        }
        return null;
    }

    public boolean registrarResultado(String id, String resultado){
        Equipo equipo = buscarPorId(id);
        if(equipo == null){
            return false;
        }
        return equipo.registrarResultado(resultado);
    }

    public Equipo obtenerLider(){
        if (this.equipos.isEmpty()){
            return null;
        }
        Equipo lider = this.equipos.get(0);
        for (int i = 1; i < this.equipos.size(); i++){
            Equipo actual = this.equipos.get(i);
            if(actual.calcularPuntos() > lider.calcularPuntos()){
                lider = actual;
            }
        }
        return lider;
    }

    public boolean registrarAsistencia(int fecha, int espectadores){
        int indice = fecha - 1;
        if (indice < 0 || indice >= this.asistencia.length){
            return false;
        }
        if (espectadores < 0 || espectadores >= 500){
            return false;
        }

        this.asistencia[indice] = espectadores;
        return true;
    }

    public int calcularTotalAsistencia(){
        int total = 0;
        for (int valor : this.asistencia){
            total += valor;
        }
        return total;
    }

    public double calcularPromedioAsistencia(){
        if (this.asistencia.length == 0){
            return 0.0;
        }
        return (double) calcularTotalAsistencia() / this.asistencia.length;
    }

    public int obtenerMaximoAsistencia(){
        int max = this.asistencia[0];
        for (int valor : this.asistencia){
            if (valor > max){
                max = valor;
            }
        }
        return max;
    }

    public int obtenerFechaMaximoAsistencia(){
        int max = obtenerMaximoAsistencia();
        for (int i = 0; i < this.asistencia.length; i++){
            if (this.asistencia[i] == max){
                return i + 1;
            }
        }
        return 1;
    }

    public List<String> listarFichas(FormateadorFicha formateador){
        List<String> lineas = new ArrayList<>();
        for (Equipo equipo : this.equipos){
            lineas.add(formateador.generarFicha(equipo));
        }
        return lineas;
    }

    public int totalEquipos(){
        return this.equipos.size();
    }
}
