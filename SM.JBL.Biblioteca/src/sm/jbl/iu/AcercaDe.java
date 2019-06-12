/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jbl.iu;

/**
 * Muestra información sobre el autor y el proyecto
 * @author JaviBl8
 * 
 */
public class AcercaDe extends java.awt.Dialog {

    /**
     * Creates new form AcercaDe
     * @param parent El frame desde el que se crea
     * @param modal Modal
     */
    public AcercaDe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAutor = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelVersion = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new java.awt.GridLayout(0, 1));

        jLabelAutor.setText("Created by Javier Bueno López");
        add(jLabelAutor);

        jLabelNombre.setText("PAINT2D");
        add(jLabelNombre);

        jLabelVersion.setText("alpha version 1.0");
        add(jLabelVersion);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AcercaDe dialog = new AcercaDe(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelVersion;
    // End of variables declaration//GEN-END:variables
}
