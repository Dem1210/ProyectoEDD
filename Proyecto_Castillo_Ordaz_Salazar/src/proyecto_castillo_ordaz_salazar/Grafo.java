/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 * Implementa un grafo ponderado no dirigido mediante vértices y listas de adyacencia propias. Utiliza una TablaHash para localizar vértices por identificador.
 * @author ydccm
 */
public class Grafo {

    Vertice primero;
    private Vertice ultimo;
    private TablaHash<Vertice> indice = new TablaHash<>(211);
    private int numVertices;
    private int numAristas;

    /** Crea un grafo vacío. */
/**
 * Crea un grafo vacío e inicializa su índice hash.
 */
    public Grafo() {
        this.primero = null;
    }

    /** Inserta una estación; devuelve false si es nula o ya existe el id. */
/**
 * Agrega una estación como nuevo vértice y la registra en la tabla hash.
 * @param dato estación que se desea insertar.
 * @return true si se insertó; false si es null o ya existe el identificador.
 */
    public boolean insertar(Estacion dato) {
        if (dato == null || buscar(dato.id) != null) {
            return false;
        }
        Vertice nuevo = new Vertice(dato);

        if (primero != null) {
            ultimo.siguiente = nuevo;
        } else {
            primero = nuevo;
        }
        ultimo = nuevo;
        indice.poner(dato.id, nuevo);
        numVertices++;
        return true;
    }

    /** Elimina una estación y todas sus conexiones; devuelve el vértice o null. */
/**
 * Elimina el vértice identificado y todas sus conexiones incidentes, actualizando la lista, los contadores y la tabla hash.
 * @param id identificador de la estación que se eliminará.
 * @return vértice eliminado o null si el identificador no existe.
 */
    public Vertice eliminar(String id) {
        Vertice v = buscar(id);

        if (v == null) {
            return null;
        }
        for (Nodo_Adyacencia n = v.lista.primero; n != null; n = n.siguiente) {
            buscar(n.dato.id).lista.eliminar(id);
            numAristas--;
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
        indice.eliminar(id);
        numVertices--;
        return v;
    }

    /** Busca un vértice por id usando la tabla hash (null si no existe). */
/**
 * Busca un vértice mediante la tabla hash indexada por el identificador de estación.
 * @param id identificador de la estación buscada.
 * @return vértice correspondiente o null si no existe o el identificador es null.
 */
    public Vertice buscar (String id) {
        if (id == null) {
            return null;
        }
        return indice.obtener(id);
    }

    /** Devuelve cada estación con sus vecinos, una por línea. */
/**
 * Construye una representación textual de las estaciones y sus vecinos.
 * @return cadena con una línea por estación y sus conexiones.
 */
    public String imprimir () {
        Vertice aux = primero;
        String h = "";

        while (aux != null) {
           h += aux.dato.id + aux.lista.imprimir2() + "\n";
            aux = aux.siguiente;
        }
        return h;
    }

    /** Conecta dos estaciones (si ya estaban conectadas actualiza el tiempo). Devuelve false si los datos no son válidos. */
/**
 * Crea una conexión no dirigida entre dos estaciones. Si ya existe, actualiza el tiempo en ambos sentidos.
 * @param id1 identificador de la primera estación.
 * @param id2 identificador de la segunda estación.
 * @param tiempo tiempo de traslado en minutos; debe ser positivo.
 * @return true si se creó o actualizó; false si los datos no son válidos.
 */
    public boolean insertar_arista(String id1, String id2, int tiempo) {
        Vertice aux1 = this.buscar(id1);
        Vertice aux2 = this.buscar(id2);

        if (aux1 == null || aux2 == null || aux1 == aux2 || tiempo <= 0) {
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

    /** Elimina la conexión entre dos estaciones; devuelve true si existía. */
/**
 * Elimina la conexión no dirigida entre dos estaciones.
 * @param id1 identificador de la primera estación.
 * @param id2 identificador de la segunda estación.
 * @return true si la conexión existía y fue eliminada; false en caso contrario.
 */
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

    /** Número de conexiones directas de una estación. */
/**
 * Calcula el número de conexiones directas de una estación.
 * @param id identificador de la estación.
 * @return grado del vértice, o cero si no existe.
 */
    public int grado(String id) {
        Vertice v = buscar(id);
        return v == null ? 0 : v.lista.tamano;
    }

    /** Ids de todas las estaciones, en orden de inserción. */
/**
 * Obtiene los identificadores de todas las estaciones en orden de inserción.
 * @return arreglo con los identificadores de los vértices.
 */
    public String[] ids() {
        String[] res = new String[numVertices];
        int i = 0;
        for (Vertice v = primero; v != null; v = v.siguiente) {
            res[i++] = v.dato.id;
        }
        return res;
    }

    /** Cantidad de estaciones. */
/**
 * Obtiene la cantidad actual de estaciones del grafo.
 * @return número de vértices.
 */
    public int numVertices() {
        return numVertices;
    }

    /** Cantidad de conexiones. */
/**
 * Obtiene la cantidad actual de conexiones no dirigidas del grafo.
 * @return número de aristas.
 */
    public int numAristas() {
        return numAristas;
    }
}
