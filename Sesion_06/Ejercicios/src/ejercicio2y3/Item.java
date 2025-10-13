package ejercicio2y3;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo; 
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void usarItem() {
        if (cantidad > 0) {
            cantidad--;
            System.out.println("Usaste el item: " + nombre);
        } else {
            System.out.println("No hay más unidades de " + nombre);
        }
    }
}
