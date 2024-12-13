/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projet_vanlerberghe_canaple;

/**
 *
 * @author adrie
 */
public class Projet_VanLerberghe_Canaple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cellule une = new Cellule ();
        une.placerBombe();
        System.out.println(une.getPresenceBombe());
        
        System.out.println(une);
        
        une.revelerCellule();
        
        System.out.println(une);
        
        GrilleDeJeu Grille1 = new GrilleDeJeu(10,10,11);
        Partie grille1 = new Partie(Grille1);
        grille1.demarrerPartie();
    }
    
}
