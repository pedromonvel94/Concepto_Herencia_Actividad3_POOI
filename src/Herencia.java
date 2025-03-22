import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Herencia {
    public static void main (String[] args){
        HashMap<String, Profesor> profesor = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for(int i = 1; i < 51; i++){
            Profesor prof = new Profesor();
            System.out.println("¿Cual es el nombre del " + i + " profesor?");
            prof.setNombre(scanner.nextLine());

            System.out.println("¿Cual es el apellido del " + i + " profesor?");
            prof.setApellido(scanner.nextLine());

            while(true) {
                System.out.println("¿Cual es el genero del " + i + " profesor? (M/F)");
                String respuestaGenero = scanner.nextLine();
                if(respuestaGenero.equalsIgnoreCase("m") || respuestaGenero.equalsIgnoreCase("f") ){
                    prof.setGenero(respuestaGenero);
                    break;
                }
            }

            System.out.println("¿Cual es la estatura del " + i + " profesor?");
            prof.setEstatura(Double.parseDouble(scanner.nextLine()));

            System.out.println("¿Cual es el peso del " + i + " profesor?");
            prof.setPeso(Double.parseDouble(scanner.nextLine()));

            System.out.println("¿Cual es la fecha de nacimiento del " + i + " profesor? (YYYY,M,DD");
            prof.setFechaNacimiento(LocalDate.parse(scanner.nextLine()));

            System.out.println("¿Cual es el salon del " + i + " profesor?");
            prof.setNumSalon(Integer.parseInt(scanner.nextLine()));

            System.out.println("¿Cual es la materia del " + i + " profesor?");
            prof.setMateria(scanner.nextLine());

            System.out.println("¿Cual es el tipo de contratacion del " + i + " profesor? (Def/Ind)");
            prof.setTipoContratacion(scanner.nextLine());

            profesor.put("Profesor " + i +": ", prof);

        }

        /*prof.setNombre("Pedro");
        prof.setApellido("Montoya");
        prof.setGenero("m");
        prof.setEstatura(1.78);
        prof.setPeso(89);
        prof.setFechaNacimiento(LocalDate.of(1994,9,14));
        prof.setNumSalon(234);
        prof.setMateria("Español");
        prof.setTipoContratacion("Termino Fijo");*/

    }
}
