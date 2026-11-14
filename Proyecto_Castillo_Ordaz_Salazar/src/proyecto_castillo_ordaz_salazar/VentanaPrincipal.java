/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 *
 * @author ameli
 */
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VentanaPrincipal extends JFrame {
    private Grafo grafo = new Grafo();
    private final GestorCSV gestor = new GestorCSV();
    private final PanelGrafo panel = new PanelGrafo(); 
    private String[] rutaActual = new String[0];

    public VentanaPrincipal() {
        super("UrbanRoute - Red de Transporte Multimodal");
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override public void windowClosing(java.awt.event.WindowEvent e) { salir(); }
        });
        setLocationRelativeTo(null);
        panelContenedorGrafo.add(panel, BorderLayout.CENTER);
        log("Bienvenido. Use 'Cargar archivo CSV' o edite la red con los botones. Los colores indican subredes; la ruta se resalta en rojo.");
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estado = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        btnCargar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregarEstacion = new javax.swing.JButton();
        btnAgregarConexion = new javax.swing.JButton();
        btnEliminarEstacion = new javax.swing.JButton();
        btnEliminarConexion = new javax.swing.JButton();
        btnRuta = new javax.swing.JButton();
        btnSubredes = new javax.swing.JButton();
        btnHubs = new javax.swing.JButton();
        panelContenedorGrafo = new javax.swing.JPanel();
        scrollSalida = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("UrbanRoute - Red de Transporte Multimodal");
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1200, 780));
        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));

        estado.setFont(estado.getFont().deriveFont(estado.getFont().getStyle() | java.awt.Font.BOLD));
        estado.setText(" ");
        estado.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8));
        getContentPane().add(estado, java.awt.BorderLayout.NORTH);

        panelMenu.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));
        panelMenu.setLayout(new java.awt.GridLayout(0, 1, 6, 6));

        btnCargar.setText("Cargar archivo CSV");
        btnCargar.setToolTipText("Carga una red desde un archivo .csv");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        panelMenu.add(btnCargar);

        btnGuardar.setText("Actualizar repositorio");
        btnGuardar.setToolTipText("Guarda en los archivos fuente la red en memoria");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelMenu.add(btnGuardar);

        btnAgregarEstacion.setText("Agregar estación");
        btnAgregarEstacion.setToolTipText("Crea una estación con sus conexiones");
        btnAgregarEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstacionActionPerformed(evt);
            }
        });
        panelMenu.add(btnAgregarEstacion);

        btnAgregarConexion.setText("Agregar conexión");
        btnAgregarConexion.setToolTipText("Une dos estaciones con un tiempo en minutos");
        btnAgregarConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarConexionActionPerformed(evt);
            }
        });
        panelMenu.add(btnAgregarConexion);

        btnEliminarEstacion.setText("Eliminar estación");
        btnEliminarEstacion.setToolTipText("Simula el cierre de una estación");
        btnEliminarEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEstacionActionPerformed(evt);
            }
        });
        panelMenu.add(btnEliminarEstacion);

        btnEliminarConexion.setText("Eliminar conexión");
        btnEliminarConexion.setToolTipText("Quita el enlace entre dos estaciones");
        btnEliminarConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarConexionActionPerformed(evt);
            }
        });
        panelMenu.add(btnEliminarConexion);

        btnRuta.setText("Ruta de menor tiempo");
        btnRuta.setToolTipText("Dijkstra entre dos estaciones");
        btnRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutaActionPerformed(evt);
            }
        });
        panelMenu.add(btnRuta);

        btnSubredes.setText("Detectar subredes");
        btnSubredes.setToolTipText("Lista las zonas conectadas entre sí (DFS)");
        btnSubredes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubredesActionPerformed(evt);
            }
        });
        panelMenu.add(btnSubredes);

        btnHubs.setText("Hubs de transferencia");
        btnHubs.setToolTipText("Estaciones con más conexiones directas");
        btnHubs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHubsActionPerformed(evt);
            }
        });
        panelMenu.add(btnHubs);

        getContentPane().add(panelMenu, java.awt.BorderLayout.WEST);

        panelContenedorGrafo.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelContenedorGrafo, java.awt.BorderLayout.CENTER);

        scrollSalida.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        salida.setEditable(false);
        salida.setColumns(40);
        salida.setLineWrap(true);
        salida.setRows(9);
        salida.setWrapStyleWord(true);
        scrollSalida.setViewportView(salida);

        getContentPane().add(scrollSalida, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Carga el archivo maestro datos/conexiones.csv al iniciar, si existe. */
    public void cargarPorDefecto() {
        File f = new File("datos/conexiones.csv");
        if (f.exists()) cargarDesde(f);
        else { log("No se encontró el archivo maestro (datos/conexiones.csv). Cárguelo manualmente."); refrescar(); }
    }

    private void log(String s) { salida.append(s + "\n"); salida.setCaretPosition(salida.getDocument().getLength()); }

    private void refrescar() {
        panel.mostrar(grafo, rutaActual);
        int sub = AnalizadorRed.componentes(grafo);
        estado.setText("Estaciones: " + grafo.numVertices() + "   |   Conexiones: " + grafo.numAristas()
            + "   |   Subredes: " + sub + "   |   Cambios sin guardar: " + (gestor.hayCambios() ? "SÍ" : "no"));
    }

    private void cambioRealizado() {
        gestor.marcarModificado();
        rutaActual = new String[0];
        refrescar();
        log("Subredes actuales tras el cambio: " + AnalizadorRed.componentes(grafo));
    }

    private void aviso(String m) { JOptionPane.showMessageDialog(this, m, "Aviso", JOptionPane.WARNING_MESSAGE); }

    private boolean confirmarSobrescritura() {
        if (grafo.numVertices() == 0) return true;
        String m = "Al cargar un nuevo archivo se sobrescribirán los datos en memoria.\n"
            + (gestor.hayCambios() ? "Hay cambios SIN GUARDAR." : "Se recomienda guardar antes de continuar.");
        Object[] op = {"Guardar y cargar", "Cargar sin guardar", "Cancelar"};
        int r = JOptionPane.showOptionDialog(this, m, "Alerta", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, op, op[0]);
        if (r == 0) return guardar();
        return r == 1;
    }

    private void cargarArchivo() {
        if (!confirmarSobrescritura()) return;
        JFileChooser fc = new JFileChooser(new File("."));
        fc.setFileFilter(new FileNameExtensionFilter("Archivos CSV", "csv"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) cargarDesde(fc.getSelectedFile());
    }

    private void cargarDesde(File f) {
        StringBuilder inf = new StringBuilder();
        try {
            grafo = gestor.cargar(f, inf);
            rutaActual = new String[0];
            refrescar();
            log("Archivo cargado: " + f.getName() + " (" + grafo.numVertices() + " estaciones, " + grafo.numAristas() + " conexiones).");
            if (inf.length() > 0) log("Advertencias:\n" + inf);
        } catch (IOException ex) {
            aviso("No se pudo leer el archivo: " + ex.getMessage());
        }
    }

    private boolean guardar() {
        if (gestor.getArchivoConexiones() == null) {
            JFileChooser fc = new JFileChooser(new File("."));
            fc.setSelectedFile(new File("conexiones.csv"));
            if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return false;
            gestor.definirDestino(fc.getSelectedFile());
        }
        try {
            gestor.guardar(grafo);
            log("Repositorio actualizado: " + gestor.getArchivoConexiones().getName());
            refrescar();
            return true;
        } catch (IOException ex) {
            aviso("No se pudo guardar: " + ex.getMessage());
            return false;
        }
    }

    private void salir() {
        if (gestor.hayCambios()) {
            Object[] op = {"Guardar y salir", "Salir sin guardar", "Cancelar"};
            int r = JOptionPane.showOptionDialog(this, "Hay cambios sin guardar.", "Salir", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, op, op[0]);
            if (r == 0 && !guardar()) return;
            if (r != 0 && r != 1) return;
        }
        dispose();
        System.exit(0);
    }

    private String elegirEstacion(String mensaje) {
        String[] ids = grafo.ids();
        if (ids.length == 0) { aviso("No hay estaciones cargadas."); return null; }
        String[] textos = new String[ids.length];
        for (int i = 0; i < ids.length; i++) textos[i] = grafo.buscar(ids[i]).dato.toString();
        JComboBox<String> combo = new JComboBox<>(textos);
        int r = JOptionPane.showConfirmDialog(this, combo, mensaje, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        return r == JOptionPane.OK_OPTION ? ids[combo.getSelectedIndex()] : null;
    }

    private void agregarEstacion() {
        JTextField id = new JTextField(), nombre = new JTextField(), linea = new JTextField(), zona = new JTextField(),
                   cap = new JTextField(), cons = new JTextField();
        cons.setToolTipText("Formato: ID:minutos, ID:minutos  (ej. CAP:3, PET:2)");
        JPanel p = new JPanel(new GridLayout(0, 2, 4, 4));
        p.add(new JLabel("ID (sin espacios):")); p.add(id);
        p.add(new JLabel("Nombre:")); p.add(nombre);
        p.add(new JLabel("Línea:")); p.add(linea);
        p.add(new JLabel("Zona:")); p.add(zona);
        p.add(new JLabel("Capacidad pasajeros/hora:")); p.add(cap);
        p.add(new JLabel("Conexiones (ID:min, ID:min):")); p.add(cons);
        while (true) {
            if (JOptionPane.showConfirmDialog(this, p, "Agregar estación", JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION) return;
            String eid = id.getText().trim().toUpperCase();
            if (!eid.matches("[\\p{L}0-9_]+")) { aviso("El ID es obligatorio y solo admite letras, números y '_'."); continue; }
            if ((grafo.buscar(eid) != null)) { aviso("Ya existe una estación con el ID " + eid + "."); continue; }
            if (nombre.getText().trim().isEmpty() || nombre.getText().contains(",")) { aviso("El nombre es obligatorio y no puede contener comas."); continue; }
            int c = 0;
            try { if (!cap.getText().trim().isEmpty()) c = Integer.parseInt(cap.getText().trim()); if (c < 0) throw new NumberFormatException(); }
            catch (NumberFormatException ex) { aviso("La capacidad debe ser un entero no negativo."); continue; }
            String[] partes = cons.getText().trim().isEmpty() ? new String[0] : cons.getText().split(",");
            String[] dest = new String[partes.length]; int[] tiempos = new int[partes.length];
            boolean ok = true;
            for (int i = 0; i < partes.length && ok; i++) {
                String[] kv = partes[i].trim().split(":");
                try {
                    if (kv.length != 2) throw new NumberFormatException();
                    dest[i] = kv[0].trim().toUpperCase(); tiempos[i] = Integer.parseInt(kv[1].trim());
                    if (tiempos[i] <= 0) throw new NumberFormatException();
                } catch (NumberFormatException ex) { aviso("Conexión inválida: '" + partes[i].trim() + "'. Use ID:minutos con minutos > 0."); ok = false; continue; }
                if (!(grafo.buscar(dest[i]) != null)) { aviso("La estación " + dest[i] + " no existe."); ok = false; }
            }
            if (!ok) continue;
            grafo.insertar(new Estacion(eid, nombre.getText().trim(), linea.getText().trim().isEmpty() ? "Sin línea" : linea.getText().trim(),
                zona.getText().trim().isEmpty() ? "Sin zona" : zona.getText().trim(), c));
            for (int i = 0; i < dest.length; i++) grafo.insertar_arista(eid, dest[i], tiempos[i]);
            log("Estación agregada: " + eid + " con " + dest.length + " conexión(es).");
            cambioRealizado();
            return;
        }
    }

    private void agregarConexion() {
        String a = elegirEstacion("Estación A"); if (a == null) return;
        String b = elegirEstacion("Estación B"); if (b == null) return;
        if (a.equals(b)) { aviso("Debe elegir dos estaciones distintas."); return; }
        String t = JOptionPane.showInputDialog(this, "Tiempo de traslado en minutos:", "Agregar conexión", JOptionPane.QUESTION_MESSAGE);
        if (t == null) return;
        try {
            int min = Integer.parseInt(t.trim());
            if (min <= 0) throw new NumberFormatException();
            grafo.insertar_arista(a, b, min);
            log("Conexión " + a + " <-> " + b + " (" + min + " min) registrada.");
            cambioRealizado();
        } catch (NumberFormatException ex) { aviso("El tiempo debe ser un entero positivo."); }
    }

    private void eliminarEstacion() {
        String id = elegirEstacion("Estación a cerrar/eliminar"); if (id == null) return;
        if (JOptionPane.showConfirmDialog(this, "¿Eliminar " + grafo.buscar(id).dato + " y todas sus conexiones?", "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) return;
        grafo.eliminar(id);
        log("Estación eliminada: " + id);
        cambioRealizado();
    }

    private void eliminarConexion() {
        String a = elegirEstacion("Estación A"); if (a == null) return;
        String b = elegirEstacion("Estación B"); if (b == null) return;
        if (!grafo.eliminar_arista(a, b)) { aviso("No existe una conexión directa entre " + a + " y " + b + "."); return; }
        log("Conexión eliminada: " + a + " <-> " + b);
        cambioRealizado();
    }

    private void mostrarRuta() {
        String a = elegirEstacion("Estación de origen"); if (a == null) return;
        String b = elegirEstacion("Estación de destino"); if (b == null) return;
        if (a.equals(b)) { aviso("El origen y el destino son la misma estación."); return; }
        Ruta r = AnalizadorRutas.rutaMasCorta(grafo, a, b);
        if (!r.existe) {
            rutaActual = new String[0]; refrescar();
            log("No existe camino entre " + a + " y " + b + " (están en subredes distintas).");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.estaciones.length; i++) {
            if (i > 0) sb.append(" -> ");
            sb.append(grafo.buscar(r.estaciones[i]).dato.nombre);
        }
        rutaActual = r.estaciones;
        refrescar();
        log("Ruta óptima (" + r.tiempo + " min, " + rutaActual.length + " estaciones): " + sb);
    }

    private void mostrarSubredes() {
        int cantidad = AnalizadorRed.componentes(grafo);
        if (cantidad == 0) { aviso("No hay estaciones cargadas."); return; }
        log("Subredes detectadas: " + cantidad);
        for (int i = 1; i <= cantidad; i++) {
            String lista = "";
            int total = 0;
            for (Vertice v = grafo.primero; v != null; v = v.siguiente) {
                if (v.componente == i) { lista += (total > 0 ? ", " : "") + v.dato.id; total++; }
            }
            log("  Subred " + i + " [" + PanelGrafo.NOMBRES[(i - 1) % PanelGrafo.NOMBRES.length] + "] - " + total + " estaciones: " + lista);
        }
    }

    private void mostrarHubs() {
        String[] orden = AnalizadorRed.hubs(grafo);
        if (orden.length == 0) { aviso("No hay estaciones cargadas."); return; }
        int max = grafo.grado(orden[0]);
        log("Hubs de transferencia (grado máximo = " + max + "):");
        for (int i = 0; i < orden.length && i < 5; i++)
            log("  " + (i + 1) + ". " + grafo.buscar(orden[i]).dato + " - " + grafo.grado(orden[i]) + " conexiones" + (grafo.grado(orden[i]) == max ? "  <- HUB" : ""));
    }

    // Eventos de los botones (asociados en initComponents).

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {
        cargarArchivo();
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        guardar();
    }

    private void btnAgregarEstacionActionPerformed(java.awt.event.ActionEvent evt) {
        agregarEstacion();
    }

    private void btnAgregarConexionActionPerformed(java.awt.event.ActionEvent evt) {
        agregarConexion();
    }

    private void btnEliminarEstacionActionPerformed(java.awt.event.ActionEvent evt) {
        eliminarEstacion();
    }

    private void btnEliminarConexionActionPerformed(java.awt.event.ActionEvent evt) {
        eliminarConexion();
    }

    private void btnRutaActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarRuta();
    }

    private void btnSubredesActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarSubredes();
    }

    private void btnHubsActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarHubs();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarConexion;
    private javax.swing.JButton btnAgregarEstacion;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEliminarConexion;
    private javax.swing.JButton btnEliminarEstacion;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHubs;
    private javax.swing.JButton btnRuta;
    private javax.swing.JButton btnSubredes;
    private javax.swing.JLabel estado;
    private javax.swing.JPanel panelContenedorGrafo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTextArea salida;
    private javax.swing.JScrollPane scrollSalida;
    // End of variables declaration//GEN-END:variables
}
