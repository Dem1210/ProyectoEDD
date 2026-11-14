/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 * Analiza la conectividad de la red de transporte mediante recorridos BFS y calcula las estaciones con mayor grado.
 * @author ameli
 */
public class AnalizadorRed {

    /** Marca cada vértice con su número de subred (BFS) y devuelve cuántas subredes hay. */
/**
 * Identifica las componentes relacionadas mediante búsqueda en anchura (BFS) y marca cada vértice con el número de componente al que pertenece.
 * @param g grafo que se desea analizar.
 * @return cantidad de componentes relacionadas encontradas.
 */
    public static int componentes(Grafo g) {
        for (Vertice v = g.primero; v != null; v = v.siguiente) {
            v.visitado = false;
        }
        int cantidad = 0;
        Cola cola = new Cola();

        for (Vertice inicio = g.primero; inicio != null; inicio = inicio.siguiente) {
            if (inicio.visitado) {
                continue;
            }
            cantidad++;
            inicio.visitado = true;
            inicio.componente = cantidad;
            cola.encolar(inicio.dato, 0);

            while (!cola.vacia()) {
                Vertice actual = g.buscar(cola.desencolar().dato.id);
                for (Nodo_Adyacencia n = actual.lista.primero; n != null; n = n.siguiente) {
                    Vertice vecino = g.buscar(n.dato.id);
                    if (!vecino.visitado) {
                        vecino.visitado = true;
                        vecino.componente = cantidad;
                        cola.encolar(vecino.dato, 0);
                    }
                }
            }
        }
        return cantidad;
    }

    /** Devuelve los ids ordenados de mayor a menor número de conexiones. */
/**
 * Obtiene los identificadores de las estaciones ordenados de mayor a menor grado.
 * @param g grafo cuyas estaciones se van a clasificar.
 * @return arreglo de identificadores ordenado por grado descendente.
 */
    public static String[] hubs(Grafo g) {
        String[] ids = g.ids();

        for (int i = 0; i < ids.length - 1; i++) {
            for (int j = 0; j < ids.length - 1 - i; j++) {
                if (g.grado(ids[j]) < g.grado(ids[j + 1])) {
                    String aux = ids[j];
                    ids[j] = ids[j + 1];
                    ids[j + 1] = aux;
                }
            }
        }
        return ids;
    }
}
