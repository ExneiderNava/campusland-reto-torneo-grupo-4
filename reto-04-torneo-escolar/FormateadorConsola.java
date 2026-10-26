public class FormateadorConsola implements FormateadorFicha {

    @Override
    public String generarFicha(Equipo equipo) {
        if (equipo == null){
            return "Sin datos";
        }
        return "ID: " + equipo.getId()
                + " | Nombre: " + equipo.getNombre()
                + " | Categoria: " + equipo.getCategoria()
                + " | G: " + equipo.getGanados()
                + " | E: " + equipo.getEmpatados()
                + " | P: " + equipo.getPerdidos()
                + " | PJ: " + equipo.totalPartidos()
                + " | Pts: " + equipo.calcularPuntos();
    }
}
