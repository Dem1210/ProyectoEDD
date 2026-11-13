package proyecto_castillo_ordaz_salazar;

/**
 * Vértice del grafo: una estación con su lista de conexiones.
 * Los campos finales los usan los algoritmos y el dibujo.
 *
 * @author ydccm
 */
public class Vertice {

    Vertice siguiente;
    Estacion dato;
    Lista_Adyacencia lista;

    int distancia;
    Vertice anterior;
    boolean visitado;
    int componente;
    double x;
    double y;

    /** Crea un vértice con su lista de adyacencia vacía. */
    public Vertice(Estacion dato) {
        this.siguiente = null;
        this.dato = dato;
        this.lista = new Lista_Adyacencia();
    }

}
