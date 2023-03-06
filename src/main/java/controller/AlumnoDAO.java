/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package controller;

import model.Alumno;

/**
 *
 * @author AlejandroMarínBermúd
 */
public interface AlumnoDAO {

    
    void insertarAlumno(Alumno alumno);
    
    void listarTodo();
    
    void listarSuspensos();
    
    void estadisticas();
    
}
