/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

import proyecto_castillo_ordaz_salazar.Estacion;

/**
 *
 * @author ydccm
 */
public class Nodo_Adyacencia {

    Nodo_Adyacencia siguiente;
    Estacion dato;

    public Nodo_Adyacencia(Estacion dato) {
        siguiente = null;
        this.dato = dato;
    }
}
