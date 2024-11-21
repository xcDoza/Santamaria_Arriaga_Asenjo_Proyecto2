/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Clases.Lista;
import Clases.Persona;
import Clases.Casa;
import Clases.ListaArray;
import Clases.Map;
import Clases.Nodo;
import Clases.NodoArray;
import Clases.NodoTree;
import Clases.Par;
import proyecto2.HashTableTitles;
import proyecto2.HashTable;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import Clases.Tree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import proyecto2.HashTable;

/**
 *
 * @author sebas
 */
public class Interfaz1 extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz1
     */
    private Tree houseTree;
    private VerRegistro verRegistroFrame;
    private HashTable personaHashTable;

    Lista casas = new Lista();

    public Interfaz1() {
        initComponents();
        setSize(800, 600);
        setLocationRelativeTo(null);
        houseTree = new Tree();
        personaHashTable = new HashTable(); // Inicializa la HashTable
        verRegistroFrame = new VerRegistro();
        verRegistroFrame.setPersonaHashTable(personaHashTable);
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
        VerRegistro = new javax.swing.JButton();

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

        VerRegistro.setText("VerRegistro");
        VerRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(VerRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

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

    private void VerRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerRegistroActionPerformed
        verRegistroFrame.poblarComboBox();
        verRegistroFrame.setVisible(true);
    }//GEN-LAST:event_VerRegistroActionPerformed

    private ListaArray obtenerAtributosUnicos(JsonObject jsonObject) {
        ListaArray atributosUnicos = new ListaArray(100); // Tamaño inicial grande para manejar expansión
        for (String nombreCasa : jsonObject.keySet()) {
            JsonArray personajesArray = jsonObject.getAsJsonArray(nombreCasa);
            for (JsonElement personajeElement : personajesArray) {
                JsonObject personajeObject = personajeElement.getAsJsonObject();
                String nombrePersonaje = personajeObject.keySet().iterator().next();
                JsonArray atributosArray = personajeObject.getAsJsonArray(nombrePersonaje);

                for (JsonElement atributoElement : atributosArray) {
                    JsonObject atributoObject = atributoElement.getAsJsonObject();
                    for (String clave : atributoObject.keySet()) {
                        if (!existeEnListaArray(atributosUnicos, clave)) {
                            atributosUnicos.insertFinal(clave);
                        }
                    }
                }
            }
        }
        System.out.println("Número total de atributos únicos: " + atributosUnicos.getSize());
        return atributosUnicos;
    }

// Método auxiliar para verificar si una clave existe en la ListaArray
    private boolean existeEnListaArray(ListaArray lista, String clave) {
        NodoArray[] array = lista.getArray();
        for (int i = 0; i < lista.getSize(); i++) {
            if (array[i] != null && clave.equals(array[i].getElement())) {
                return true;
            }
        }
        return false;
    }

    private void parsearJson(String contenidoJson) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(contenidoJson, JsonObject.class);

        // Paso 1: Obtener atributos únicos
        ListaArray atributosUnicos = obtenerAtributosUnicos(jsonObject);

        // Paso 2: Procesar las casas y personajes
        for (String nombreCasa : jsonObject.keySet()) {
            Casa casa = new Casa(nombreCasa);
            JsonArray personajesArray = jsonObject.getAsJsonArray(nombreCasa);

            for (JsonElement personajeElement : personajesArray) {
                JsonObject personajeObject = personajeElement.getAsJsonObject();
                String nombrePersonaje = personajeObject.keySet().iterator().next();
                JsonArray atributosArray = personajeObject.getAsJsonArray(nombrePersonaje);

                Persona persona = new Persona(nombrePersonaje, "", atributosUnicos.getSize());

                // Rellenar atributos
                NodoArray[] atributosArrayPersona = persona.getAtributos().getArray();
                for (int i = 0; i < atributosUnicos.getSize(); i++) {
                    atributosArrayPersona[i] = new NodoArray("none"); // Inicializar con "none"
                }

                // Asignar valores existentes
                for (JsonElement atributoElement : atributosArray) {
                    JsonObject atributoObject = atributoElement.getAsJsonObject();
                    for (String clave : atributoObject.keySet()) {
                        int index = obtenerIndice(atributosUnicos, clave);
                        String valor = atributoObject.get(clave).isJsonArray()
                                ? atributoObject.getAsJsonArray(clave).toString()
                                : atributoObject.get(clave).getAsString();
                        atributosArrayPersona[index] = new NodoArray(clave + ": " + valor);
                    }
                }
                casa.addPersonaje(persona);
//                personaHashTable.add(persona, false);//aniadimos personas a la hashtable
            }
            casas.insertFinal(casa);
        }

        imprimirCasas();
        ArbolGenealogico arbol = new ArbolGenealogico();
        arbol.construirArbol(casas);
        arbol.imprimirArbol(); // Para mostrarlo en texto
//        arbol.mostrarArbol();  // Para visualizar con graphstream (no sirve)
    }

// Método para obtener el índice de un atributo en ListaArray
    private int obtenerIndice(ListaArray atributosUnicos, String clave) {
        NodoArray[] array = atributosUnicos.getArray();
        for (int i = 0; i < atributosUnicos.getSize(); i++) {
            if (array[i] != null && clave.equals(array[i].getElement())) {
                return i;
            }
        }
        return -1; // No encontrado
    }

    private void imprimirCasas() {
        Nodo<Casa> nodoCasa = casas.getHead();
        while (nodoCasa != null) {
            Casa casa = nodoCasa.getElement();
            System.out.println("Casa: " + casa.getNombre());

            Nodo<Persona> nodoPersona = casa.getPersonajes().getHead();
            while (nodoPersona != null) {
                Persona personaje = nodoPersona.getElement();
                System.out.println("  - Personaje: " + personaje.getNombre());

                NodoArray[] atributosArray = personaje.getAtributos().getArray();
                for (int i = 0; i < atributosArray.length; i++) {
                    NodoArray atributoNodo = atributosArray[i];
                    if (atributoNodo != null) {
                        System.out.println("    * " + atributoNodo.getElement());
                    } else {
                        System.out.println("    * none");
                    }
                }
                nodoPersona = nodoPersona.getNext();
            }
            nodoCasa = nodoCasa.getNext();
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
    private javax.swing.JButton VerRegistro;
    private javax.swing.JButton btnCargarArchivo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
