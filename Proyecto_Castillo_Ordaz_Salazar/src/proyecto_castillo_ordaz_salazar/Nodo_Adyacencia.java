/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;


/**
 *
 * @author ydccm
 */
public class Nodo_Adyacencia {

    Nodo_Adyacencia siguiente;
    Estacion dato;
    int tiempo;

    public Nodo_Adyacencia(Estacion dato, int tiempo) {
        siguiente = null;
        this.dato = dato;
        this.tiempo = tiempo;
    }
}
