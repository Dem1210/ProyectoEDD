/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 * Implementa una lista enlazada simple con las conexiones de una estación y sus tiempos de traslado.
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


/**
 * Agrega al final una conexión hacia la estación indicada.
 * @param dato estación vecina que se almacenará.
 * @param tiempo tiempo de traslado asociado, en minutos.
 */
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


/**
 * Elimina de la lista la conexión que apunta a la estación indicada.
 * @param id identificador de la estación vecina que se eliminará.
 * @return true si se encontró y eliminó; false si no existía.
 */
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


/**
 * Busca una conexión por el identificador de la estación vecina.
 * @param id identificador que se desea localizar.
 * @return nodo encontrado o null si no existe.
 */
    public Nodo_Adyacencia buscar(String id) {
        Nodo_Adyacencia aux = primero;

        while (aux != null && !aux.dato.id.equals(id)) {
            aux = aux.siguiente;
        }
        return aux;
    }

    /** Devuelve los ids de los vecinos. */
/**
 * Genera una cadena con los identificadores de las estaciones vecinas.
 * @return representación textual de los vecinos de esta lista.
 */
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
