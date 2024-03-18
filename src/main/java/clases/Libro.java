package clases;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private Long anio;
    private String genero;
    private String idioma_original;
    private String sinopsis;
    private java.sql.Timestamp created;


    public Libro() {
    }

    public Libro(String titulo, String autor, Long anio, String genero, String idioma_original, String sinopsis, Timestamp created) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.idioma_original = idioma_original;
        this.sinopsis = sinopsis;
        this.created = created;

    }


    public Libro(Long id, String titulo, String autor, Long anio, String genero, String idioma_0riginal, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.genero = genero;
        this.idioma_original = idioma_original;
        this.sinopsis = sinopsis;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public Long getAnio() {
        return anio;
    }

    public void setAnio(Long anio) {
        this.anio = anio;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getIdiomaOriginal() {
        return idioma_original;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idioma_original = idiomaOriginal;
    }


    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    public java.sql.Timestamp getCreated() {
        return created;
    }

    public void setCreated(java.sql.Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio=" + anio +
                ", genero='" + genero + '\'' +
                ", idiomaOriginal='" + idioma_original + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", created=" + created +
                '}';
    }
}