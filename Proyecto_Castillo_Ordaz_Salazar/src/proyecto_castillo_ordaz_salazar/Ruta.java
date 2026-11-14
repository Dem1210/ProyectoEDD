/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 *Resultado de buscar la ruta de menor tiempo.
 * @author ameli
 */

public class Ruta {
    String[] estaciones;
    int tiempo;
    boolean existe;

    /** Crea una ruta con los ids del recorrido, el tiempo total y si existe camino. */
    public Ruta(String[] estaciones, int tiempo, boolean existe) {
        this.estaciones = estaciones;
        this.tiempo = tiempo;
        this.existe = existe;
    }
}
