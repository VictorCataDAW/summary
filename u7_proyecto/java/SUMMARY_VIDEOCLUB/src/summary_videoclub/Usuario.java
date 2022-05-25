/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summary_videoclub;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase <cite>Usuario</cite>
 *
 * Declaración de los atributos privados que debe tener cada usuario
 *
 *
 * @author Victor Marco
 *
 */
public class Usuario {

    /**
     * codigo del usuario
     */
    private int codigoUsuario = 0;

    /**
     * nombre del usuario
     */
    private final String NOMBRE;

    /**
     * apellidos del usuario
     */
    private final String APELLIDOS;

    /**
     * teléfono del usuario
     */
    private int telefono;

    /**
     * dni del usuario
     */
    private String dni;

    /**
     * crédito del usuario
     */
    private double credito;

    /**
     * lista de Pelicuas vistas por el ususario
     */
    private ArrayList<Pelicula> peliculasVistas;

    /**
     * Constructor de un usuario con todos los atributos que debe tener un
     * usuario
     *
     * @param NOMBRE <b>nombre</b> del usuario
     * @param APELLIDOS <b>apellidos</b> del usuario
     * @param telefono <b>telefono</b> del usuario
     * @param dni <b>Documento Nacional de Identidad (DNI)</b> del usuario
     * @param credito <b>credito</b> que dispone el usuario para alquilar
     * películas
     * @param peliculasVistas <b>lista de peliculas</b> vistas por del usuario
     *
     */
    public Usuario(String NOMBRE, String APELLIDOS, int telefono, String dni, double credito, ArrayList<Pelicula> peliculasVistas) {
        this.codigoUsuario = ((int) (Math.random() * 1000 + 1));
        this.NOMBRE = NOMBRE;
        this.APELLIDOS = APELLIDOS;
        this.telefono = telefono;
        this.dni = dni;
        this.credito = credito;
        this.peliculasVistas = new ArrayList<Pelicula>(peliculasVistas);

    }

    /**
     * consulta el codigo del usuario
     *
     * @return Devuelve el codigo del usuario
     */
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * consulta el nombre del usuario
     *
     * @return Devuelve el nombre del usuario
     */
    public String getNOMBRE() {
        return NOMBRE;
    }

    /**
     * consulta los apellidos del usuario
     *
     * @return Devuelve los apellidos del usuario
     */
    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    /**
     * consulta el número de teléfono del usuario
     *
     * @return Devuelve el número de teléfono del usuario
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * consulta el Documento Nacional de Identidad del usuario
     *
     * @return Devuelve el Documento Nacional de Identidad del usuario
     */
    public String getDni() {
        return dni;
    }

    /**
     * consulta el crédito disponible del empleado para alquilar películas
     *
     * @return Devuelve el crédito del usuario para alquilar películas
     */
    public double getCredito() {
        return credito;
    }

    /**
     * consulta el listado de películas vistas del usuario
     *
     * @return Devuelve el Documento Nacional de Identidad del usuario
     */
    public ArrayList<Pelicula> getPeliculasVistas() {
        return peliculasVistas;
    }

    /**
     * establece el numero de teléfono del usuario introducido por parametro
     *
     * @param telefono es un número que define el numero de teléfono del usuario
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * establece el Documento Nacional de Identidad del usuario
     *
     * @param dni es un String que define el Documento Nacional de Identidad del
     * usuario
     */
    public void setDNI(String dni) {
        this.dni = dni;
    }

    /**
     * establece el crédito disponible del usuario para alquilar peliculas
     * introducido por parámetro
     *
     * @param credito es un número double que define el crédito disponible para
     * alquilar películas
     */
    public void setCredito(double credito) {
        this.credito = credito;
    }

    /**
     * establece el crédito disponible del usuario para alquilar peliculas
     * introducido por parámetro
     *
     * @param credito es un número double que define el crédito disponible para
     * alquilar películas
     */
    /**
     * codifica cada usuario con un numero para poder localizarlo el sistema con
     * facilidad
     *
     * @return un numero entero que calcula JAVA
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * comprueba que no hay 2 empleados iguales segun su dni, nombre y apellidos
     *
     * @param obj es un objeto del tipo Object
     * @return <ul>
     * <li>true: si hay 2 empleados que coinciden en dni, nombre y apellidos
     * </li>
     * <li>false: cuando no hay usuarios repetidos </li>
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
        final Usuario other = (Usuario) obj;
        if (this.dni != other.dni) {
            return false;
        }
        if (!Objects.equals(this.NOMBRE, other.NOMBRE)) {
            return false;
        }
        if (!Objects.equals(this.APELLIDOS, other.APELLIDOS)) {
            return false;
        }
        return true;
    }

    /**
     * imprime los datos del usuario, 1 dato por linea
     */
    @Override
    public String toString() {
        return "Usuario " + codigoUsuario + "\nNOMBRE: " + NOMBRE + "\n APELLIDOS: " + APELLIDOS
                + "\n telefono: " + telefono + "\n DNI: " + dni + "\n credito: " + credito
                + " €\n" + peliculasVistas;

    }

    /**
     * metodo de recarga el credito de usuario la cantidad introducida por
     * parámetro
     *
     * @param recarga es un número entero que será el valor de la recarga de
     * crédito del usuario
     */
    public void recargarCredito(double recarga) {
        this.credito += recarga;
        System.out.println("Saldo recargado con " + recarga + " €");
        System.out.println("Saldo total " + credito + "\n");
    }
}
