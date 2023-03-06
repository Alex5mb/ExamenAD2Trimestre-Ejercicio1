/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.Query;
import model.Alumno;

/**
 *
 * @author AlejandroMarínBermúd
 */
public class AlumnoDAODB implements AlumnoDAO {

    public Alumno crearAlumno() {

        var sc = new Scanner(System.in);
        var a = new Alumno();

        System.out.println("Introduce el nombre del alumno");
        a.setNombre(sc.nextLine());

        System.out.println("Introduce su numero de telefono");

        a.setTelefono(sc.nextLine());

        System.out.println("Introduce su correo");

        a.setEmail(sc.nextLine());

        System.out.println("Introduce su nota en el modulo AD");

        a.setAd(sc.nextDouble());

        System.out.println("Introduce su nota en el modulo DI");

        a.setDi(sc.nextDouble());

        return a;

    }

    @Override
    public void insertarAlumno(Alumno alumno) {

        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void listarTodo() {

        ArrayList<Alumno> salida;

        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        Query query = em.createQuery("select a from Alumno a", Alumno.class);

        salida = (ArrayList<Alumno>) query.getResultList();

        salida.forEach((alumno) -> {
            System.out.println(alumno);
        });
        em.close();

    }

    @Override
    public void listarSuspensos() {
        ArrayList<Alumno> salida;

        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        Query query = em.createQuery("select a from Alumno a where ad < :ad or di < : di", Alumno.class);

        query.setParameter("ad", 5);
        query.setParameter("di", 5);

        salida = (ArrayList<Alumno>) query.getResultList();

        salida.forEach((alumno) -> {
            System.out.println(alumno);
        });
        em.close();
    }

    @Override
    public void estadisticas() {

        ArrayList<Alumno> salida;

        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        Query query = em.createQuery("Select AVG(ad) from Alumno");

        salida = (ArrayList<Alumno>) query.getResultList();
        System.out.println("Nota media en AD");
        System.out.println(salida);

        query = em.createQuery("Select AVG(di) from Alumno");
        salida = (ArrayList<Alumno>) query.getResultList();
        System.out.println("Nota media en DI");
        System.out.println(salida);

        query = em.createQuery("select (count(a)*100)/Max(id + 1) from Alumno a where ad > :ad and di > : di", Alumno.class);
        query.setParameter("ad", 5);
        query.setParameter("di", 5);
        salida = (ArrayList<Alumno>) query.getResultList();
        System.out.println("Porcentaje de Alumnos aprobados");
        System.out.println(salida + "%");

    }

}
