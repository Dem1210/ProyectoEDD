/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;


/**
 * Representa una conexión de la lista de adyacencia, con la estación vecina, el tiempo de traslado y el enlace al siguiente nodo.
 * @author ydccm
 */
public class Nodo_Adyacencia {

    Nodo_Adyacencia siguiente;
    Estacion dato;
    int tiempo;

    /** Crea un nodo con la estación vecina y el tiempo en minutos. */
/**
 * @param dato estación a la que apunta la conexión.
 * @param tiempo tiempo de traslado asociado, en minutos.
 */
    public Nodo_Adyacencia(Estacion dato, int tiempo) {
        siguiente = null;
        this.dato = dato;
        this.tiempo = tiempo;
    }
}
