package labword;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.rtf.RTFEditorKit;
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

        textPane = new JTextPane();
        JScrollPane scroll = new JScrollPane(textPane);

        // Barra de herramientas
        JToolBar toolBar = new JToolBar();

        // Fuentes
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fuentesDisponibles = ge.getAvailableFontFamilyNames();
        fuentes = new JComboBox<>(fuentesDisponibles);
        //fuentes.addActionListener(e -> cambiarFuente());
        toolBar.add(fuentes);

        // Tamaños
        Integer[] sizes = {12, 14, 16, 18, 24, 32, 48, 64};
        tamanos = new JComboBox<>(sizes);
        tamanos.setSelectedItem(16);
        //tamanos.addActionListener(e -> cambiarTamano());
        toolBar.add(tamanos);

        // Colores
        JButton btnColor = new JButton("Colors");
        //btnColor.addActionListener(e -> cambiarColor());
        toolBar.add(btnColor);

        // Estilos
        JButton btnBold = new JButton("B");
        btnBold.setFont(new Font("Arial", Font.BOLD, 12));
        //btnBold.addActionListener(e -> aplicarEstilo(StyleConstants.Bold));
        toolBar.add(btnBold);

        JButton btnItalic = new JButton("I");
        btnItalic.setFont(new Font("Arial", Font.ITALIC, 12));
        //btnItalic.addActionListener(e -> aplicarEstilo(StyleConstants.Italic));
        toolBar.add(btnItalic);

        JButton btnUnderline = new JButton("U");
        btnUnderline.setFont(new Font("Arial", Font.ITALIC, 12));
        //btnUnderline.addActionListener(e -> aplicarEstilo(StyleConstants.Underline));
        toolBar.add(btnUnderline);

        // Menú guardar/abrir
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");

        JMenuItem guardar = new JMenuItem("Guardar DOCX");
        JMenuItem abrir = new JMenuItem("Abrir DOCX");

        //guardar.addActionListener(e -> guardarArchivo());
        //abrir.addActionListener(e -> abrirArchivo());

        menuArchivo.add(guardar);
        menuArchivo.add(abrir);
        menuBar.add(menuArchivo);

        setJMenuBar(menuBar);

        add(toolBar, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
}
