package ejercicio1;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private double descuento;

    public Producto(int id, String nombre, double precio, double descuento) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public double getDescuento() { return descuento; }

    public double getPrecioFinal() {
        return precio - (precio * descuento / 100);
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " | $" + precio + " | Desc: " + descuento + "%";
    }
}

