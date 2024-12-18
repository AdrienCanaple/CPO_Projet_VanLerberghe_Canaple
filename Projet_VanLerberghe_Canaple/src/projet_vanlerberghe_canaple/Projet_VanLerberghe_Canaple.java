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
        
        // La Grille1 est initialisé à une taille plus grande que la taille de la grille dans le niveau difficle et est ensuite réduite à la taille adapté avec la méthode démarrer partie 
        GrilleDeJeu Grille1 = new GrilleDeJeu(20,20,30);
        Partie grille1 = new Partie(Grille1);
        grille1.demarrerPartie();
    }
    
}
