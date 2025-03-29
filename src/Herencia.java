import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Herencia {
    public static void main (String[] args){
        //Creo los Hashmap "Diccionarios" los cuales me serviran para almacenar los pares clave valor con la informacion de cada objeto
        HashMap<String, Profesor> profesorHM1 = new HashMap<>();
        HashMap<String, Profesor> profesorHM2 = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for(int i = 1; i < 3; i++){
            registrarProfesor(i, profesorHM1, profesorHM2, scanner, formatter);
        }

        mostrarListadoProfesores(profesorHM2, scanner);

        scanner.close();
    }

    private static void registrarProfesor(int i, HashMap<String, Profesor> profesorHM1, HashMap<String, Profesor> profesorHM2, Scanner scanner, DateTimeFormatter formatter) {
        Profesor prof1 = new Profesor();

        String nombre = pedirTexto(scanner,"¿Cuál es el nombre del " + i + " profesor?");
        prof1.setNombre(nombre);

        String apellido = pedirTexto(scanner,"¿Cuál es el apellido del " + i + " profesor?");
        prof1.setApellido(apellido);

        String genero = pedirGenero(scanner, i);
        prof1.setGenero(genero);

        double estatura = pedirDouble(scanner, "¿Cuál es la estatura del " + i + " profesor?");
        prof1.setEstatura(estatura);

        double peso = pedirDouble(scanner,"¿Cuál es el peso del " + i + " profesor?");
        prof1.setPeso(peso);

        LocalDate fechaNacimiento = pedirFecha(scanner, "¿Cuál es la fecha de nacimiento del " + i + " profesor? YYYY-MM-DD", formatter);
        prof1.setFechaNacimiento(fechaNacimiento);

        int numSalon = pedirEntero(scanner, "¿Cuál es el salón del " + i + " profesor?");
        prof1.setNumSalon(numSalon);

        String materia = pedirTexto(scanner, "¿Cuál es la materia del " + i + " profesor?");
        prof1.setMateria(materia);

        String tipoContratacion = pedirContratacion(scanner, i);
        prof1.setTipoContratacion(tipoContratacion);

        Profesor prof2 = new Profesor(numSalon, materia, tipoContratacion, nombre, apellido, genero, estatura, peso, fechaNacimiento);

        profesorHM1.put("Profesor " + i + ":", prof1);
        profesorHM2.put("Profesor " + i + ":", prof2);
    }

    private static String pedirTexto(Scanner scanner, String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    private static String pedirGenero(Scanner scanner, int i) {
        while (true) {
            String respuesta = pedirTexto(scanner,"¿Cuál es el género del " + i + " profesor? (M/F)");
            if (respuesta.equalsIgnoreCase("m") || respuesta.equalsIgnoreCase("f")) {
                return respuesta;
            }
            System.out.println("Respuesta no válida, debe ser 'M' o 'F'.");
        }
    }

    private static double pedirDouble(Scanner scanner, String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(pedirTexto(scanner, mensaje));
            } catch (NumberFormatException e) {
                System.out.println("El formato debe ir separado por '.' no por ','.");
            }
        }
    }

    private static int pedirEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(pedirTexto(scanner, mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }
    }

    private static LocalDate pedirFecha(Scanner scanner, String mensaje, DateTimeFormatter formatter) {
        while (true) {
            try {
                return LocalDate.parse(pedirTexto(scanner, mensaje), formatter);
            } catch (Exception e) {
                System.out.println("El formato de fecha ingresado no es correcto. Debe ser YYYY-MM-DD.");
            }
        }
    }

    private static String pedirContratacion(Scanner scanner, int i) {
        while (true) {
            String respuesta = pedirTexto(scanner, "¿Cuál es el tipo de contratación del " + i + " profesor? (Def/Ind)");
            if (respuesta.equalsIgnoreCase("Def") || respuesta.equalsIgnoreCase("Ind")) {
                return respuesta;
            }
            System.out.println("Respuesta no válida, debe ser 'Def' o 'Ind'.");
        }
    }

    private static void mostrarListadoProfesores(HashMap<String, Profesor> profesorHM2, Scanner scanner) {
        while (true) {
            String respuesta = pedirTexto(scanner,"¿Deseas ver un listado de todos los profesores registrados? (Y/N):");
            if (respuesta.equalsIgnoreCase("y")) {
                System.out.println("Listado de profesores:");
                for (String clave : profesorHM2.keySet()) {
                    Profesor prof = profesorHM2.get(clave);
                    System.out.println(clave);
                    System.out.println("Nombre: " + prof.getNombre());
                    System.out.println("Apellido: " + prof.getApellido());
                    System.out.println("Género: " + prof.getGenero());
                    System.out.println("Estatura: " + prof.getEstatura());
                    System.out.println("Peso: " + prof.getPeso());
                    System.out.println("Fecha de Nacimiento: " + prof.getFechaNacimiento());
                    System.out.println("Salón: " + prof.getNumSalon());
                    System.out.println("Materia: " + prof.getMateria());
                    System.out.println("Tipo de Contratación: " + prof.getTipoContratacion());
                    System.out.println("\n--------------------------------------\n");
                }
            } else if (respuesta.equalsIgnoreCase("n")) {
                System.out.println("Gracias por usar nuestro programa, finalizando operación...");
                break;
            } else {
                System.out.println("Entrada no válida. Debe ser 'Y' o 'N'.");
            }
        }
    }
}
