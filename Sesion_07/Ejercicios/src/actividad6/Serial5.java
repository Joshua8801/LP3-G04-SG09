package actividad6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial5 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        try {
            fos = new FileOutputStream("alumnos.dat");
            salida = new ObjectOutputStream(fos);

            Fecha f = new Fecha(5, 9, 2011);
            Alumno a = new Alumno("Lucas González", "987654321", "Av. Los Olivos 123", f);
            System.out.println("Archivo 'alumnos.dat' creado correctamente.");

            salida.writeObject(a);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        } finally {
            try {
                if (salida != null) salida.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}

