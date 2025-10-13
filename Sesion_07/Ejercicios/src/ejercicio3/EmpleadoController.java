package ejercicio3;
import java.util.ArrayList;

public class EmpleadoController {
    private EmpleadoModel modelo;
    private EmpleadoView vista;

    public EmpleadoController(EmpleadoModel modelo, EmpleadoView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    ArrayList<Empleado> lista = modelo.leerEmpleados();
                    if (lista.isEmpty()) {
                        vista.mostrarMensaje("No hay empleados registrados.");
                    } else {
                        for (Empleado e : lista) {
                            vista.mostrarEmpleado(e);
                        }
                    }
                    break;

                case 2:
                    Empleado nuevo = vista.leerDatosEmpleado();
                    modelo.agregarEmpleado(nuevo);
                    vista.mostrarMensaje("Empleado agregado correctamente.");
                    break;

                case 3:
                    int numBuscar = vista.leerNumeroEmpleado();
                    Empleado encontrado = modelo.buscarEmpleado(numBuscar);
                    vista.mostrarEmpleado(encontrado);
                    break;

                case 4:
                    int numEliminar = vista.leerNumeroEmpleado();
                    boolean eliminado = modelo.eliminarEmpleado(numEliminar);
                    if (eliminado)
                        vista.mostrarMensaje("Empleado eliminado correctamente.");
                    else
                        vista.mostrarMensaje("Empleado no encontrado.");
                    break;

                case 5:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}

