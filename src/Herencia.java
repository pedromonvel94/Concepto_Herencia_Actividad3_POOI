import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Herencia {
    public static void main (String[] args){
        HashMap<String, Profesor> profesor = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for(int i = 1; i < 4; i++){
            Profesor prof = new Profesor();
            boolean generoValido = false;
            boolean formatoValido = false;
            boolean contratacionValida = false;
            boolean estaturaValida = false;
            boolean pesoValido = false;

            System.out.println("¿Cual es el nombre del " + i + " profesor?");
            prof.setNombre(scanner.nextLine());

            System.out.println("¿Cual es el apellido del " + i + " profesor?");
            prof.setApellido(scanner.nextLine());

            while(!generoValido) {
                System.out.println("¿Cual es el genero del " + i + " profesor? (M/F)");
                String respuestaGenero = scanner.nextLine();
                if(respuestaGenero.equalsIgnoreCase("m") || respuestaGenero.equalsIgnoreCase("f") ){
                    prof.setGenero(respuestaGenero);
                    generoValido = true;
                } else {
                    System.out.println("Respuesta no invalida, debe ser 'M' o 'F'.");
                }
            }

            while (!estaturaValida) {
                System.out.println("¿Cual es la estatura del " + i + " profesor?");
                try {
                    prof.setEstatura(Double.parseDouble(scanner.nextLine()));
                    estaturaValida = true;
                } catch (Exception e) {
                    System.out.println("El formato debe ir separado por '.' no por ','");
                }
            }

            while (!pesoValido) {
                System.out.println("¿Cual es el peso del " + i + " profesor?");
                try {
                    prof.setPeso(Double.parseDouble(scanner.nextLine()));
                    pesoValido = true;
                } catch (Exception e) {
                    System.out.println("El formato debe ir separado por '.' no por ','");
                }
            }

            while(!formatoValido){
                System.out.println("¿Cual es la fecha de nacimiento del " + i + " profesor? YYYY-MM-DD");
                try {
                    prof.setFechaNacimiento(LocalDate.parse(scanner.nextLine(), formatter));
                    formatoValido = true;
                } catch (Exception e){
                    System.out.println("El formato de fecha ingresado no es correcto YYYY-MM-DD");
                }
            }

            System.out.println("¿Cual es el salon del " + i + " profesor?");
            prof.setNumSalon(Integer.parseInt(scanner.nextLine()));

            System.out.println("¿Cual es la materia del " + i + " profesor?");
            prof.setMateria(scanner.nextLine());

            while (!contratacionValida){
                System.out.println("¿Cual es el tipo de contratacion del " + i + " profesor? (Def/Ind)");
                String opcTipoContratacion = scanner.nextLine();
                if (opcTipoContratacion.equalsIgnoreCase("def") || opcTipoContratacion.equalsIgnoreCase("ind")){
                    prof.setTipoContratacion(opcTipoContratacion);
                    contratacionValida = true;
                } else {
                    System.out.println("Respuesta no invalida, debe ser 'Def' o 'Ind'.");
                }
            }

            profesor.put("Profesor " + i +": ", prof);

        }

        while (true){
            System.out.println("¿Deseas ver un listado de todos los profesores registrados? (Y/N): ");
            String respuestaListado = scanner.nextLine();
            if (respuestaListado.equalsIgnoreCase("y")){
                System.out.println("Listado de profesores: ");
                for (String clave : profesor.keySet()){
                    Profesor prof = profesor.get(clave);
                    System.out.println(clave);
                    System.out.println("Nombre: " + prof.getNombre());
                    System.out.println("Apellido: " + prof.getApellido());
                    System.out.println("Genero: " + prof.getGenero());
                    System.out.println("Estatura: " + prof.getEstatura());
                    System.out.println("Peso: " + prof.getPeso());
                    System.out.println("Fecha de Nacimiento: " + prof.getFechaNacimiento());
                    System.out.println("Salon: " + prof.getNumSalon());
                    System.out.println("Materia: " + prof.getMateria());
                    System.out.println("Tipo de Contratación: " + prof.getTipoContratacion());
                    System.out.println("\n -------------------------------------- \n");
                    System.out.println("Gracias por usar nuestro programa, finalizando operacion...");
                    break;
                }
            } else if(respuestaListado.equalsIgnoreCase("n")){
                System.out.println("Gracias por usar nuestro programa, finalizando operacion...");
                break;
            } else {
                System.out.println("Entrada no válida. Debe ser 'Y' o 'N'.");
            }

        }

        scanner.close();
    }
}
