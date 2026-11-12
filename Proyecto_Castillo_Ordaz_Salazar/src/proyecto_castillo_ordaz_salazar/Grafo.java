/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 *
 * @author ameli
 */
public class Grafo {


    Vertice primero;
    private Vertice ultimo;
    private final TablaHash<Vertice> indice = new TablaHash<>(64);
    private int numVertices;
    private int numAristas;


    public Grafo() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public boolean insertar(Estacion dato) {
        if (dato == null || indice.contiene(dato.id)) {
            return false;
        }
        Vertice nuevo = new Vertice(dato);
        if (primero == null) {
            primero = nuevo;
        } else {
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        indice.poner(dato.id, nuevo);
        numVertices++;
        return true;
    }


    public Vertice eliminar(String id) {
        Vertice v = buscar(id);
        if (v == null) {
            return null;
        }
        for (Nodo_Adyacencia n = v.lista.primero; n != null; n = n.siguiente) {
            Vertice vecino = indice.obtener(n.dato.id);
            if (vecino != null && vecino.lista.eliminar(id)) {
                numAristas--;
            }
        }
        if (primero == v) {
            primero = v.siguiente;
            if (primero == null) {
                ultimo = null;
            }
        } else {
            Vertice aux = primero;
            while (aux.siguiente != v) {
                aux = aux.siguiente;
            }
            aux.siguiente = v.siguiente;
            if (ultimo == v) {
                ultimo = aux;
            }
        }
        v.siguiente = null;
        indice.eliminar(id);
        numVertices--;
        return v;
    }

 
    public Vertice buscar (String id) {
        if (id == null) {
            return null;
        }
        return indice.obtener(id);
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

    public boolean insertar_arista(String id1, String id2, int tiempo) {
        if (id1 == null || id2 == null || id1.equals(id2) || tiempo <= 0) {
            return false;
        }
        Vertice aux1 = this.buscar(id1);
        Vertice aux2 = this.buscar(id2);

        if (aux1 == null || aux2 == null) {
            return false;
        }
        Nodo_Adyacencia existente = aux1.lista.buscar(id2);
        if (existente != null) {
            existente.tiempo = tiempo;
            aux2.lista.buscar(id1).tiempo = tiempo;
            return true;
        }
        aux1.lista.insertar(aux2.dato, tiempo);
        aux2.lista.insertar(aux1.dato, tiempo);
        numAristas++;
        return true;
    }


    public boolean eliminar_arista(String id1, String id2) {
        Vertice aux1 = this.buscar(id1);
        Vertice aux2 = this.buscar(id2);

        if (aux1 == null || aux2 == null || !aux1.lista.eliminar(id2)) {
            return false;
        }
        aux2.lista.eliminar(id1);
        numAristas--;
        return true;
    }

    public int grado(String id) {
        Vertice v = buscar(id);
        return v == null ? 0 : v.lista.tamano;
    }


    public String[] ids() {
        String[] res = new String[numVertices];
        int i = 0;
        for (Vertice v = primero; v != null; v = v.siguiente) {
            res[i++] = v.dato.id;
        }
        return res;
    }


    public int numVertices() {
        return numVertices;
    }

    public int numAristas() {
        return numAristas;
    }
}
