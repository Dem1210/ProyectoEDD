/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 *
 * @author ydccm
 */
public class Estacion {

    String id;
    String nombre;
    String linea;
    String zona;
    int cap_pasajeros_hora;

    public Estacion(String id, String nombre, String linea, String zona, int cap_pasajeros_hora) {
        this.id = id;
        this.nombre = nombre;
        this.linea = linea;
        this.zona = zona;
        this.cap_pasajeros_hora = cap_pasajeros_hora;
    }
}
