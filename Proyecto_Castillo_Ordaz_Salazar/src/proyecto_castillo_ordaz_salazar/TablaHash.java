/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 *
 * @author ameli
 */

public class TablaHash<V> {

    private static class Nodo<V> {
        String clave;
        V valor;
        Nodo<V> siguiente;

        Nodo(String clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    private Nodo<V>[] tabla;

    /** Crea la tabla con la cantidad de posiciones indicada. */
    @SuppressWarnings("unchecked")
    public TablaHash(int capacidad) {
        tabla = (Nodo<V>[]) new Nodo[capacidad];
    }

    /** Función hash: suma de los caracteres por su posición, módulo el tamaño. */
    private int indice(String clave) {
        int suma = 0;
        for (int i = 0; i < clave.length(); i++) {
            suma += clave.charAt(i) * (i + 1);
        }
        return Math.abs(suma % tabla.length);
    }

    /** Guarda el valor; si la clave ya existe lo reemplaza. */
    public void poner(String clave, V valor) {
        int i = indice(clave);
        for (Nodo<V> n = tabla[i]; n != null; n = n.siguiente) {
            if (n.clave.equals(clave)) {
                n.valor = valor;
                return;
            }
        }
        Nodo<V> nuevo = new Nodo<>(clave, valor);
        nuevo.siguiente = tabla[i];
        tabla[i] = nuevo;
    }

    /** Devuelve el valor de la clave o null si no existe. */
    public V obtener(String clave) {
        for (Nodo<V> n = tabla[indice(clave)]; n != null; n = n.siguiente) {
            if (n.clave.equals(clave)) {
                return n.valor;
            }
        }
        return null;
    }

    /** Elimina la clave de la tabla. */
    public void eliminar(String clave) {
        int i = indice(clave);
        Nodo<V> anterior = null;
        for (Nodo<V> n = tabla[i]; n != null; n = n.siguiente) {
            if (n.clave.equals(clave)) {
                if (anterior == null) {
                    tabla[i] = n.siguiente;
                } else {
                    anterior.siguiente = n.siguiente;
                }
                return;
            }
            anterior = n;
        }
    }
}
