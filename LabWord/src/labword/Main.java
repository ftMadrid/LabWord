package labword;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;

public class Main extends JFrame {

    private JTextPane textPane;
    private JComboBox<String> fuentes;
    private JComboBox<Integer> tamanos;

    public Main() {
        setTitle("Editor de Texto");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        textPane = new JTextPane();
        JScrollPane scroll = new JScrollPane(textPane);
        
        Funciones funciones = new Funciones(textPane);

        // Barra de herramientas
        JToolBar toolBar = new JToolBar();

        // Fuentes
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fuentesDisponibles = ge.getAvailableFontFamilyNames();
        fuentes = new JComboBox<>(fuentesDisponibles);
        fuentes.addActionListener(e -> funciones.cambiarFuente((String) fuentes.getSelectedItem()));
        toolBar.add(fuentes);

        // Tamaños
        Integer[] sizes = {12, 14, 16, 18, 24, 32, 48, 64};
        tamanos = new JComboBox<>(sizes);
        tamanos.setSelectedItem(16);
        tamanos.addActionListener(e -> funciones.cambiarTamano((Integer) tamanos.getSelectedItem()));
        toolBar.add(tamanos);

        // Colores
        JButton btnColor = new JButton("Color");
        btnColor.addActionListener(e -> {
            Color c = JColorChooser.showDialog(this, "Seleccione un color", Color.BLACK);
            funciones.cambiarColor(c);
        });
        toolBar.add(btnColor);

        // Estilos
        JButton btnBold = new JButton("B");
        btnBold.setFont(new Font("Arial", Font.BOLD, 12));
        btnBold.addActionListener(e -> funciones.aplicarEstilo(StyleConstants.Bold));
        toolBar.add(btnBold);

        JButton btnItalic = new JButton("I");
        btnItalic.setFont(new Font("Arial", Font.ITALIC, 12));
        btnItalic.addActionListener(e -> funciones.aplicarEstilo(StyleConstants.Italic));
        toolBar.add(btnItalic);

        JButton btnUnderline = new JButton("U");
        btnUnderline.addActionListener(e -> funciones.aplicarEstilo(StyleConstants.Underline));
        toolBar.add(btnUnderline);

        // Menú guardar/abrir
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem guardar = new JMenuItem("Guardar Documento");
        JMenuItem abrir = new JMenuItem("Abrir Documento");

        guardar.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                funciones.guardarArchivo(new File(chooser.getSelectedFile().getAbsolutePath() + ".docx"));
            }
        });
        
        abrir.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                funciones.abrirArchivo(chooser.getSelectedFile());
            }
        });
        
        menuArchivo.add(guardar);
        menuArchivo.add(abrir);
        menuBar.add(menuArchivo);

        setJMenuBar(menuBar);

        add(toolBar, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        new Main().setVisible(true);

    }

}
