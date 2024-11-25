/*
 * Interfaz para realizar búsquedas a través de la persona y de los motes
 * 
 */
package Interfaz;

import Clases.NodoTree;
import Clases.Persona;
import Clases.Tree;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import proyecto2.HashTable;

/**
 * Toma como parámetros el HashTable de cada persona y de los motes
 * @author Eddy
 */
public class Search extends javax.swing.JFrame {
    
    private HashTable personaHashTable;
    private HashTable moteHashTable;
    private int activeSearch;
    
    DefaultListModel<String> modelo = new DefaultListModel<>();
    
    /**
     * Creates new form Search
     */
    public Search() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Para que no se cierre el programa cuando se clickea "x"
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
        jLabel2 = new javax.swing.JLabel();
        VerSubarbolBtn = new javax.swing.JLabel();
        BuscarBtn = new javax.swing.JLabel();
        SearchType = new javax.swing.JComboBox<>();
        SearchText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchResults = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Opcion de busqueda");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, -1, -1));

        VerSubarbolBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VerSubarbolBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerSubarbolBtnMouseClicked(evt);
            }
        });
        jPanel1.add(VerSubarbolBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 200, 180));

        BuscarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarBtnMouseClicked(evt);
            }
        });
        jPanel1.add(BuscarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 150, 30));

        SearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SearchType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTypeActionPerformed(evt);
            }
        });
        jPanel1.add(SearchType, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 170, 40));

        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });
        jPanel1.add(SearchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 220, 40));

        jScrollPane1.setViewportView(SearchResults);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 300, 210));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/4_2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPersonaHashTable(HashTable personaHashTable) {
        this.personaHashTable = personaHashTable;
    }

    public void setMoteHashTable(HashTable moteHashTable) {
        this.moteHashTable = moteHashTable;
    }
    
        //metodo para poblar el ComboBox con los nombres de las personas
    public void poblarSearchType() {
        SearchType.removeAllItems(); // Limpia el ComboBox
        SearchType.addItem("Nombre + numeral");
        SearchType.addItem("Mote");
    }
    
    private void SearchTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTypeActionPerformed
        if(SearchType.getSelectedItem().equals("Nombre + numeral")){
            activeSearch = 0;
        } else {
            activeSearch = 1;
        }
    }//GEN-LAST:event_SearchTypeActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextActionPerformed

    private void VerSubarbolBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerSubarbolBtnMouseClicked
        NodoTree result;
        Tree subTree = new Tree();
        if (activeSearch == 0){
            result = personaHashTable.get(SearchResults.getSelectedValue(), false);            
        } else {
            result = moteHashTable.get(SearchResults.getSelectedValue(), true);
        }
        subTree.setRoot(result);
        subTree.displayGraph();
    }//GEN-LAST:event_VerSubarbolBtnMouseClicked

    private void BuscarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarBtnMouseClicked
        if (activeSearch == 0){
            System.out.println("en personas");
            SearchResults.setListData(personaHashTable.getMatch(SearchText.getText(), false));
        } else {
            System.out.println("en motes");
            SearchResults.setListData(moteHashTable.getMatch(SearchText.getText(), true));
        }
    }//GEN-LAST:event_BuscarBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuscarBtn;
    private javax.swing.JList<String> SearchResults;
    private javax.swing.JTextField SearchText;
    private javax.swing.JComboBox<String> SearchType;
    private javax.swing.JLabel VerSubarbolBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
