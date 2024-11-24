/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Clases.NodoTree;
import Clases.Persona;
import Clases.Tree;
import javax.swing.JFrame;
import proyecto2.HashTable;

/**
 *
 * @author Eddy
 */
public class Search extends javax.swing.JFrame {
    
    private HashTable personaHashTable;
    private HashTable moteHashTable;
    private int activeSearch;
    
    /**
     * Creates new form Search
     */
    public Search() {
        initComponents();
        SearchResults.removeAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        SearchType = new javax.swing.JComboBox<>();
        SearchText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchResults = new javax.swing.JList<>();
        SearchBtn = new javax.swing.JButton();
        SelectResultBtn = new javax.swing.JButton();
        SelectSearchType = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SearchType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTypeActionPerformed(evt);
            }
        });
        jPanel1.add(SearchType, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 90, 30));

        SearchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTextActionPerformed(evt);
            }
        });
        jPanel1.add(SearchText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 460, 40));

        SearchResults.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(SearchResults);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 460, 260));

        SearchBtn.setText("Buscar");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(SearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 130, 40));

        SelectResultBtn.setText("Seleccionar");
        SelectResultBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectResultBtnActionPerformed(evt);
            }
        });
        jPanel1.add(SelectResultBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 160, 50));

        SelectSearchType.setText("Seleccionar");
        SelectSearchType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectSearchTypeActionPerformed(evt);
            }
        });
        jPanel1.add(SelectSearchType, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 90, 30));

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
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTypeActionPerformed

    private void SearchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        switch (activeSearch) {
            case 0:
                SearchResults.setListData(personaHashTable.getMatch(SearchText.getText(), false));
            default:
                SearchResults.setListData(moteHashTable.getMatch(SearchText.getText(), true));;
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void SelectResultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectResultBtnActionPerformed
        NodoTree result;
        Tree subTree = new Tree();
        switch (activeSearch) {
            case 0:
                result = personaHashTable.get(SearchResults.getSelectedValue(), false);
            default:
                result = moteHashTable.get(SearchResults.getSelectedValue(), true);
        }
        subTree.setRoot(result);
        subTree.displayGraph();
    }//GEN-LAST:event_SelectResultBtnActionPerformed

    private void SelectSearchTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectSearchTypeActionPerformed
        if(SearchType.getSelectedItem().equals("Nombre + numeral")){
            activeSearch = 0;
        } else {
            activeSearch = 1;
        }
    }//GEN-LAST:event_SelectSearchTypeActionPerformed

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
    private javax.swing.JButton SearchBtn;
    private javax.swing.JList<String> SearchResults;
    private javax.swing.JTextField SearchText;
    private javax.swing.JComboBox<String> SearchType;
    private javax.swing.JButton SelectResultBtn;
    private javax.swing.JButton SelectSearchType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
