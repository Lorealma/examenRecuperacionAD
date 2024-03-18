package implementacion;

import clases.Libro;
import dao.LibroDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateConnection;

import java.util.ArrayList;
import java.util.List;

public class LibroDAOImplement implements LibroDAO {


    public LibroDAOImplement() {
    }

    @Override
    public List<Libro> getAll() {

        List<Libro> libros = new ArrayList<Libro>();

        try(Session s= HibernateConnection.getSessionFactory().openSession()){

            Query<Libro> q=s.createQuery("from Libro", Libro.class);
            libros = q.getResultList();

        }

        return libros;

    }

    @Override
    public Libro insertarNuevoLibro(Libro libro) {

        Libro nuevoLibro = libro;

        try(Session s = HibernateConnection.getSessionFactory().openSession()){

            Transaction t = s.beginTransaction();
            s.persist(nuevoLibro);
            t.commit();

        }catch(Exception e){

            System.out.println("FALLO AL REALIZAR LA INSERCIÓN");

        }

        return nuevoLibro;

    }

    @Override
    public void borrarLibro(Long id) {

        try(Session s= HibernateConnection.getSessionFactory().openSession()){

            Libro libroPersistente = s.get(Libro.class, id);

            Transaction t = s.beginTransaction();
            s.remove(libroPersistente);
            t.commit();


        }


    }


}
