package dao;

import clases.Libro;

import java.util.List;

public interface LibroDAO {

    public List<Libro> getAll();

    public Libro insertarNuevoLibro(Libro libro);

    public void borrarLibro(Long id);

}
