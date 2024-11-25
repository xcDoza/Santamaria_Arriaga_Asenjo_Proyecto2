/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Clases.Lista;
import Clases.Persona;
import Clases.Casa;
import Clases.ListaArray;
import Clases.Nodo;
import Clases.NodoArray;
import Clases.NodoTree;
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
    private Search searchFrame;
    private TitleSearch titleSearchFrame;
    private HashTable personaHashTable;
    private ListaGeneracion ListaGeneracion;
    private HashTable moteHashTable;
    private HashTableTitles titlesHashTable;
    private VerGeneracionYRegistro VerGeneracionYRegistro;

    Lista casas = new Lista();

    public Interfaz1() {
        initComponents();
        setLocationRelativeTo(null);
        houseTree = new Tree();
        personaHashTable = new HashTable(); // Inicializa la HashTable
        moteHashTable = new HashTable(); // Inicializa la HashTable
        titlesHashTable = new HashTableTitles(); // Inicializa la HashTable
        verRegistroFrame = new VerRegistro();
        searchFrame = new Search();
        titleSearchFrame = new TitleSearch();
        searchFrame.setPersonaHashTable(personaHashTable);
        searchFrame.setMoteHashTable(moteHashTable);
        verRegistroFrame.setPersonaHashTable(personaHashTable);
        titleSearchFrame.setTitlesHashTable(titlesHashTable);
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
        CargarArchivoBtn = new javax.swing.JLabel();
        VerRegistroBtn = new javax.swing.JLabel();
        BuscarPorNombreBtn = new javax.swing.JLabel();
        VerAntepasadosBtn = new javax.swing.JLabel();
        BuscarPorTituloBtn = new javax.swing.JLabel();
        VerArbolBtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        CargarArchivoBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CargarArchivoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CargarArchivoBtnMouseClicked(evt);
            }
        });
        getContentPane().add(CargarArchivoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 260, 60));

        VerRegistroBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VerRegistroBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerRegistroBtnMouseClicked(evt);
            }
        });
        getContentPane().add(VerRegistroBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 260, 50));

        BuscarPorNombreBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarPorNombreBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarPorNombreBtnMouseClicked(evt);
            }
        });
        getContentPane().add(BuscarPorNombreBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 260, 50));

        VerAntepasadosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VerAntepasadosBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerAntepasadosBtnMouseClicked(evt);
            }
        });
        getContentPane().add(VerAntepasadosBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 260, 60));

        BuscarPorTituloBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarPorTituloBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarPorTituloBtnMouseClicked(evt);
            }
        });
        getContentPane().add(BuscarPorTituloBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 260, 60));

        VerArbolBtn.setToolTipText("");
        VerArbolBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VerArbolBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerArbolBtnMouseClicked(evt);
            }
        });
        getContentPane().add(VerArbolBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 190, 180));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/1.png"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPersonaHashTable(HashTable personaHashTable) {
        this.personaHashTable = personaHashTable;
    }

    public void setMoteHashTable(HashTable moteHashTable) {
        this.moteHashTable = moteHashTable;
    }

    public void setTitlesHashTable(HashTableTitles titlesHashTable) {
        this.titlesHashTable = titlesHashTable;
    }


    private void CargarArchivoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarArchivoBtnMouseClicked
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
//                    houseTree.displayGraph(); //con esto mostramos el grafo al parsear el json
                    verRegistroFrame.poblarComboBox(); // Asegúrate de llamar a poblarComboBox después de parsear el JSON y añadir nodos a la HashTable

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un archivo .json", "Archivo inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_CargarArchivoBtnMouseClicked

    private void VerRegistroBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerRegistroBtnMouseClicked
        VerGeneracionYRegistro listaGeneracionForm = new VerGeneracionYRegistro(houseTree, personaHashTable);
        listaGeneracionForm.setVisible(true);
    }//GEN-LAST:event_VerRegistroBtnMouseClicked

    private void BuscarPorNombreBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarPorNombreBtnMouseClicked
        searchFrame.poblarSearchType();
        searchFrame.setVisible(true);
    }//GEN-LAST:event_BuscarPorNombreBtnMouseClicked

    private void VerAntepasadosBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerAntepasadosBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_VerAntepasadosBtnMouseClicked

    private void BuscarPorTituloBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarPorTituloBtnMouseClicked
        titleSearchFrame.setVisible(true);
    }//GEN-LAST:event_BuscarPorTituloBtnMouseClicked

    private void VerArbolBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerArbolBtnMouseClicked
        houseTree.displayGraph(); //con esto mostramos el grafo al parsear el json
    }//GEN-LAST:event_VerArbolBtnMouseClicked


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
        System.out.println("Numero total de atributos unicos: " + atributosUnicos.getSize());
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
        WindowManager.cerrarTodasLasVentanas();
        personaHashTable.clear();
        moteHashTable.clear();
        titlesHashTable.clear();
        JsonObject jsonObject = gson.fromJson(contenidoJson, JsonObject.class);
        
        // Paso 1: Obtener atributos únicos
        ListaArray atributosUnicos = obtenerAtributosUnicos(jsonObject);

        // Paso 2: Procesar las casas y personajes
        for (String nombreCasa : jsonObject.keySet()) {
            Casa casa = new Casa(nombreCasa);
            JsonArray personajesArray = jsonObject.getAsJsonArray(nombreCasa);
            int contador = 0;

            for (JsonElement personajeElement : personajesArray) {
                JsonObject personajeObject = personajeElement.getAsJsonObject();
                String nombrePersonaje = personajeObject.keySet().iterator().next();
                JsonArray atributosArray = personajeObject.getAsJsonArray(nombrePersonaje);

                Persona persona = new Persona(nombrePersonaje, "", atributosUnicos.getSize(), contador);

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
                contador++;
//                personaHashTable.add(persona, false);//aniadimos personas a la hashtable
            }
            casas.deleteBegin();
            casas.insertFinal(casa);
        }

        imprimirCasas();
        ArbolGenealogico arbol = new ArbolGenealogico();
        arbol.construirArbol(casas);
//        arbol.imprimirArbol(); // Para mostrarlo en texto
//        arbol.mostrarArbol();  // Para visualizar con graphstream (no sirve)
        agregarNodosAHHashTable(arbol.getArbolGenealogico().getRoot()); // Usa el metodo getter
        houseTree = arbol.getArbolGenealogico();//usaremos este arbol para todo lo demas, posibles cambios
//        houseTree.displayGraph(); //mostrar el grafo aquí también

        imprimirContenidoHashTable();
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

    private void imprimirContenidoHashTable() {
        for (NodoTree nodo : personaHashTable.getTable()) {
            if (nodo != null) {
                Persona persona = (Persona) nodo.getElement();
                System.out.println("En HashTable: " + persona.getNombre());
            } else {
                System.out.println("Nodo es nulo en la HashTable");
            }
        }
    }

    private void agregarNodosAHHashTable(NodoTree nodo) {
        if (nodo == null) {
            System.out.println("Nodo es nulo, no se aniade a la HashTable.");
            return;
        }
        Persona persona = (Persona) nodo.getElement();
        if (persona == null) {
            System.out.println("Elemento de nodo es nulo, no se aniade a la HashTable.");
            return;
        }
        personaHashTable.add(nodo, false);
        if (persona.getApodo() != null){
            moteHashTable.add(nodo, true);
        }
        if (persona.getTitle() != null){
            titlesHashTable.add(persona);
        }
        System.out.println("Aniadido a HashTable: " + persona.getNombre()); // Mensaje de depuración
        for (NodoTree hijo : nodo.getSons()) {
            agregarNodosAHHashTable(hijo);
        }
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
        JOptionPane.showMessageDialog(null, "Arhivo cargado con exito");
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
    private javax.swing.JLabel BuscarPorNombreBtn;
    private javax.swing.JLabel BuscarPorTituloBtn;
    private javax.swing.JLabel CargarArchivoBtn;
    private javax.swing.JLabel VerAntepasadosBtn;
    private javax.swing.JLabel VerArbolBtn;
    private javax.swing.JLabel VerRegistroBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
