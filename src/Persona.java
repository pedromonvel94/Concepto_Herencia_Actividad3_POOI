import java.time.LocalDate; //Usamos localdate para almacenar la fecha sin la hora.

public class Persona {
    private String nombre, apellido, genero;
    private double estatura, peso;
    private LocalDate fechaNacimiento; // el formato que tendria al almacenar es YYYY-MM-DD

    public Persona(){

    }

    public Persona (String nombre, String apellido, String genero, double estatura, double peso, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.estatura = estatura;
        this.peso = peso;
        this. fechaNacimiento = fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getGenero(){
        return genero;
    }

    public double getEstatura(){
        return estatura;
    }

    public double getPeso(){
        return peso;
    }

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

}