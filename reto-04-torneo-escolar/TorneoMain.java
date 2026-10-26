import java.util.List;

public class TorneoMain {
    public static void main(String[] args) {
        System.out.println("==========================");
        System.out.println("Escenario Base Obligatorio");
        Torneo torneo = new Torneo();

        torneo.registrarEquipo(new EquipoFormativo("F-01", "Semillas"));
        torneo.registrarEquipo(new EquipoCompetitivo("C-01", "Halcones"));

        torneo.registrarResultado("F-01", "G");
        torneo.registrarResultado("F-01", "E");
        torneo.registrarResultado("F-01", "P");

        torneo.registrarResultado("C-01", "G");
        torneo.registrarResultado("C-01", "E");
        torneo.registrarResultado("C-01", "P");

        boolean resultadoInvalido = torneo.registrarResultado("F-01", "X");
        System.out.println("Registro resultado X en F-01 rechazado: " + (!resultadoInvalido));

        FormateadorFicha formateador = new FormateadorConsola();
        List<String> fichas = torneo.listarFichas(formateador);
        System.out.println("Fichas de Equipos");
        for (String ficha : fichas) {
            System.out.println(ficha);
        }
        Equipo lider = torneo.obtenerLider();
        System.out.println("Lider del torneo: " + (lider != null ? lider.getId() : "Sin datos"));

        torneo.registrarAsistencia(1, 30);
        torneo.registrarAsistencia(2, 25);
        torneo.registrarAsistencia(3, 40);
        torneo.registrarAsistencia(4, 20);
        torneo.registrarAsistencia(5, 35);

        System.out.println("Estadisticas de Asistencia");
        System.out.println("Total: " + torneo.calcularTotalAsistencia());
        System.out.println("Promedio: " + torneo.calcularPromedioAsistencia());
        System.out.println("Maximo: " + torneo.obtenerMaximoAsistencia());
        System.out.println("Fecha del maximo: " + torneo.obtenerFechaMaximoAsistencia());

        System.out.println("Evidencias genericas");
        Evidencia<Integer> evidenciaCantidad = new Evidencia<>("Cantidad de equipos registrados", torneo.totalEquipos());
        Evidencia<String> evidenciaConclusion = new Evidencia<>("Conclusion del reto", "El polimorfismo calculo los puntajes sin consultar tipos concretos");

        System.out.println(evidenciaCantidad.mostrar());
        System.out.println(evidenciaConclusion.mostrar());
    }
}
