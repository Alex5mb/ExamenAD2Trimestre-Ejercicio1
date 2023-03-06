/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.ejercicio1;

import controller.AlumnoDAO;
import controller.AlumnoDAODB;
import java.util.Scanner;

/**
 *
 * @author AlejandroMarínBermúd
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        int option = 0;
        var sc = new Scanner(System.in);

        AlumnoDAO abh = new AlumnoDAODB();
        AlumnoDAODB adodb = new AlumnoDAODB();

        while (option != 4) {
            System.out.println("----------------------------------------------------");
            System.out.println("Bienvenido a la aplicación del Ejercicio1");
            System.out.println("By Alejandro Marín Bermúdez");
            System.out.println("----------------------------------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("0. nuevo alumno");
            System.out.println("1. Listar alumnos");
            System.out.println("2. listar suspensos");
            System.out.println("3. estadisticas");
            System.out.println("4. Salir");
            option = sc.nextInt();

            switch (option) {
                case 0 -> {
                    abh.insertarAlumno(adodb.crearAlumno());
                    sc.nextLine();
                }
                case 1 -> {
                    abh.listarTodo();
                    sc.nextLine();
                }
                case 2 -> {
                    abh.listarSuspensos();
                    sc.nextLine();
                }
                case 3 -> {
                    abh.estadisticas();
                    sc.nextLine();
                }
                case 4 -> {
                    System.out.println("Gracias por usar nuestra aplicación");
                    System.out.println("Saliendo...");
                }
            }

        }
    }
}
