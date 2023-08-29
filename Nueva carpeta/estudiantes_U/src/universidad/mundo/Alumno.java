package universidad.mundo;

public class Alumno {

    private String nombre;
    private String apellido;
    private int semestre;
    private String email;
    private String celular;
    private String cedula;

    /**
     * Constructor de la clase Alumno.
     */
    public Alumno(String nombre, String apellido, int semestre, String email, String celular, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.email = email;
        this.celular = celular;
        this.cedula = cedula;
    }

    // Getter y Setter para nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Getter y Setter para apellido
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    // Getter y Setter para semestre
    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    // Getter y Setter para email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Getter y Setter para celular
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    // Getter y Setter para cedula
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    /**
     * Convertir objeto a String para almacenamiento.
     */
    @Override
    public String toString() {
        return nombre + "," + apellido + "," + semestre + "," + email + "," + celular + "," + cedula;
    }

    /**
     * Convertir cadena de texto a objeto Alumno.
     */
    public static Alumno fromString(String data) {
        String[] parts = data.split(",");
        return new Alumno(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5]);
    }
}

