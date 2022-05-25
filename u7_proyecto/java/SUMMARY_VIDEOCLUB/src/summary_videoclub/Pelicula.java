/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summary_videoclub;

import java.util.Objects;

/**
 * Clase <cite>Pelicula</cite>
 *
 * Declaración de los atributos privados que debe tener cada película
 *
 *
 * @author Victor Marco
 *
 */
public class Pelicula {

    /**
     * titulo constante de la película,
     */
    private final String TITULO;

    /**
     * genero de la película
     */
    private String genero;

    /**
     * año de estreno de la película
     */
    private int anioEstreno;

    /**
     * indica<ul>
     * <li><b>true</b> si la pelicula es novedad
     * <li><b>false</b> si no es novedad
     * </ul>
     */
    private boolean esNovedad;

    /**
     * numero de tipo double que indica el coste de alquilar una película 24
     * horas
     */
    private double costeAlquiler;

    /**
     * código interno del VideoClub para identificar la película
     */
    public int codigoPelicula = 0;

    /**
     * texto que indica a qué público va dirigida la película por edades.
     */
    private String calificacion;

    /**
     * Constructor de una película con todos los atributos que debe tener una
     * película
     *
     * @param TITULO <b>titulo</b> de la película
     * @param genero <b>genero</b> de la película
     * @param anioEstreno <b>año de estreno</b> de la película
     * @param esNovedad <b>booleano</b> que indica si la película es novedad o
     * no
     * @param costeAlquiler <b>coste de alquilar</b> la película 24 horas
     * @param calificacion <b>calificación</b> de la película que indica a que
     * edad se recomienda ver la película
     *
     */
    public Pelicula(String TITULO, String genero, int anioEstreno, boolean esNovedad,
            double costeAlquiler, String calificacion) {
        this.codigoPelicula = ((int) (Math.random() * 1000 + 1));
        this.TITULO = TITULO;
        this.genero = genero;
        this.anioEstreno = anioEstreno;
        this.esNovedad = esNovedad;
        this.costeAlquiler = costeAlquiler;
        this.calificacion = calificacion;

    }

    /**
     * consulta el título de la película
     *
     * @return Devuelve el título de la película
     */
    public String getTITULO() {
        return TITULO;
    }

    /**
     * consulta el género de la película
     *
     * @return Devuelve el género de la película
     */
    public String getGenero() {
        return genero;
    }

    /**
     * consulta el año de estreno de la película
     *
     * @return Devuelve el año de estreno de la película
     */
    public int getAnioEstreno() {
        return anioEstreno;
    }

    /**
     * consulta si la pelicula es novedad o no
     *
     * @return Devuelve <ul>
     * <li><b>true</b> cuando la película es novedad
     * <li><b>false</b> cuando la película no es novedad
     * </ul>
     */
    public boolean isEsNovedad() {
        return esNovedad;
    }

    /**
     * consulta el coste de alquilar la película 224 horas
     *
     * @return Devuelve el coste de alquilar la película 24 horas
     */
    public double getCosteAlquiler() {
        return costeAlquiler;
    }

    /**
     * consulta el código asignado por el VideoClub a la película
     *
     * @return Devuelve el código asignado por el VideoClub a la película
     */
    public int getCodigoPelicula() {
        return codigoPelicula;
    }

    /**
     * imprime los datos de la película, 1 dato por línea
     */
    @Override
    public String toString() {
        return "TITULO = " + TITULO + "\n Genero: " + genero
                + "\n Año Estreno: " + anioEstreno + "\n Es novedad: " + esNovedad
                + "\n Coste Alquiler: " + costeAlquiler + "\n Codigo pelicula: "
                + codigoPelicula + "\n Calificación: " + calificacion + "\n";

    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    /**
     * el metodo equals de la clase Pelicula, una pelicula es igual a 
     * otra si su titulo y el codigo de la pelicula es el mismo
     * 
     * @param obj recibe por parametro un objeto obj de tipo Object
     * @return <ul>
     * <li><b>true</b> en caso de encontrar 2 peliculas iguales
     * <li><b>false</b> en caso de no encontrar 2 peliculas iguales
     * </ul>
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (this.codigoPelicula != other.codigoPelicula) {
            return false;
        }
        if (!Objects.equals(this.TITULO, other.TITULO)) {
            return false;
        }
        return true;
    }
    
    

}
