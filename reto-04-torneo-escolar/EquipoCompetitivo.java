public class EquipoCompetitivo extends Equipo {

    public EquipoCompetitivo(String id, String nombre){
        super(id, nombre);
    }

    @Override
    public int calcularPuntos(){
        return (getGanados() * 3) + getEmpatados();
    }

    @Override
    public String getCategoria(){
        return "Competitiva";
    }
}
