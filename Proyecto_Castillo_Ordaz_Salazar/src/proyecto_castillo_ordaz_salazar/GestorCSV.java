/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Lee y guarda los archivos CSV: conexiones.csv (origen, destino, minutos)
 * y estaciones.csv (datos de cada estación, en la misma carpeta).
 * 
 * @author ameli
 */
public class GestorCSV {
    private File archivoConexiones;
    private File archivoEstaciones;
    private boolean modificado;

    /** Indica si hay cambios sin guardar. */
    public boolean hayCambios() {
        return modificado;
    }

    /** Marca que la red en memoria cambió. */
    public void marcarModificado() {
        modificado = true;
    }

    /** Devuelve el archivo de conexiones cargado (null si no hay). */
    public File getArchivoConexiones() {
        return archivoConexiones;
    }

    /** Define el archivo donde se guardará; estaciones.csv queda en la misma carpeta. */
    public void definirDestino(File conexiones) {
        archivoConexiones = conexiones;
        archivoEstaciones = new File(conexiones.getAbsoluteFile().getParentFile(), "estaciones.csv");
    }

    /** Carga la red desde el CSV. Las líneas inválidas se ignoran y se anotan en el informe. */
    public Grafo cargar(File f, StringBuilder informe) throws IOException {
        File carpeta = f.getAbsoluteFile().getParentFile();
        File est = new File(carpeta, "estaciones.csv");
        File con = f;
        if (f.getName().equalsIgnoreCase("estaciones.csv")) {
            con = new File(carpeta, "conexiones.csv");
        }
        Grafo g = new Grafo();
        if (est.exists()) {
            leerEstaciones(est, g, informe);
        }
        if (con.exists()) {
            leerConexiones(con, g, informe);
        }
        archivoConexiones = con;
        archivoEstaciones = est;
        modificado = false;
        return g;
    }

    /** Guarda la red en memoria en los archivos CSV. */
    public void guardar(Grafo g) throws IOException {
        if (archivoConexiones == null) {
            throw new IOException("No hay archivo destino definido.");
        }
        PrintWriter w = escritor(archivoEstaciones);
        w.println("ID_Estacion,Nombre,Linea,Zona,Capacidad_Pasajeros_Hora");
        for (Vertice v = g.primero; v != null; v = v.siguiente) {
            Estacion e = v.dato;
            w.println(e.id + "," + e.nombre + "," + e.linea + "," + e.zona + "," + e.cap_pasajeros_hora);
        }
        w.close();

        w = escritor(archivoConexiones);
        w.println("Estacion_Origen,Estacion_Destino,Tiempo_Minutos");
        for (Vertice v = g.primero; v != null; v = v.siguiente) {
            for (Nodo_Adyacencia n = v.lista.primero; n != null; n = n.siguiente) {
                if (v.dato.id.compareTo(n.dato.id) < 0) {
                    w.println(v.dato.id + "," + n.dato.id + "," + n.tiempo);
                }
            }
        }
        w.close();
        modificado = false;
    }

    private void leerEstaciones(File f, Grafo g, StringBuilder informe) throws IOException {
        BufferedReader br = lector(f);
        String linea;
        int numero = 0;
        while ((linea = br.readLine()) != null) {
            numero++;
            linea = linea.replace("\uFEFF", "").trim();
            if (linea.isEmpty() || linea.toLowerCase().contains("id_estacion")) {
                continue;
            }
            String[] p = linea.split(",");
            if (p.length < 5 || p[0].trim().isEmpty()) {
                informe.append("estaciones.csv línea " + numero + ": formato inválido, ignorada\n");
                continue;
            }
            int cap = 0;
            try {
                cap = Integer.parseInt(p[4].trim());
            } catch (NumberFormatException e) {
                informe.append("estaciones.csv línea " + numero + ": capacidad no numérica, se usa 0\n");
            }
            if (!g.insertar(new Estacion(p[0].trim().toUpperCase(), p[1].trim(), p[2].trim(), p[3].trim(), cap))) {
                informe.append("estaciones.csv línea " + numero + ": id repetido, ignorada\n");
            }
        }
        br.close();
    }

    private void leerConexiones(File f, Grafo g, StringBuilder informe) throws IOException {
        BufferedReader br = lector(f);
        String linea;
        int numero = 0;
        while ((linea = br.readLine()) != null) {
            numero++;
            linea = linea.replace("\uFEFF", "").trim();
            if (linea.isEmpty() || linea.toLowerCase().contains("origen")) {
                continue;
            }
            String[] p = linea.split(",");
            int tiempo = -1;
            if (p.length >= 3) {
                try {
                    tiempo = Integer.parseInt(p[2].trim());
                } catch (NumberFormatException e) {
                    tiempo = -1;
                }
            }
            String a = p.length >= 2 ? p[0].trim().toUpperCase() : "";
            String b = p.length >= 2 ? p[1].trim().toUpperCase() : "";
            if (a.isEmpty() || b.isEmpty() || a.equals(b) || tiempo <= 0) {
                informe.append("conexiones.csv línea " + numero + ": datos inválidos, ignorada\n");
                continue;
            }
            crearSiFalta(g, a, informe);
            crearSiFalta(g, b, informe);
            g.insertar_arista(a, b, tiempo);
        }
        br.close();
    }

    private void crearSiFalta(Grafo g, String id, StringBuilder informe) {
        if (g.buscar(id) == null) {
            g.insertar(new Estacion(id, id, "Sin línea", "Sin zona", 0));
            informe.append("Estación " + id + " no estaba en estaciones.csv: creada con datos por defecto\n");
        }
    }

    private BufferedReader lector(File f) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
    }

    private PrintWriter escritor(File f) throws IOException {
        return new PrintWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
    }
}
