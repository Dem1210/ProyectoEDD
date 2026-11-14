/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;


/**
 * Implementación propia de una tabla hash genérica con encadenamiento separado para resolver colisiones. No utiliza Java Collections Framework.
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
/**
 * Crea una tabla hash con la capacidad indicada y encadenamiento separado para resolver colisiones.
 * @param capacidad cantidad de cubetas de la tabla; debe ser mayor que cero.
 */
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
/**
 * Inserta una asociación clave-valor. Si la clave ya existe, reemplaza el valor almacenado.
 * @param clave identificador textual de la entrada.
 * @param valor objeto asociado a la clave.
 */
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
/**
 * Busca una clave y devuelve el valor asociado.
 * @param clave identificador que se desea consultar.
 * @return valor asociado o null si la clave no está almacenada.
 */
    public V obtener(String clave) {
        for (Nodo<V> n = tabla[indice(clave)]; n != null; n = n.siguiente) {
            if (n.clave.equals(clave)) {
                return n.valor;
            }
        }
        return null;
    }

    /** Elimina la clave de la tabla. */
/**
 * Elimina la asociación correspondiente a la clave indicada, si existe.
 * @param clave identificador de la entrada que se eliminará.
 */
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
