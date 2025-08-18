package Ejer;

import java.util.Random;

public class Ejercicio_3 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] frecuencia = new int[6];

        
        for (int i = 0; i < 20000; i++) {
            int cara = random.nextInt(6) + 1; 
            frecuencia[cara - 1]++;           
        }

        System.out.println("Frecuencia de cada cara después de 20,000 lanzamientos:");
        for (int i = 0; i < frecuencia.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencia[i] + " veces");
        }
    }
}
