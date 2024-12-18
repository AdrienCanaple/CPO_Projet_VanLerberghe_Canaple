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
    
    public void initialiserPartie(int nbLignes, int nbColonnes, int nbBombes){
        this.grille = new GrilleDeJeu(nbLignes,nbColonnes,nbBombes); 
        this.grille.placerBombeAleatoirement();
        this.grille.calculerBombesAdjacentes();
    }
    
    public void tourDeJeu (int ligne, int colonne){
        if(ligne<0 || ligne>9||colonne<0 ||colonne>9){
            System.out.println("retente ta chance avec d'autres coordonnées");
        }
        grille.revelerCellule(ligne, colonne);
        grille.toString();
        if (grille.getPresenceBombe(ligne, colonne)==true){
            System.out.println("perdu ...");
            verifierVictoire ();
        }
        else if (grille.toutesCellulesRevelees()== true){
            System.out.println("Gagné !!!");
            verifierVictoire ();
        }
    }
    
    public boolean verifierVictoire (){
        boolean victoire = false;
        if(grille.toutesCellulesRevelees()== true){
            System.out.println("Victoire");
            victoire = true;
            return victoire;
        }
        else {
            return victoire;
        }
    }
    
    
    
    public void demarrerPartie (){
        System.out.println("Choisissez un niveau de difficulté : " + "\n" + " 1) Facile"+ "\n" + " 2) Moyen"+ "\n" + " 3) Difficile");
        int k = sc.nextInt();
        int nbLignes=0;
        int nbColonnes=0;
        int nbBombes=0;
        
        if (k==1) {
            nbLignes=5;
            nbColonnes=5;
            nbBombes=4;
        } else if (k==2){
            nbLignes=9;
            nbColonnes=9;
            nbBombes=12; 
        } else if (k==3){
            nbLignes=13;
            nbColonnes=13;
            nbBombes=25;
        }
        
        this.tourDeJeu(nbLignes,nbColonnes);
        this.initialiserPartie(nbLignes,nbColonnes,nbBombes);
        this.verifierVictoire();
        
        while(verifierVictoire() == false){
            System.out.println(grille);
            System.out.println("sélectionne une nouvelle case");
            int ligne = sc.nextInt();
            int colonne = sc.nextInt();
            this.tourDeJeu(ligne, colonne);
        }
        System.out.println("Vous avez gagné");
    }
}
