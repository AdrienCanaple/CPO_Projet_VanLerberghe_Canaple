
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projet_vanlerberghe_canaple;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JButton;

/**
 *
 * @author adrie
 */
public class FenetrePrincipale extends javax.swing.JFrame{

    /**
     * Creates new form FenetrePrincipale
     */
    GrilleDeJeu grille;
    Scanner sc = new Scanner(System.in);
    
    
    
    // méthode pour initiliser une partie avec la création d'une grille
    public void initialiserPartie(int nbLignes, int nbColonnes, int nbBombes){
        this.grille = new GrilleDeJeu(nbLignes,nbColonnes,nbBombes); 
        this.grille.placerBombeAleatoirement();
        this.grille.calculerBombesAdjacentes();
    }
    
    
    
    // méthode qui utilise la methode toutesCellulesRevelees pour voir si le joueur a réussi à dévoiler toutes les cases sans toucher de bombes 
    public boolean verifierVictoire (){
        boolean victoire = false;
        if(grille.toutesCellulesRevelees()== true){
            victoire = true;
            return victoire;
        }
        else {
            return victoire;
        }
    }
    
    
    
    
    
    public FenetrePrincipale(int nbLignes, int nbColonnes, int nbBombes) {
        initComponents();

        PanneauGrille.setLayout(new GridLayout(nbLignes,nbColonnes));
        this.grille = new GrilleDeJeu(nbLignes,nbColonnes,nbBombes);
        this.initialiserPartie(nbLignes,nbColonnes,nbBombes);
        
        
        FenetreVictoire f = new FenetreVictoire();
        FentreDefaite f2 = new FentreDefaite();
        

        for(int i = 0;i<nbLignes;i++){
            for(int j = 0; j<nbColonnes; j++){
                final int i2=i;
                final int j2=j;
            
                CelluleGraphique bouton_cellule = new CelluleGraphique(grille.matriceCellules[i][j],36,36);
                PanneauGrille.add(bouton_cellule);
                
                bouton_cellule.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                      grille.revelerCellule(i2,j2);
                      
                      if (verifierVictoire()==true) System.out.println("victoire");   
                      if (verifierVictoire()==true) f.setVisible(true);
                      if (verifierVictoire()==true) dispose();
                      if (grille.matriceCellules[i2][j2].getPresenceBombe() == true) f2.setVisible(true);
                      if (grille.matriceCellules[i2][j2].getPresenceBombe() == true) dispose();
                      
                      PanneauGrille.repaint();
                 }
            });
        }
        
            
        
        
        
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauGrille = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(153, 153, 153));
        PanneauGrille.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout PanneauGrilleLayout = new javax.swing.GroupLayout(PanneauGrille);
        PanneauGrille.setLayout(PanneauGrilleLayout);
        PanneauGrilleLayout.setHorizontalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        PanneauGrilleLayout.setVerticalGroup(
            PanneauGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FenetrePrincipale p = new FenetrePrincipale (20, 20, 30);
                p.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    // End of variables declaration//GEN-END:variables
}
