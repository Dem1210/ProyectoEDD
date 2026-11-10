/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;


/**
 *
 * @author ydccm
 */
public class Grafo {

    Vertice primero;

    public Grafo() {
        this.primero = null;
    }

    public void insertar(Estacion dato) {

        Vertice nuevo = new Vertice(dato);
        Vertice aux = primero;

        if (primero != null) {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        } else {
            primero = nuevo;
        }
    }

    public Vertice eliminar(String id) {
        Vertice aux = primero;

        if (primero == null) {
            return null;
        }
        if (primero.dato.id.equals(id)) {
            primero = primero.siguiente;
            return aux;
        }
        while (aux.siguiente != null && !aux.siguiente.dato.id.equals(id)) {
            aux = aux.siguiente;
        }
        if (aux.siguiente != null) {
            aux.siguiente = aux.siguiente.siguiente;
        }

        return aux;
    }
    
    public Vertice buscar (String id) {
        Vertice aux = primero;
        
        while (aux != null && !aux.dato.id.equals(id)) {
           aux = aux.siguiente; 
        }
        return aux;
    }
    
    public String imprimir () {
        Vertice aux = primero;
        String h = "";
        
        while (aux != null) {
           h += aux.dato.id + aux.lista.imprimir2() + "\n";
            aux = aux.siguiente;
        }
        return h;
    }
    
    public void insertar_arista(String id1, String id2, int tiempo) {
        Vertice aux1 = this.buscar(id1);
        Vertice aux2 = this.buscar(id2);
        
        if (aux1 != null && aux2 != null){
            aux1.lista.insertar(aux2.dato, tiempo);
            aux2.lista.insertar(aux1.dato, tiempo);
        }    
    }
}
