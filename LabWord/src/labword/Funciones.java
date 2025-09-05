package labword;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.*;
import java.io.*;

public class Funciones {

    private JTextPane textPane;

    public Funciones(JTextPane textPane) {
        this.textPane = textPane; //Conseguir el texto de main
    }

    public void cambiarFuente(String fuente) {//La fuente que se usara 
        MutableAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attrs, fuente);
        textPane.setCharacterAttributes(attrs, false);
    }

    public void cambiarTamano(int tamano) {//El tamano que se consigue con el boton ese
        MutableAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs, tamano);
        textPane.setCharacterAttributes(attrs, false);
    }

    public void cambiarColor(Color color) {//Con la libreria esa
        if (color != null) {
            MutableAttributeSet attrs = new SimpleAttributeSet();//Osea que pueda cambiarl os atributos despues
            StyleConstants.setForeground(attrs, color);
            textPane.setCharacterAttributes(attrs, false);
        }
    }

    public void aplicarEstilo() {//Aun no se xd
    }

    public void guardarArchivo(File file) {//MANTENIMIENTO
    }

    public void abrirArchivo(File file) {//MANTENIMIENTO
    }
}