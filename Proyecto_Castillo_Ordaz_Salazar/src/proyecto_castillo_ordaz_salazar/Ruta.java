/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;


/**
 * Contiene el resultado de una consulta de ruta óptima: estaciones del recorrido, tiempo total e indicador de existencia de camino.
 * @author ameli
 */
public class Ruta {
    String[] estaciones;
    int tiempo;
    boolean existe;

    /** Crea una ruta con los ids del recorrido, el tiempo total y si existe camino. */
/**
 * Construye el resultado de una consulta de ruta óptima.
 * @param estaciones identificadores de las estaciones en el orden del recorrido.
 * @param tiempo suma de los tiempos de traslado, en minutos.
 * @param existe indica si se encontró un camino entre el origen y el destino.
 */
    public Ruta(String[] estaciones, int tiempo, boolean existe) {
        this.estaciones = estaciones;
        this.tiempo = tiempo;
        this.existe = existe;
    }
}
