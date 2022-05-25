/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package summary_videoclub;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Clase <cite>VideoClub</cite>
 *
 * Declaración de los ArrayList que debe tener el VideoClub<ul>
     * <li>peliculas disponibles para alquilar
     * <li>peliculas alquiladas que no estan disponibles para alquilar
     * <li>peliculas del Video Club en posesión
     * <li>lista de usuarios del Video Club
     * <li>peliculas vistas por un usuario
     * </ul>
 * @author Victor Marco
 */
public class VideoClub {

    static LocalDate diaAlquiler = LocalDate.now();

    static ArrayList<Pelicula> peliculasDisponibles = new ArrayList();
    static ArrayList<Pelicula> peliculasAlquiladas = new ArrayList();
    static ArrayList<Pelicula> peliculasVideoClub = new ArrayList();
    static ArrayList<Usuario> listaUsuarios = new ArrayList();
    static ArrayList<Pelicula> peliculasVistas = new ArrayList();
    

    
    /**
     * método alquilarPelicula de la clase <cite>VideoClub</cite>
     * 
     * un usuario u va a alquilar una pelicula p. Para poder confirmarse el alquiler
     * debe disponer de almenos el crédito que cuesta alquilar la película. Si no puede 
     * alquilar debido al saldo, aparecerá en un mensaje. Si la puede alquilar, aparecerá 
     * el nombre de la pelicula y el usuario. la pelicula se añade a la lista de peliculas
     * vistas del usuario, se añade la pelicula a la lista de peliculas alquiladas y se quita
     * de la lista de peliculas disponibles
     * 
     * @param u es el usuario del tipo Usuario que va a alquilar una película
     * @param p es la película del tipo Película que se va a alquilar
     */
    public static void alquilarPelicula(Usuario u, Pelicula p) {

        LocalDate fechaAlquiler = LocalDate.now();
        double saldoFinal;
        saldoFinal = u.getCredito() - p.getCosteAlquiler();

        if (saldoFinal <= p.getCosteAlquiler()) {
            System.out.println("NO DISPONE DE SALDO SUFICIENTE PARA ALQUILAR. ");
        } else {
            System.out.println("PELICULA " + p.getTITULO() + " ALQUILADA A "
                    + u.getNOMBRE() + " " + fechaAlquiler);
            System.out.println("TIENE QUE DEVOLVER LA PELICULA " + fechaAlquiler.plusDays(1) + "\n");
            //Formalizar alquiler
            u.getPeliculasVistas().add(p);
            peliculasAlquiladas.add(p);
            peliculasDisponibles.remove(p);

            u.setCredito(saldoFinal);

        }

    }

    /**
     * metodo devolverPelicula de la clase <cite>VideoClub</cite>
     * 
     * un usuario u, devuelve una pelicula p, alquilada el dia fechaAlquiler
     * en función de los dias que el cliente ha tenido alquilada la pelicula, puede 
     * pasar lo siguiente<ul>
     * <li> se devuelve el mismo dia que la alquila, y se le devuelve un importe de
     * 1'5€ a su credito.
     * <li> se devuelve al dia siguiente, devolución correcta.
     * <li> se devuelve pasados 2 dias o mas, se le hace un cargo de 1€ por dia extra.
     * </ul>
     * la pelicula se añade a la lista peliculasDisponibles y se quita de la lista de
     * peliculas alquiladas
     * 
     * 
     * @param u es un objeto usuario de nombre u del tipo Usuario
     * @param p es un objeto pelicula de nombre p del tipo Pelicula
     * @param fechaAlquiler  es un LocalDate que es la fecha en que se alquila la película
     */
    public static void devolverPelicula(Usuario u, Pelicula p,
            LocalDate fechaAlquiler) {
        int dias;
        double saldoFinal;
        LocalDate fechaDevolucion = LocalDate.now();
        

        if (fechaDevolucion.isEqual(fechaAlquiler)) {
            System.out.println("DEVOLUCION PELICULA CORRECTA");
            System.out.println("DEVOLUCION 1.5 € A SU SALDO POR DEVOLUCION EN "
                    + "EL MISMO DIA");
            saldoFinal = u.getCredito() + 1.5;
            u.setCredito(saldoFinal);
        } else {
            dias = (int) ChronoUnit.DAYS.between(fechaDevolucion, fechaAlquiler);
            if (dias <= 1) {
                System.out.println(dias + " DIA. DEVOLUCION PELICULA CORRECTA EN FECHA");

            } else if (dias >= 2) {
                System.out.println(dias + " DIAS. DEVOLUCION CON CARGO.");
                System.out.println("PENALIZACION 1 € POR DIA");
                System.out.println("PENALIZACION TOTAL "+dias + " €");
                u.setCredito(u.getCredito() - dias);
                System.out.println("SALDO FINAL "+u.getCredito());
                if(u.getCredito()<=3.5){
                    System.out.println("DEBE RECARGAR SALDO ANTES DE VOLVER A ALQUILAR");
                }

            } else {
                System.out.println("error en la fecha");
            }

        }
        peliculasDisponibles.add(p);
        peliculasAlquiladas.remove(p);

    }

    /**
     * metodo main que :
     * <ul>
     * <li>crea 3 usuarios
     * <li>crea 10 peliculas
     * <li>añade las peliculas a la lista del VideoClub y de peliculasDisponibles
     * <li>1 usuario alquila una pelicula
     * <li>1 usuario devuelve una pelicula
     * <li>1 usuario hace una recarga de credito
     * </ul>
     * @param args es un array de tripo String. Es la definición de los argumentos que recibe el método main
     * 
     */
    public static void main(String[] args){

        Usuario u1 = new Usuario("VICTOR", "MARCO CASAS", 666555899, "20456654P", 8,
                new ArrayList<>(peliculasVistas));
        Usuario u2 = new Usuario("DAVID", "MARTINEZ PEÑA", 666478951, "20987654Q", 20,
                new ArrayList<>(peliculasVistas));
        Usuario u3 = new Usuario("NICO", "MARCO SANJUAN", 658606305, "20989475S", 20,
                new ArrayList<>(peliculasVistas));
        
        try{

        listaUsuarios.add(u1);
        listaUsuarios.add(u2);
        listaUsuarios.add(u3);
        
        }catch (Exception e){
            System.out.println("ERROR AL AÑADIR USUARIOS A LA LISTA."
                    + "EL ERROR ES "+e.getMessage());
        }

        Pelicula p1 = new Pelicula("ANGELES Y DEMONIOS", "thriller", 2009, true,
                3.5, "+13 años");
        Pelicula p2 = new Pelicula("AGORA", "aventura,drama,biografia", 2009, true,
                3.5, "+13 años");
        Pelicula p3 = new Pelicula("BOLT", "animación,aventura,comedia", 2008, false,
                3.5, "TP");
        Pelicula p4 = new Pelicula("BIENVENIDOS A ZOMBIELAND", "aventura, comedia, terror",
                2009, true, 3.5, "+13 años");
        Pelicula p5 = new Pelicula("CELDA 211", "accion,drama", 2009, false,
                3.5, "+18 años");
        Pelicula p6 = new Pelicula("COCO CHANNEL", "drama,biografia", 2009, true,
                3.5, "+7 años");
        Pelicula p7 = new Pelicula("DESTINO WOODSTOCK", "drama,comedia,biografia",
                2009, true, 3.5, "TP");
        Pelicula p8 = new Pelicula("DELTA", "drama", 2009, true, 3.5, "+18 años");
        Pelicula p9 = new Pelicula("EL CABALLERO OSCURO", "accion,aventura", 2008, false,
                3.5, "+12 años");
        Pelicula p10 = new Pelicula("EL JUEGO DEL AHORCADO", "drama", 2008, false,
                3.5, "+13 años");
        
        try{
        peliculasVideoClub.add(p1);
        peliculasVideoClub.add(p2);
        peliculasVideoClub.add(p3);
        peliculasVideoClub.add(p4);
        peliculasVideoClub.add(p5);
        peliculasVideoClub.add(p6);
        peliculasVideoClub.add(p7);
        peliculasVideoClub.add(p8);
        peliculasVideoClub.add(p9);
        peliculasVideoClub.add(p10);
        peliculasDisponibles.addAll(peliculasVideoClub);
        
        }catch (Exception e){
            System.out.println("ERROR AL AÑADIR PELICULAS A LA LISTA."
                    + "EL ERROR ES "+e.getMessage());
        }
        
        //listamos usuarios y peliculas del VideoClub

        System.out.println(listaUsuarios);
        System.out.println(peliculasVideoClub);
        //mostramos la información del usuario u1
        System.out.println(u1);
        
        //usuario u1 alquila la película p1
        alquilarPelicula(u1, p1);

        //mostramos datos del usuario u1 para ver en que ha cambiado el usuario
        System.out.println(u1);
        
        //listamos las peliculas del VideoClub y las peliculasAlquiladas para
        //comprobar que al alquilar una pelicula, se ha actualizado los listados
        System.out.println(peliculasVideoClub);
        System.out.println(peliculasAlquiladas);
        
        //el usuario u1 devuelve la pelicula p1
        //se puede modificar la fecha de devolución para ver los distintos escenarios
        devolverPelicula(u1, p1, LocalDate.of(2022, 5, 25));
        
        //mostramos la información del usuario u1 después de la devolución de la película
        System.out.println(u1);
        
        //el usuario u1 recarga su credito 7 € (por ejemplo)
        u1.recargarCredito(7);
        
        //mostramos el usuario u1 despues de recargar su crédito
        System.out.println(u1);
        
        

    }

}
