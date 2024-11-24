/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Clases.ListaArray;
import Clases.NodoArray;
import Clases.Persona;
import Clases.Tree;
import javax.swing.JFrame;

/**
 *
 * @author xc2do
 */
public class ListaGeneracion extends javax.swing.JFrame {

    private Tree arbolGenealogico;

    /**
     * Creates new form ListaGeneracion
     */
    public ListaGeneracion(Tree arbolGenealogico) {
        initComponents();
        this.arbolGenealogico = arbolGenealogico;
        llenarComboBoxGeneraciones();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Para que no se cierre el programa cuando se clickea "x"
        WindowManager.registrarVentana(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Generaciones = new javax.swing.JComboBox<>();
        CargarIntegrantes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        IntegrantesGen = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Generaciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Generaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneracionesActionPerformed(evt);
            }
        });

        CargarIntegrantes.setText("jButton1");
        CargarIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarIntegrantesActionPerformed(evt);
            }
        });

        IntegrantesGen.setColumns(20);
        IntegrantesGen.setRows(5);
        jScrollPane1.setViewportView(IntegrantesGen);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Generaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CargarIntegrantes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Generaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(CargarIntegrantes)))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeneracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneracionesActionPerformed
        int generacion = Generaciones.getSelectedIndex() + 1;
        ListaArray integrantes = arbolGenealogico.obtenerIntegrantesDeGeneracion(generacion, 100);
        IntegrantesGen.setText("");
        NodoArray[] arrayIntegrantes = integrantes.getArray();
        for (int i = 0; i < integrantes.getSize(); i++) {
            NodoArray nodoIntegrante = arrayIntegrantes[i];
            if (nodoIntegrante != null) {
                Persona persona = (Persona) nodoIntegrante.getElement();
                IntegrantesGen.append(persona.getNombre() + "\n");
            }
        }
    }//GEN-LAST:event_GeneracionesActionPerformed

    private void CargarIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarIntegrantesActionPerformed
        int generacion = Generaciones.getSelectedIndex() + 1;
        ListaArray integrantes = arbolGenealogico.obtenerIntegrantesDeGeneracion(generacion, 100);
        IntegrantesGen.setText("");
        NodoArray[] arrayIntegrantes = integrantes.getArray();
        for (int i = 0; i < integrantes.getSize(); i++) {
            NodoArray nodoIntegrante = arrayIntegrantes[i];
            if (nodoIntegrante != null) {
                Persona persona = (Persona) nodoIntegrante.getElement();
                IntegrantesGen.append(persona.getNombre() + "\n");
            }
        }
    }//GEN-LAST:event_CargarIntegrantesActionPerformed

    private void llenarComboBoxGeneraciones() {
        Generaciones.removeAllItems();
        int alturaArbol = arbolGenealogico.obtenerAlturaArbol();
        for (int i = 1; i <= alturaArbol; i++) { // Suponiendo un máximo de 10 generaciones 
            Generaciones.addItem("Generación " + i);
            System.out.println("Aniadiendo al ComboBox: Generacion " + i);
        }
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
            java.util.logging.Logger.getLogger(ListaGeneracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaGeneracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaGeneracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaGeneracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tree arbolGenealogico = new Tree(); // Crea una instancia de Tree o pásala desde otra parte del código
                new ListaGeneracion(arbolGenealogico).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargarIntegrantes;
    private javax.swing.JComboBox<String> Generaciones;
    private javax.swing.JTextArea IntegrantesGen;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
