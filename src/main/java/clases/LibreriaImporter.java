package clases;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

public class LibreriaImporter {



    public static void importar(String archivo) {

    String linea = "";

    BufferedReader bufferedReader = null;

    try (Session s = HibernateConnection.getSessionFactory().openSession()) {

        bufferedReader = new BufferedReader(new FileReader(archivo));

        Transaction t = s.beginTransaction();

        while ((linea = bufferedReader.readLine()) != null) {

            String[] libros = linea.split(";");


            Libro libro = new Libro();

            libro.setTitulo(libros[0]);
            libro.setAutor(libros[1]);
            libro.setAnio(Long.valueOf(libros[2]));
            libro.setGenero(libros[3]);
            libro.setIdiomaOriginal(libros[4]);
            libro.setSinopsis(libros[5]);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            libro.setCreated(timestamp);

            s.persist(libro);



        }

        t.commit();

        System.out.println("IMPORTACIÓN REALIZADA");

        bufferedReader.close();

    } catch (IOException e) {

        e.printStackTrace();

    }


}


}
