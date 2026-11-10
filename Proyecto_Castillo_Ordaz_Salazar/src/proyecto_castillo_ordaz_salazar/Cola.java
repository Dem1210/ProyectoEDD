/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 *
 * @author ydccm
 */
public class Cola {
 
    Nodo_Adyacencia primero;

    Nodo_Adyacencia ultimo;

    /** Crea una cola vacía. */
    public Cola () {
        this.primero = null;
        this.ultimo = null;
    }


    public void encolar (Estacion dato, int tiempo) {
        Nodo_Adyacencia nuevo = new Nodo_Adyacencia (dato, tiempo);

        if (primero != null) {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        else {
            primero = nuevo;
            ultimo = nuevo;
        }
    }


    public Nodo_Adyacencia desencolar () {
        Nodo_Adyacencia aux = primero;

        if (primero != null){
            primero = primero.siguiente;
            if (primero == null) {
                ultimo = null;
            }
            aux.siguiente = null;
        }
        return aux;
    }

    /** @return true si no hay elementos */
    public boolean vacia () {
        return primero == null;
    }
}

