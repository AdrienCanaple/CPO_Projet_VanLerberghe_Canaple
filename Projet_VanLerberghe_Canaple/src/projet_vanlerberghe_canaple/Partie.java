/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projet_vanlerberghe_canaple;

/**
 *
 * @author louison_vl
 */
public class Partie {
    GrilleDeJeu grille;

    public Partie(GrilleDeJeu grille) {
        this.grille = grille;
    }
    
    public void initialiserPartie(){
        grille.placerBombeAleatoirement();
        grille.calculerBombesAdjacentes();
        
    }
    public void tourDeJeu (int ligne, int colonne){
        grille.revelerCellule(ligne, colonne);
        grille.toString();
    }
    public boolean verifierVictoire (){
        if(grille.toutesCellulesRevelees()== true){
            System.out.println("Victoire");
            return true;
        }
        else {
            return false;
        }
    }
    public void demarrerPartie (){
        this.initialiserPartie();
        this.tourDeJeu(10,10);
        this.verifierVictoire();
        
    }
}

