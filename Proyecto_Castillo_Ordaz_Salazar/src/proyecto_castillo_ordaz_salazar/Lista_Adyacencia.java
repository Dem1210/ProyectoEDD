/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;



/**
 *
 * @author ydccm
 */
public class Lista_Adyacencia {


    Nodo_Adyacencia primero;

    int tamano;


    public Lista_Adyacencia() {
        this.primero = null;
        this.tamano = 0;
    }


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

    public Nodo_Adyacencia buscar(String id) {
        Nodo_Adyacencia aux = primero;

        while (aux != null && !aux.dato.id.equals(id)) {
            aux = aux.siguiente;
        }
        return aux;
    }


    public String imprimir() {
        Nodo_Adyacencia aux = primero;
        String im = "";

        while (aux != null) {
            im += "ID: " + aux.dato.id + "\n";
            im += "Nombre: " + aux.dato.nombre + "\n";
            im += "Línea: " + aux.dato.linea + "\n";
            im += "Zona: " + aux.dato.zona + "\n";
            im += "Capacidad: " + aux.dato.cap_pasajeros_hora + "\n";
            im += "--------------------------\n";

            aux = aux.siguiente;

        }
        return im;
    }
    
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
