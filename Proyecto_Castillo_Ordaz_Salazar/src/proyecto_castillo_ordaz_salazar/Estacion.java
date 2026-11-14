/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 * Datos de una estación.
 *
 * @author ydccm
 */
public class Estacion {

    String id;
    String nombre;
    String linea;
    String zona;
    int cap_pasajeros_hora;

    /** Crea una estación. */
    public Estacion(String id, String nombre, String linea, String zona, int cap_pasajeros_hora) {
        this.id = id;
        this.nombre = nombre;
        this.linea = linea;
        this.zona = zona;
        this.cap_pasajeros_hora = cap_pasajeros_hora;
    }

    /** Devuelve "ID - Nombre". */
    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}
