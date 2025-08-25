package Ejercicio_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaGestion sistema = new SistemaGestion();

        System.out.println("=== Sistema de Gestión de Cursos ===");

        
        System.out.print("Ingrese nombre del profesor: ");
        String nombreProf = sc.nextLine();
        System.out.print("Ingrese DNI del profesor: ");
        String dniProf = sc.nextLine();
        System.out.print("Ingrese especialidad del profesor: ");
        String especialidad = sc.nextLine();
        Profesor profesor = new Profesor(nombreProf, dniProf, especialidad);

        
        System.out.print("Ingrese nombre del curso: ");
        String nombreCurso = sc.nextLine();
        System.out.print("Ingrese categoría del curso: ");
        String categoria = sc.nextLine();
        Curso curso = new Curso(nombreCurso, categoria, profesor);
        sistema.agregarCurso(curso);

   
        System.out.print("¿Cuántos estudiantes desea inscribir? ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.println("Estudiante " + (i + 1));
            System.out.print("Nombre: ");
            String nombreEst = sc.nextLine();
            System.out.print("DNI: ");
            String dniEst = sc.nextLine();
            System.out.print("Código: ");
            String codigoEst = sc.nextLine();
            Estudiante estudiante = new Estudiante(nombreEst, dniEst, codigoEst);
            curso.inscribirEstudiante(estudiante);
        }

        
        System.out.println("\n=== Información del sistema ===");
        sistema.mostrarCursos();

        sc.close();
    }
}

