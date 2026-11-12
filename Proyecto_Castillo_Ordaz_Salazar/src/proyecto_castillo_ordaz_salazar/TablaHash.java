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
    private static final double FACTOR_CARGA_MAX = 0.75;

    private static class Nodo<V> {
        final String clave; V valor; Nodo<V> sig;
        Nodo(String clave, V valor, Nodo<V> sig) { this.clave = clave; this.valor = valor; this.sig = sig; }
    }

    private Nodo<V>[] cubetas;
    private int tamano;


    @SuppressWarnings("unchecked")
    public TablaHash(int capacidadInicial) {
        cubetas = (Nodo<V>[]) new Nodo[Math.max(11, capacidadInicial)];
    }


    private int indice(String clave, int largo) {
        int h = 0;
        for (int i = 0; i < clave.length(); i++) h = 31 * h + clave.charAt(i);
        return (h & 0x7fffffff) % largo;
    }

  
    public void poner(String clave, V valor) {
        int i = indice(clave, cubetas.length);
        for (Nodo<V> n = cubetas[i]; n != null; n = n.sig) {
            if (n.clave.equals(clave)) { n.valor = valor; return; }
        }
        cubetas[i] = new Nodo<>(clave, valor, cubetas[i]);
        tamano++;
        if (tamano > cubetas.length * FACTOR_CARGA_MAX) rehash();
    }


    public V obtener(String clave) {
        for (Nodo<V> n = cubetas[indice(clave, cubetas.length)]; n != null; n = n.sig) {
            if (n.clave.equals(clave)) return n.valor;
        }
        return null;
    }


    public boolean contiene(String clave) {
        for (Nodo<V> n = cubetas[indice(clave, cubetas.length)]; n != null; n = n.sig) {
            if (n.clave.equals(clave)) return true;
        }
        return false;
    }


    public boolean eliminar(String clave) {
        int i = indice(clave, cubetas.length);
        Nodo<V> previo = null;
        for (Nodo<V> n = cubetas[i]; n != null; previo = n, n = n.sig) {
            if (n.clave.equals(clave)) {
                if (previo == null) cubetas[i] = n.sig; else previo.sig = n.sig;
                tamano--;
                return true;
            }
        }
        return false;
    }


    public int tamano() { return tamano; }

  
    public String[] claves() {
        String[] res = new String[tamano];
        int k = 0;
        for (int i = 0; i < cubetas.length; i++)
            for (Nodo<V> n = cubetas[i]; n != null; n = n.sig) res[k++] = n.clave;
        return res;
    }


    @SuppressWarnings("unchecked")
    private void rehash() {
        Nodo<V>[] viejas = cubetas;
        cubetas = (Nodo<V>[]) new Nodo[viejas.length * 2 + 1];
        for (int i = 0; i < viejas.length; i++) {
            Nodo<V> n = viejas[i];
            while (n != null) {
                Nodo<V> sig = n.sig;
                int j = indice(n.clave, cubetas.length);
                n.sig = cubetas[j];
                cubetas[j] = n;
                n = sig;
            }
        }
    }
}
