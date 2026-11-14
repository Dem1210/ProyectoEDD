/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

import javax.swing.SwingUtilities;

/**
 * Punto de entrada de UrbanRoute. Inicializa la interfaz gráfica principal en el hilo de eventos de Swing.
 * @author ydccm
 */
public class Proyecto_Castillo_Ordaz_Salazar {

/**
 * Inicia la aplicación y crea la ventana principal en el hilo de eventos de Swing.
 * @param args argumentos recibidos al ejecutar el programa; no se utilizan.
 */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal v = new VentanaPrincipal();
            v.setVisible(true);
            v.cargarPorDefecto();
        });
    }

}
