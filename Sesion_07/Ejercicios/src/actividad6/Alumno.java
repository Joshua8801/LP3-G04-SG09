package actividad6;

public class Alumno extends Persona implements java.io.Serializable {
    private Fecha fechaMatricula;

    public Alumno(String nombre, String telefono, String direccion, Fecha fechaMatricula) {
        super(nombre, telefono, direccion);
        this.fechaMatricula = new Fecha(fechaMatricula.getDia(), fechaMatricula.getMes(), fechaMatricula.getAño());
    }

    public Alumno() {
        super("", "", "");
        this.fechaMatricula = new Fecha();
    }

    public Fecha getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Fecha fechaMatricula) {
        this.fechaMatricula = new Fecha(fechaMatricula.getDia(), fechaMatricula.getMes(), fechaMatricula.getAño());
    }

    @Override
    public String toString() {
        return super.toString() + fechaMatricula.toString();
    }
}

