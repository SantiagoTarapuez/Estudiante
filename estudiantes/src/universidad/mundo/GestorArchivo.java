package universidad.mundo;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class GestorArchivo {

    private static final String FILENAME = "alumnos.txt";

    /**
     * Guarda la lista de alumnos en el archivo.
     */
    public static void guardarAlumnos(List<Alumno> alumnos) {
        List<String> lines = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            lines.add(alumno.toString());
        }
        try {
            Files.write(Paths.get(FILENAME), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga la lista de alumnos del archivo.
     */
    public static List<Alumno> cargarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            if (!Files.exists(Paths.get(FILENAME))) {
                return alumnos; 
            }
            List<String> lines = Files.readAllLines(Paths.get(FILENAME));
            for (String line : lines) {
                alumnos.add(Alumno.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alumnos;
    }
}
