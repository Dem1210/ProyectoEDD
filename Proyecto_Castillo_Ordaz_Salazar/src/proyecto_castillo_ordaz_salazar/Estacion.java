/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 * Representa una estación de la red de transporte e incluye su identificador, nombre, línea, zona y capacidad de pasajeros por hora.
 * @author ydccm
 */
public class Estacion {

    String id;
    String nombre;
    String linea;
    String zona;
    int cap_pasajeros_hora;

    /** Crea una estación. */
/**
 * Construye una estación con sus datos de identificación, línea, zona y capacidad.
 * @param id identificador único de la estación.
 * @param nombre nombre visible de la estación.
 * @param linea línea de transporte a la que pertenece.
 * @param zona zona geográfica o sector donde se ubica.
 * @param cap_pasajeros_hora capacidad estimada de pasajeros por hora.
 */
    public Estacion(String id, String nombre, String linea, String zona, int cap_pasajeros_hora) {
        this.id = id;
        this.nombre = nombre;
        this.linea = linea;
        this.zona = zona;
        this.cap_pasajeros_hora = cap_pasajeros_hora;
    }

    /** Devuelve "ID - Nombre". */
/**
 * Genera una representación textual breve de la estación.
 * @return cadena con el identificador y el nombre de la estación.
 */
    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}
