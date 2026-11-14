/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 * Implementación propia de una cola enlazada utilizada como estructura auxiliar para recorridos en anchura (BFS).
 * @author ydccm
 */
public class Cola {
    Nodo_Adyacencia primero;
    Nodo_Adyacencia ultimo;

    /** Crea una cola vacía. */
/**
 * Inicializa una cola vacía.
 */
    public Cola () {
        this.primero = null;
        this.ultimo = null;
    }

    /** Agrega una estación al final de la cola. */
/**
 * Inserta al final un nodo que contiene la estación y el tiempo asociado.
 * @param dato estación que se incorpora a la cola.
 * @param tiempo peso asociado al nodo; el recorrido BFS utiliza cero.
 */
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
/**
 * Retira y devuelve el primer nodo de la cola. Si está vacía, devuelve null.
 * @return primer nodo retirado o null cuando no hay elementos.
 */
    public Nodo_Adyacencia desencolar () {
        Nodo_Adyacencia aux = primero;

        if (primero != null){
            primero = primero.siguiente;
        }
        return aux;
    }

    /** Indica si la cola está vacía. */
/**
 * Comprueba si la cola no contiene elementos.
 * @return true si está vacía; false en caso contrario.
 */
    public boolean vacia () {
        return primero == null;
    }
}
