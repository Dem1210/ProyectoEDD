/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 * Lista enlazada con las conexiones de una estación.
 *
 * @author ydccm
 */
public class Lista_Adyacencia {

    Nodo_Adyacencia primero;
    int tamano;

    /** Crea una lista vacía. */
    public Lista_Adyacencia() {
        this.primero = null;
        this.tamano = 0;
    }

    /** Inserta una conexión al final. */
    public void insertar(Estacion dato, int tiempo) {
        Nodo_Adyacencia nuevo = new Nodo_Adyacencia(dato,tiempo);
        Nodo_Adyacencia aux = primero;

        if (primero != null) {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        } else {
            primero = nuevo;
        }
        tamano++;
    }

    /** Elimina la conexión hacia el id indicado; devuelve true si existía. */
    public boolean eliminar(String id) {
        Nodo_Adyacencia aux = primero;

        if (primero == null) {
            return false;
        }

        if (id.equals(primero.dato.id)) {
            primero = primero.siguiente;
            tamano--;
            return true;
        }
        while (aux.siguiente != null && !aux.siguiente.dato.id.equals(id)) {
            aux = aux.siguiente;
        }
        if (aux.siguiente != null) {
            aux.siguiente = aux.siguiente.siguiente;
            tamano--;
            return true;
        }
        return false;
    }

    /** Busca la conexión hacia el id indicado (null si no existe). */
    public Nodo_Adyacencia buscar(String id) {
        Nodo_Adyacencia aux = primero;

        while (aux != null && !aux.dato.id.equals(id)) {
            aux = aux.siguiente;
        }
        return aux;
    }

    /** Devuelve los ids de los vecinos. */
    public String imprimir2(){
        Nodo_Adyacencia aux = primero;
        String im = "";

        while (aux != null) {
            im += " -> " + aux.dato.id;
            aux = aux.siguiente;
        }
        return im;
    }
}
