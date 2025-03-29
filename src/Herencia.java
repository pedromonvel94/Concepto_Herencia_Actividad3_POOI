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

        for(int i = 1; i < 51; i++){
            registrarProfesor(i, profesorHM1, profesorHM2, scanner);

            //Creamos el objeto prof1, el cual es el objeto que se conecta con el metodo constructor vacio "sin parametros"
            Profesor prof1 = new Profesor();

            //
            boolean generoValido = false;
            boolean estaturaValida = false;
            boolean pesoValido = false;
            boolean formatoValido = false;
            boolean contratacionValida = false;


            System.out.println("¿Cual es el nombre del " + i + " profesor?");
            String preguntaNombre = scanner.nextLine();
            //Opcion para guardar en el objeto prof1 que esta conectado al metodo constructor que no tiene parametros de la subclase Profesor, osea el metodo constructor vacio.
            prof1.setNombre(preguntaNombre);
            //Opcion para guardar en el objeto prof2
            String nombre = preguntaNombre;

            System.out.println("¿Cual es el apellido del " + i + " profesor?");
            String preguntaApellido = scanner.nextLine();
            //Opcion para guardar en el objeto prof1 que esta conectado al metodo constructor que no tiene parametros de la subclase Profesor, osea el metodo constructor vacio.
            prof1.setApellido(preguntaApellido);
            //Opcion para guardar en el objeto prof2
            String apellido = preguntaApellido;

            //Declaro la variable fuera del while para que tenga un scope mas global y lo pueda usar en la creacion del objeto prof2
            String genero = "";

            while(!generoValido) {
                System.out.println("¿Cual es el genero del " + i + " profesor? (M/F)");
                String respuestaGenero = scanner.nextLine();
                if(respuestaGenero.equalsIgnoreCase("m") || respuestaGenero.equalsIgnoreCase("f") ){
                    //Aqui estamos seteando el valor de genero para que sea el valor que el usuario coloco en respuestaGenero
                    prof1.setGenero(respuestaGenero);
                    //Para usar en prof2 estamos guardando en la variable de tipo string genero que esta en la parte superior el valor que el usuario coloco en respuestaGenero
                    genero = respuestaGenero;
                    generoValido = true;
                } else {
                    System.out.println("Respuesta no invalida, debe ser 'M' o 'F'.");
                }
            }

            //Credo la variable estatura con un valor por defecto el cual es 0.0
            double estatura = 0.0;

            while (!estaturaValida) {
                System.out.println("¿Cual es la estatura del " + i + " profesor?");
                String respuestaEstatura = scanner.nextLine();
                try {
                    //Convierto en double el String recibido por la respuesta del usuario, esto lo almaceno por medio de un setter en el objeto prof1 el cual a su vez lo guarda en el hashmap
                    prof1.setEstatura(Double.parseDouble(respuestaEstatura));
                    //Modifico la variable estatura que pase de 0.0 a el valor recibido en respuestaDouble convertido a double
                    estatura = Double.parseDouble(respuestaEstatura);
                    estaturaValida = true;
                } catch (Exception e) {
                    System.out.println("El formato debe ir separado por '.' no por ','");
                }
            }

            double peso = 0.0;

            while (!pesoValido) {
                System.out.println("¿Cual es el peso del " + i + " profesor?");
                String respuestaPeso = scanner.nextLine();
                try {
                    //Convierto en double el String recibido por la respuesta del usuario, esto lo almaceno por medio de un setter en el objeto prof1 el cual a su vez lo guarda en el hashmap
                    prof1.setPeso(Double.parseDouble(respuestaPeso));
                    //Modifico la variable peso que pase de 0.0 a el valor recibido en respuestaDouble convertido a double
                    peso = Double.parseDouble(respuestaPeso);
                    pesoValido = true;
                } catch (Exception e) {
                    System.out.println("El formato debe ir separado por '.' no por ','");
                }
            }

            LocalDate fechaNacimiento = null;
            while(!formatoValido){
                System.out.println("¿Cual es la fecha de nacimiento del " + i + " profesor? YYYY-MM-DD");
                String respuestaFechaNacimiento = (scanner.nextLine());
                try {
                    prof1.setFechaNacimiento(LocalDate.parse(respuestaFechaNacimiento, formatter));
                    fechaNacimiento = LocalDate.parse(respuestaFechaNacimiento, formatter);
                    formatoValido = true;
                } catch (Exception e){
                    System.out.println("El formato de fecha ingresado no es correcto YYYY-MM-DD");
                }
            }

            int numSalon = 0;

            System.out.println("¿Cual es el salon del " + i + " profesor?");
            int respuestaNumSalon = Integer.parseInt((scanner.nextLine()));
            prof1.setNumSalon(respuestaNumSalon);
            numSalon = respuestaNumSalon;


            System.out.println("¿Cual es la materia del " + i + " profesor?");
            String respuestaMateria = scanner.nextLine();
            prof1.setMateria(respuestaMateria);
            materia = respuestaMateria;

            String tipoContratacion = "";

            while (!contratacionValida){
                System.out.println("¿Cual es el tipo de contratacion del " + i + " profesor? (Def/Ind)");
                String respuestaTipoContratacion = scanner.nextLine();

                if(respuestaTipoContratacion.equalsIgnoreCase("Def") || respuestaTipoContratacion.equalsIgnoreCase("Ind")){
                    prof1.setTipoContratacion(respuestaTipoContratacion);
                    tipoContratacion = respuestaTipoContratacion;
                    contratacionValida = true;
                } else {
                    System.out.println("Respuesta no invalida, debe ser 'Def' o 'Ind'.");
                }
            }

            Profesor prof2 = new Profesor(numSalon, materia, tipoContratacion, nombre, apellido, genero, estatura, peso, fechaNacimiento);

            profesorHM1.put("Profesor " + i +": ", prof1);
            profesorHM2.put("Profesor " + i +": ", prof2);

        }

        while (true){
            System.out.println("¿Deseas ver un listado de todos los profesores registrados? (Y/N): ");
            String respuestaListado = scanner.nextLine();
            if (respuestaListado.equalsIgnoreCase("y")){
                System.out.println("Listado de profesores: ");
                for (String clave1 : profesorHM1.keySet()){
                    Profesor prof = profesorHM1.get(clave1);
                    System.out.println(clave1);
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
}
