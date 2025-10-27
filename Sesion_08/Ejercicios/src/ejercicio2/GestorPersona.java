package ejercicio2;

import java.sql.*;
import java.util.*;

public class GestorPersona {
    private List<Persona> personas = new ArrayList<>();

    public void cargarDesdeBD() {
        personas.clear();
        try (Connection con = DriverManager.getConnection("jdbc:sqlite:ejercicio.db");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM persona")) {

            while (rs.next()) {
                personas.add(new Persona(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("edad"),
                    rs.getString("correo")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }

    public List<Persona> consultar(List<String> campos, String campoCond, String valorCond,
                                   String campoOrden, boolean ascendente, int limite) {
        return personas.stream()
            .filter(p -> {
                if (campoCond == null || valorCond == null || valorCond.isBlank()) return true;
                return switch (campoCond) {
                    case "nombre" -> p.getNombre().equalsIgnoreCase(valorCond);
                    case "edad" -> p.getEdad() == Integer.parseInt(valorCond);
                    case "correo" -> p.getCorreo().equalsIgnoreCase(valorCond);
                    default -> true;
                };
            })
            .sorted((p1, p2) -> {
                if (campoOrden == null || campoOrden.isBlank()) return 0;
                int cmp = switch (campoOrden) {
                    case "id" -> Integer.compare(p1.getId(), p2.getId());
                    case "edad" -> Integer.compare(p1.getEdad(), p2.getEdad());
                    case "nombre" -> p1.getNombre().compareToIgnoreCase(p2.getNombre());
                    default -> 0;
                };
                return ascendente ? cmp : -cmp;
            })
            .limit(limite > 0 ? limite : personas.size())
            .toList();
    }

    public void mostrarConsulta(List<Persona> resultado, List<String> campos) {
        for (Persona p : resultado) {
            for (String campo : campos) {
                switch (campo.trim()) {
                    case "id" -> System.out.print(p.getId() + " ");
                    case "nombre" -> System.out.print(p.getNombre() + " ");
                    case "edad" -> System.out.print(p.getEdad() + " ");
                    case "correo" -> System.out.print(p.getCorreo() + " ");
                }
            }
            System.out.println();
        }
    }
}