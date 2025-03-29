import java.time.LocalDate;

public class Profesor extends Persona{

    int numSalon;
    String materia;
    String tipoContratacion;

    public Profesor(){
    }

    public Profesor(int numSalon, String materia, String tipoContratacion, String nombre, String apellido, String genero, double estatura, double peso, LocalDate fechaNacimiento){
        super(nombre, apellido, genero, estatura, peso, fechaNacimiento);
        this.numSalon = numSalon;
        this.materia = materia;
        this.tipoContratacion = tipoContratacion;

    }

    public void setNumSalon(int numSalon) {
        this.numSalon = numSalon;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setTipoContratacion(String tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    public int getNumSalon() {
        return numSalon;
    }

    public String getMateria() {
        return materia;
    }

    public String getTipoContratacion() {
        return tipoContratacion;
    }


}
