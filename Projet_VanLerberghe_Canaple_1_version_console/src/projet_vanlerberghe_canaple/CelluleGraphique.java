/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_vanlerberghe_canaple;

import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author adrie
 */
public class CelluleGraphique extends JButton{
    int largeur;
    int hauteur;
    Cellule celluleAssociee;
    
    public CelluleGraphique(Cellule celluleAssociee, int l, int h){
        this.largeur = l;
        this.hauteur = h;
        this.celluleAssociee = celluleAssociee;
    }
    
    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        this.setText(celluleAssociee.toString());
    }
    
    
}
