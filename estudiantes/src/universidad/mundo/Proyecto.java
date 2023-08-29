package universidad.mundo;

import java.util.List;
import java.util.Scanner;

import java.util.stream.Collectors;

public class Proyecto {

    public static void main(String[] args) {
        List<Alumno> alumnos = GestorArchivo.cargarAlumnos();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar alumnos");
            System.out.println("2. Agregar alumno");
            System.out.println("3. Buscar alumno por cédula");
            System.out.println("4. Modificar alumno");
            System.out.println("5. Eliminar alumno");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    for (Alumno alumno : alumnos) {
                        System.out.println(alumno);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese cédula:");
                    String cedula = scanner.nextLine();
                    System.out.println("Ingrese nombre:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese apellido:");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese semestre:");
                    int semestre = scanner.nextInt();
                    scanner.nextLine();  // Limpia el buffer
                    System.out.println("Ingrese email:");
                    String email = scanner.nextLine();
                    System.out.println("Ingrese celular:");
                    String celular = scanner.nextLine();

                    Alumno nuevoAlumno = new Alumno(nombre, apellido, semestre, email, celular, cedula);
                    alumnos.add(nuevoAlumno);
                    GestorArchivo.guardarAlumnos(alumnos);
                    System.out.println("Alumno agregado exitosamente.");
                    break;
                case 3:
                    System.out.println("Ingrese cédula a buscar:");
                    String cedulaBusqueda = scanner.nextLine();
                    Alumno alumnoEncontrado = alumnos.stream()
                            .filter(alumno -> alumno.getCedula().equals(cedulaBusqueda))
                            .findFirst()
                            .orElse(null);
                    if (alumnoEncontrado != null) {
                        System.out.println(alumnoEncontrado);
                    } else {
                        System.out.println("Alumno no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese cédula del alumno a modificar:");
                    String cedulaModificar = scanner.nextLine();

                    Alumno alumnoModificar = alumnos.stream()
                            .filter(alumno -> alumno.getCedula().equals(cedulaModificar))
                            .findFirst()
                            .orElse(null);

                    if (alumnoModificar == null) {
                        System.out.println("Alumno no encontrado.");
                    } else {
                        System.out.println("Datos actuales del alumno: " + alumnoModificar);

                        System.out.println("Ingrese nuevo nombre (deje en blanco para no cambiar):");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Ingrese nuevo apellido (deje en blanco para no cambiar):");
                        String nuevoApellido = scanner.nextLine();
                        System.out.println("Ingrese nuevo semestre (ingrese 0 para no cambiar):");
                        int nuevoSemestre = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Ingrese nuevo email (deje en blanco para no cambiar):");
                        String nuevoEmail = scanner.nextLine();
                        System.out.println("Ingrese nuevo celular (deje en blanco para no cambiar):");
                        String nuevoCelular = scanner.nextLine();

                        if (!nuevoNombre.isEmpty()) {
                            alumnoModificar.setNombre(nuevoNombre);
                        }

                        if (!nuevoApellido.isEmpty()) {
                            alumnoModificar.setApellido(nuevoApellido);
                        }

                        if (nuevoSemestre != 0) {
                            alumnoModificar.setSemestre(nuevoSemestre);
                        }

                        if (!nuevoEmail.isEmpty()) {
                            alumnoModificar.setEmail(nuevoEmail);
                        }

                        if (!nuevoCelular.isEmpty()) {
                            alumnoModificar.setCelular(nuevoCelular);
                        }

                        GestorArchivo.guardarAlumnos(alumnos);
                        System.out.println("Alumno modificado exitosamente.");
                    }
                    break;

                case 5:
                    System.out.println("Ingrese cédula del alumno a eliminar:");
                    String cedulaEliminar = scanner.nextLine();
                    alumnos = alumnos.stream()
                            .filter(alumno -> !alumno.getCedula().equals(cedulaEliminar))
                            .collect(Collectors.toList());
                    GestorArchivo.guardarAlumnos(alumnos);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

