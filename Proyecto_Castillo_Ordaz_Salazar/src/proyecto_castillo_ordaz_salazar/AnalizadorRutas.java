/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 *
 * @author ameli
 */
/** Algoritmo de Dijkstra para la ruta de menor tiempo. */
/**
 * Calcula rutas de menor tiempo entre estaciones mediante el algoritmo de Dijkstra. Los pesos de las aristas representan tiempos de traslado.
 */
public class AnalizadorRutas {
    private static final int INFINITO = Integer.MAX_VALUE;

    /** Calcula la ruta de menor tiempo entre dos estaciones que existen en el grafo. */
/**
 * Calcula mediante Dijkstra el recorrido de menor tiempo entre dos estaciones. Reinicia los datos auxiliares de los vértices antes del cálculo.
 * @param g grafo donde se buscará el recorrido.
 * @param origen identificador de la estación de partida.
 * @param destino identificador de la estación de llegada.
 * @return ruta encontrada y tiempo total; si no hay camino, devuelve una Ruta con existe igual a false.
 */
    public static Ruta rutaMasCorta(Grafo g, String origen, String destino) {
        for (Vertice v = g.primero; v != null; v = v.siguiente) {
            v.distancia = INFINITO;
            v.anterior = null;
            v.visitado = false;
        }
        Vertice ini = g.buscar(origen);
        Vertice fin = g.buscar(destino);
        ini.distancia = 0;

        while (true) {
            Vertice u = null;
            for (Vertice v = g.primero; v != null; v = v.siguiente) {
                if (!v.visitado && v.distancia != INFINITO && (u == null || v.distancia < u.distancia)) {
                    u = v;
                }
            }
            if (u == null || u == fin) {
                break;
            }
            u.visitado = true;
            for (Nodo_Adyacencia n = u.lista.primero; n != null; n = n.siguiente) {
                Vertice vecino = g.buscar(n.dato.id);
                int nueva = u.distancia + n.tiempo;
                if (nueva < vecino.distancia) {
                    vecino.distancia = nueva;
                    vecino.anterior = u;
                }
            }
        }

        if (fin.distancia == INFINITO) {
            return new Ruta(new String[0], 0, false);
        }
        int cantidad = 0;
        for (Vertice v = fin; v != null; v = v.anterior) {
            cantidad++;
        }
        String[] camino = new String[cantidad];
        for (Vertice v = fin; v != null; v = v.anterior) {
            camino[--cantidad] = v.dato.id;
        }
        return new Ruta(camino, fin.distancia, true);
    }
}
