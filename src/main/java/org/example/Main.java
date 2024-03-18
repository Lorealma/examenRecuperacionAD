package org.example;

import clases.LibreriaImporter;
import clases.Libro;
import implementacion.LibroDAOImplement;
import org.hibernate.SessionFactory;
import utils.HibernateConnection;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

       SessionFactory comprobar = HibernateConnection.getSessionFactory();


       LibroDAOImplement dao = new LibroDAOImplement();


       File archivo = new File("./libreria.csv");


       LibreriaImporter.importar(String.valueOf(archivo));


        System.out.println(" ");
        System.out.println("IMPRIMIR TODOS LOS LIBROS: ");
        System.out.println(" ");

        List<Libro> libros = dao.getAll();
        for(Libro libro: libros) {

            System.out.println(libro);

        }


        System.out.println(" ");
        System.out.println("INSERTAR NUEVO LIBRO: ");
        System.out.println(" ");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Libro libro1 = new Libro("NuevoLibro", "Lorena", 2024L, "Misterio", "Español", "Libro creado", timestamp);
        Libro libro2 = new Libro("OtroLibro", "Juan", 2023L, "Romantico", "Español", "Libro creado 2", timestamp);
        Libro libro3 = new Libro("NuevoLibro", "Pablo", 2022L, "Novela negra", "Español", "Libro creado 3", timestamp);
        Libro libro4 = new Libro("NuevoLibro", "Lucia", 2021L, "Historia", "Español", "Libro creado 4", timestamp);
        Libro libro5 = new Libro("NuevoLibro", "Marina", 2020L, "Ciencia", "Español", "Libro creado 5", timestamp);

        dao.insertarNuevoLibro(libro1);
        dao.insertarNuevoLibro(libro2);
        dao.insertarNuevoLibro(libro3);
        dao.insertarNuevoLibro(libro4);
        dao.insertarNuevoLibro(libro5);




        System.out.println(" ");
        System.out.println("BORRAR LIBRO: ");
        System.out.println(" ");

        dao.borrarLibro(6L);





    }
}