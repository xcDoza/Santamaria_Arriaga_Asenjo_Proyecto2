/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Clases.NodoTree;
import Clases.Tree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class Interfaz1 extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz1
     */
    private Tree houseTree;

    public Interfaz1() {
        initComponents();
        houseTree = new Tree();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCargarArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        btnCargarArchivo.setText("Cargar Archivo");
        btnCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarArchivoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String filePath = archivoSeleccionado.getAbsolutePath();

            // Verificar si el archivo es .json
            if (filePath.endsWith(".json")) {
                try {
                    String contenidoJson = leerArchivoJson(filePath);
                    parsearJson(contenidoJson);

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un archivo .json", "Archivo inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCargarArchivoActionPerformed

    private void parsearJson(String contenidoJson) {
        // Eliminar espacios y saltos de línea para simplificar el análisis
        contenidoJson = contenidoJson.replaceAll("\\s+", "");

        // Verificar si el JSON empieza con { y termina con }
        if (contenidoJson.startsWith("{") && contenidoJson.endsWith("}")) {
            contenidoJson = contenidoJson.substring(1, contenidoJson.length() - 1); // Eliminar { y }

            // Separar las casas en el JSON (usando el delimitador de "],{")
            String[] casasArray = contenidoJson.split("],\\{");

            for (String casa : casasArray) {
                // Limpiar la cadena de caracteres no deseados y obtener el nombre de la casa
                int indiceDosPuntos = casa.indexOf(":[");
                if (indiceDosPuntos == -1) {
                    continue; // Si no hay un delimitador correcto, continuar con la siguiente
                }
                String nombreCasa = casa.substring(0, indiceDosPuntos).replaceAll("[{}\"]", "");
                System.out.println("Procesando casa: " + nombreCasa);

                // Insertar la casa en el árbol
                NodoTree casaNodo = houseTree.insert(nombreCasa, -1, houseTree.getRoot());
                if (casaNodo == null) {
                    System.out.println("Error al insertar la casa en el árbol.");
                    continue;
                } else {
                    System.out.println("Casa insertada: " + nombreCasa);
                }

                // Obtener el contenido de los personajes
                String personajesContenido = casa.substring(indiceDosPuntos + 2).replaceAll("\\]$", ""); // Eliminar el último ]

                // Separar los personajes por "},{"
                String[] personajes = personajesContenido.split("\\},\\{");

                for (String personaje : personajes) {
                    // Limpiar las llaves adicionales y comillas
                    personaje = personaje.replaceAll("[{}\"]", "");

                    // Separar el nombre del personaje de sus atributos
                    int indexAtributos = personaje.indexOf(":[");
                    if (indexAtributos == -1) {
                        continue; // Si no hay atributos, continuar con el siguiente personaje
                    }
                    String nombrePersonaje = personaje.substring(0, indexAtributos);
                    System.out.println("Procesando personaje: " + nombrePersonaje);

                    // Insertar el personaje en el árbol
                    NodoTree personajeNodo = houseTree.insert(nombrePersonaje, casaNodo.getKey(), houseTree.getRoot());
                    if (personajeNodo == null) {
                        System.out.println("Error al insertar el personaje en el árbol.");
                        continue;
                    } else {
                        System.out.println("Personaje insertado: " + nombrePersonaje);
                    }

                    // Obtener los atributos y dividirlos por "},{"
                    String atributosContenido = personaje.substring(indexAtributos + 2).replaceAll("\\]$", ""); // Eliminar el último ]
                    String[] atributosArray = atributosContenido.split("\\},\\{");

                    for (String atributo : atributosArray) {
                        // Limpiar las llaves adicionales y comillas, y eliminar cualquier corchete de cierre residual
                        String atributoTexto = atributo.replaceAll("[{}\"\"]", "").replaceAll("\\]$", "");
                        System.out.println("Atributo: " + atributoTexto);

                        // Insertar el atributo en el árbol
                        NodoTree atributoNodo = houseTree.insert(atributoTexto, personajeNodo.getKey(), houseTree.getRoot());
                        if (atributoNodo == null) {
                            System.out.println("Error al insertar el atributo en el árbol.");
                        } else {
                            System.out.println("Atributo insertado: " + atributoTexto);
                        }
                    }
                }
            }
        }

        // Imprimir el árbol para verificar el parseo
        if (houseTree.isEmpty()) {
            System.out.println("El árbol está vacío después de intentar insertar los nodos.");
        } else {
            System.out.println("El árbol tiene nodos correctamente.");
            houseTree.print(houseTree.getRoot());
        }
    }

    private String leerArchivoJson(String filePath) throws IOException {
//  Con este metodo busco transcribir el archivo json de forma tal que pueda utilizar su informacion
        StringBuilder contenidoJson = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
//            se agrega el salto de linea para mantener el formato original del archivo
                contenidoJson.append(linea).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, "Arhivo cargado con éxito");
        return contenidoJson.toString();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarArchivo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}