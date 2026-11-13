/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 * Cola de nodos, usada en el recorrido BFS.
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

    /** Agrega una estación al final de la cola. */
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

    /** Saca el primer nodo de la cola (null si está vacía). */
    public Nodo_Adyacencia desencolar () {
        Nodo_Adyacencia aux = primero;

        if (primero != null){
            primero = primero.siguiente;
        }
        return aux;
    }

    /** Indica si la cola está vacía. */
    public boolean vacia () {
        return primero == null;
    }
}
