public class EquipoFormativo extends Equipo{

    public EquipoFormativo(String id, String nombre){
        super(id, nombre);
    }

    @Override
    public int calcularPuntos(){
        return (getGanados() * 2) + getEmpatados();
    }

    @Override
    public String getCategoria(){
        return "Formativa";
    }
}
