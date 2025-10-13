package ejercicio2y3;

import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void recibirDanio(int danio) {
        salud -= danio;
        if (salud < 0) salud = 0;
    }

    public int atacar() {
        Random rand = new Random();
        return rand.nextInt(5) + nivel; 
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}