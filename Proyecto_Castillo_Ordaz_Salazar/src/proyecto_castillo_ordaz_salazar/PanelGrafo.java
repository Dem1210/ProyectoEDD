/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_castillo_ordaz_salazar;

/**
 *
 * @author ameli
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/** Panel que dibuja la red: nodos en círculo, un color por subred y la ruta en rojo. */
/**
 * Componente Swing encargado de dibujar la red de transporte, distinguir componentes, resaltar rutas y permitir mover vértices con el ratón.
 
 */
public class PanelGrafo extends JPanel {
    private static final Color[] COLORES = {
        new Color(79, 157, 222), new Color(107, 191, 89), new Color(232, 163, 61), new Color(176, 112, 214),
        new Color(60, 191, 174), new Color(217, 98, 125), new Color(140, 140, 140), new Color(201, 176, 55)};
    /** Nombres de los colores, en el mismo orden. */
    public static final String[] NOMBRES = {"azul", "verde", "naranja", "morado", "turquesa", "rosa", "gris", "mostaza"};
    private static final int MARGEN = 40;

    private Grafo grafo;
    private String[] ruta = new String[0];
    private Vertice arrastrado;

    /** Crea el panel y activa el arrastre de nodos con el ratón. */
/**
 * Inicializa el panel de dibujo y registra los eventos del ratón para permitir mover los vértices.
 */
    public PanelGrafo() {
        setBackground(Color.WHITE);
        MouseAdapter raton = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                arrastrado = nodoEn(e.getX(), e.getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (arrastrado != null) {
                    arrastrado.x = (e.getX() - MARGEN) / (double) (getWidth() - 2 * MARGEN);
                    arrastrado.y = (e.getY() - MARGEN) / (double) (getHeight() - 2 * MARGEN);
                    repaint();
                }
            }
        };
        addMouseListener(raton);
        addMouseMotionListener(raton);
    }

    /** Redibuja la red; los ids de la ruta (si hay) se resaltan en rojo. */
/**
 * Asocia el grafo al panel, recalcula los componentes y dispone inicialmente los vértices en forma circular.
 * @param g grafo que se representará.
 * @param ruta identificadores de las estaciones que se resaltarán como recorrido.
 */
    public void mostrar(Grafo g, String[] ruta) {
        this.grafo = g;
        this.ruta = ruta;
        AnalizadorRed.componentes(g);
        int n = g.numVertices();
        int i = 0;
        for (Vertice v = g.primero; v != null; v = v.siguiente) {
            v.x = 0.5 + 0.45 * Math.cos(2 * Math.PI * i / n);
            v.y = 0.5 + 0.45 * Math.sin(2 * Math.PI * i / n);
            i++;
        }
        repaint();
    }

    private int px(Vertice v) {
        return MARGEN + (int) (v.x * (getWidth() - 2 * MARGEN));
    }

    private int py(Vertice v) {
        return MARGEN + (int) (v.y * (getHeight() - 2 * MARGEN));
    }

    private int radio(Vertice v) {
        return 7 + 2 * Math.min(v.lista.tamano, 6);
    }

    private Vertice nodoEn(int mx, int my) {
        if (grafo == null) {
            return null;
        }
        for (Vertice v = grafo.primero; v != null; v = v.siguiente) {
            int dx = mx - px(v);
            int dy = my - py(v);
            if (dx * dx + dy * dy <= radio(v) * radio(v)) {
                return v;
            }
        }
        return null;
    }

    private boolean enRuta(String id) {
        for (int i = 0; i < ruta.length; i++) {
            if (ruta[i].equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean aristaEnRuta(String a, String b) {
        for (int i = 0; i < ruta.length - 1; i++) {
            if ((ruta[i].equals(a) && ruta[i + 1].equals(b)) || (ruta[i].equals(b) && ruta[i + 1].equals(a))) {
                return true;
            }
        }
        return false;
    }

/**
 * Pinta las aristas, estaciones, etiquetas y el resaltado de la ruta sobre el panel.
 * @param g0 contexto gráfico proporcionado por Swing.
 */
    @Override
    protected void paintComponent(Graphics g0) {
        super.paintComponent(g0);
        Graphics2D g = (Graphics2D) g0;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (grafo == null || grafo.numVertices() == 0) {
            g.setColor(Color.GRAY);
            g.drawString("No hay red cargada.", 20, 30);
            return;
        }
        for (Vertice v = grafo.primero; v != null; v = v.siguiente) {
            for (Nodo_Adyacencia n = v.lista.primero; n != null; n = n.siguiente) {
                Vertice w = grafo.buscar(n.dato.id);
                if (v.dato.id.compareTo(w.dato.id) >= 0) {
                    continue;
                }
                boolean roja = aristaEnRuta(v.dato.id, w.dato.id);
                g.setColor(roja ? Color.RED : Color.LIGHT_GRAY);
                g.setStroke(new BasicStroke(roja ? 4f : 1.5f));
                g.drawLine(px(v), py(v), px(w), py(w));
                g.setColor(roja ? Color.RED : Color.GRAY);
                g.drawString("" + n.tiempo, (px(v) + px(w)) / 2, (py(v) + py(w)) / 2);
            }
        }
        g.setStroke(new BasicStroke(1.5f));
        FontMetrics fm = g.getFontMetrics();
        for (Vertice v = grafo.primero; v != null; v = v.siguiente) {
            int r = radio(v);
            g.setColor(enRuta(v.dato.id) ? Color.RED : COLORES[(v.componente - 1) % COLORES.length]);
            g.fillOval(px(v) - r, py(v) - r, 2 * r, 2 * r);
            g.setColor(Color.DARK_GRAY);
            g.drawOval(px(v) - r, py(v) - r, 2 * r, 2 * r);
            g.drawString(v.dato.id, px(v) - fm.stringWidth(v.dato.id) / 2, py(v) - r - 3);
        }
        g.setColor(Color.GRAY);
        g.drawString("Color = subred | Tamaño = nº de conexiones | Rojo = ruta | Puede arrastrar los nodos", 10, getHeight() - 8);
    }
}
