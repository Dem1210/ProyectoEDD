/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 *
 * @author ameli
 */
public class TablaHash {

    Vertice[] tablahash;
    int capacidad;
    int total_estaciones;

    public TablaHash(int capacidad) {
        tablahash = new Vertice[capacidad];
        this.capacidad = capacidad;
        this.total_estaciones = 0;
    }

    public int hash(String id) {
        int dx = 0;

        for (int i = 0; i < id.length(); i++) {
            dx += id.charAt(i) + dx * 31;
        }

        if (dx < 0) {
            dx -= 2 * dx;
        }
        return dx % capacidad;
    }
    
    public void insertar (Vertice v) {
        int indice = hash(v.dato.id);
        Vertice aux = tablahash[indice];
        
        if (aux == null) {
            tablahash[indice] = v;
        }
        else {
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            
            aux.siguiente = v;
        }
        total_estaciones ++;
        
        if (total_estaciones == capacidad) {
            this.redimensionar();
        }
        
    }
    
    public void eliminar (String id) {
        int indice = hash(id);
        Vertice aux = tablahash[indice];
        
        if (aux == null) {
            return;
        }
        
        if (aux.dato.id.equals(id)) {
            tablahash[indice] = aux.siguiente;
            total_estaciones --;
            return;
        }
        
        while (aux.siguiente != null) {
            if (aux.siguiente.dato.id.equals(id)){
                aux.siguiente = aux.siguiente.siguiente;
                total_estaciones --;
            }
            aux = aux.siguiente;
        }
        
    }
    
    public Vertice buscar (String id) {
        int indice = hash(id);
        Vertice aux = tablahash[indice];
        
        while (aux != null) {
            if (aux.dato.id.equals(id)){
                return aux;
            }
            aux = aux.siguiente;
        }
        return null;
    }
    
    public void redimensionar() {
        Vertice [] arregloviejo = tablahash;
        
        tablahash = new Vertice [capacidad * 2];
        capacidad = capacidad * 2;
        total_estaciones = 0;
        
        for (Vertice aux : arregloviejo) {
            while (aux != null) {
                this.insertar(aux);
                aux = aux.siguiente;
                
            }
        }
    }
}
