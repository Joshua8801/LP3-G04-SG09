package ejercicio2y3;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new InventarioModel();
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivel() {
        return nivel;
    }

    public InventarioModel getInventario() {
        return inventario;
    }

    public void recibirDanio(int danio) {
        salud -= danio;
        if (salud < 0) salud = 0;
    }

    public void usarObjeto(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item != null) {
            item.usarItem();
        }
    }

    public int atacar() {
        
        for (Item item : inventario.obtenerItems()) {
            if (item.getTipo().equalsIgnoreCase("Arma") && item.getCantidad() > 0) {
                item.usarItem();
                return 10 * nivel; 
            }
        }
        return 1; 
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}