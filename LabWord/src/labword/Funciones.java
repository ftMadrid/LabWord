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

    public void aplicarEstilo(Object estilo) {//Es lo de styleconstants
        MutableAttributeSet attrs = new SimpleAttributeSet();
        if (estilo == StyleConstants.Bold) {
            StyleConstants.setBold(attrs, true);
        } else if (estilo == StyleConstants.Italic) {
            StyleConstants.setItalic(attrs, true);
        } else if (estilo == StyleConstants.Underline) {
            StyleConstants.setUnderline(attrs, true);
        }
        textPane.setCharacterAttributes(attrs, false);
        
    }

    public void guardarArchivo(File file) {//Pedir file si o si
        try (FileOutputStream fos = new FileOutputStream(file)) {
            new RTFEditorKit().write(fos, textPane.getDocument(), 0, textPane.getDocument().getLength());
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (Exception ex) {
            System.out.println("Error ");
        }
    }

    public void abrirArchivo(File file) {//Pedir file
        try (FileInputStream fis = new FileInputStream(file)) {
            textPane.setDocument(new DefaultStyledDocument());
            new RTFEditorKit().read(fis, textPane.getDocument(), 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}