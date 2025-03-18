import java.time.LocalDate; //Usamos localdate para almacenar la fecha sin la hora.

public class Persona {
    private String nombre, apellido;
    private char genero;
    private double estatura, peso;
    private LocalDate fechaNacimiento; // el formato que tendria al almacenar es YYYY-MM-DD

    public Persona(){

    }

    public Persona (String nombre, String apellido, char genero, double estatura, double peso, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.estatura = estatura;
        this.peso = peso;
        this. fechaNacimiento = fechaNacimiento;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public char getGenero(){
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