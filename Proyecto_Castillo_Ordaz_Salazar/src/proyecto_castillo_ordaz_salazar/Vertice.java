package proyecto_castillo_ordaz_salazar;

/**
 * Representa un vértice del grafo asociado a una estación y a su lista de adyacencia. También almacena datos auxiliares usados por los algoritmos y el dibujo.
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
/**
 * Crea un vértice para la estación indicada e inicializa su lista de adyacencia vacía.
 * @param dato estación representada por este vértice.
 */
    public Vertice(Estacion dato) {
        this.siguiente = null;
        this.dato = dato;
        this.lista = new Lista_Adyacencia();
    }

}
