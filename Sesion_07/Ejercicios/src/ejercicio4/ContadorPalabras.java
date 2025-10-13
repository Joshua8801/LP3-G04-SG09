package ejercicio4;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ContadorPalabras {

    public static void main(String[] args) {
        File archivo = seleccionarArchivo();

        while (archivo == null || !archivo.exists() || !archivo.isFile()) {
            JOptionPane.showMessageDialog(null, "Archivo inválido. Seleccione otro archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            archivo = seleccionarArchivo();
        }

        try {
            analizarArchivo(archivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static File seleccionarArchivo() {
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Seleccione un archivo de texto");
        int resultado = selector.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            return selector.getSelectedFile();
        }
        return null;
    }

    private static void analizarArchivo(File archivo) throws IOException {
        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.length();

                String[] tokens = linea.split("\\s+");
                for (String token : tokens) {
                    String palabra = limpiarPalabra(token);
                    if (!palabra.isEmpty()) {
                        totalPalabras++;
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        }

        double promedio = totalLineas > 0 ? (double) totalPalabras / totalLineas : 0;

        System.out.println("Total de líneas: " + totalLineas);
        System.out.println("Total de palabras: " + totalPalabras);
        System.out.println("Total de caracteres: " + totalCaracteres);
        System.out.printf("Promedio de palabras por línea: %.2f%n", promedio);

        System.out.println("Palabras más frecuentes:");
        frecuenciaPalabras.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    private static String limpiarPalabra(String palabra) {
        StringBuilder limpia = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                limpia.append(c);
            }
        }
        return limpia.toString().toLowerCase();
    }
}
