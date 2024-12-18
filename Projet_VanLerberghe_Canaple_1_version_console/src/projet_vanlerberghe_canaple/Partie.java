/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_vanlerberghe_canaple;

import java.util.Scanner;

/**
 *
 * @author louison_vl
 */
public class Partie {
    GrilleDeJeu grille;
    Scanner sc = new Scanner(System.in);
    
    public Partie(GrilleDeJeu grille) {
        this.grille = grille;
    }
    
    public void initialiserPartie(){
        this.grille = new GrilleDeJeu(9,9,11); 
        this.grille.placerBombeAleatoirement();
        this.grille.calculerBombesAdjacentes();
    }
    
    public void tourDeJeu (int ligne, int colonne){
        if(ligne<0 || ligne>9||colonne<0 ||colonne>9){
            System.out.println("retente ta chance avec d'autres coordonnées");
        }
        grille.revelerCellule(ligne, colonne);
        grille.toString();
        if (grille.getPresenceBombe(ligne, colonne)){
            System.out.println("perdu ...");
            verifierVictoire ();
        }
        else if (grille.toutesCellulesRevelees()){
            System.out.println("Gagné !!!");
            verifierVictoire ();
        }
    }
    
    public boolean verifierVictoire (){
        boolean victoire = false;
        if(grille.toutesCellulesRevelees()== true){
            System.out.println("Victoire");
            return victoire;
        }
        else {
            return victoire;
        }
    }
    
    public void demarrerPartie (){
        this.tourDeJeu(9,9);
        this.initialiserPartie();
        this.verifierVictoire();
        
        while(verifierVictoire() == false){
            System.out.println(grille);
            System.out.println("sélectionne une nouvelle case");
            int ligne = sc.nextInt();
            int colonne = sc.nextInt();
            this.tourDeJeu(ligne, colonne);
        }
    }
}
