package ejercicio3;

import java.io.*;
import java.util.ArrayList;

public class EmpleadoModel {
    private final String archivo = "empleados.dat";

    public ArrayList<Empleado> leerEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            empleados = (ArrayList<Empleado>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer empleados: " + e.getMessage());
        }
        return empleados;
    }

    private void guardarEmpleados(ArrayList<Empleado> empleados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(empleados);
        } catch (IOException e) {
            System.out.println("Error al guardar empleados: " + e.getMessage());
        }
    }

    public void agregarEmpleado(Empleado empleado) {
        ArrayList<Empleado> empleados = leerEmpleados();
        empleados.add(empleado);
        guardarEmpleados(empleados);
    }

    public Empleado buscarEmpleado(int numero) {
        ArrayList<Empleado> empleados = leerEmpleados();
        for (Empleado e : empleados) {
            if (e.getNumero() == numero) {
                return e;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(int numero) {
        ArrayList<Empleado> empleados = leerEmpleados();
        boolean eliminado = empleados.removeIf(e -> e.getNumero() == numero);
        if (eliminado) {
            guardarEmpleados(empleados);
        }
        return eliminado;
    }
}

