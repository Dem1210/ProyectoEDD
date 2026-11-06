/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

import proyecto_castillo_ordaz_salazar.Lista_Adyacencia;
import proyecto_castillo_ordaz_salazar.Estacion;

/**
 *
 * @author ydccm
 */
public class Vertice {

    Vertice siguiente;
    Estacion dato;
    Lista_Adyacencia lista;

    public Vertice(Estacion dato) {
        this.siguiente = null;
        this.dato = dato;
        this.lista = new Lista_Adyacencia();
    }

}
