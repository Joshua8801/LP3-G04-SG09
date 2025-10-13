package ejercicio3;

import java.util.Scanner;

public class EmpleadoView {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- MENÚ DE EMPLEADOS ---");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar nuevo empleado");
        System.out.println("3. Buscar empleado por número");
        System.out.println("4. Eliminar empleado por número");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        return sc.nextInt();
    }

    public Empleado leerDatosEmpleado() {
        System.out.print("Ingrese número: ");
        int numero = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese sueldo: ");
        double sueldo = sc.nextDouble();
        return new Empleado(numero, nombre, sueldo);
    }

    public int leerNumeroEmpleado() {
        System.out.print("Ingrese número del empleado: ");
        return sc.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEmpleado(Empleado e) {
        if (e != null)
            System.out.println(e);
        else
            System.out.println("Empleado no encontrado.");
    }
}



