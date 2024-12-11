
/*
 * mini-projet démineur 
 * 20/11/2024
 * Adrien CANAPLE Louison Van Lerberghe
 */
package projet_vanlerberghe_canaple;


import java.util.Random;


public class GrilleDeJeu {
    private Cellule matriceCellules [][];
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }
    public void placerBombeAleatoirement(){
        // boucle for poir nb bombes
        int compteur =0;
        while (compteur<12){//adapter nombre bombes
        Random generateurAleat = new Random ();
        int x = generateurAleat.nextInt(9);
        int y = generateurAleat.nextInt(9);
        if (matriceCellules [x][y].getPresenceBombe()==false){
            matriceCellules [x][y].placerBombe();
            compteur++;
        }
        }
    }
    
    public void calculerBombesAdjacentes(){
        //modifier pour la taille de la grille
        for (int x = 0;x<10;x++){
            for (int y = 0;y<10;y++){
                int NbBombesAdjacentes = 0;
                for (int a = -1;a<2;a++){
                    for(int b= -1;b<2;b++ ){
                        if (0<x && x<9 && 0<y && y<9){
                        if (matriceCellules[x+a][y+b].getPresenceBombe()== true){
                        NbBombesAdjacentes++;
                    }
                    }
                }
                }
                matriceCellules[x][y].setNbBombesAdjacentes(NbBombesAdjacentes);
            }
        }
    }
    
    public void revelerCellule(int ligne, int colonne){
        if (matriceCellules[ligne][colonne].getPresenceBombe()== true && matriceCellules[ligne][colonne].isDevoilee() == false){
            System.out.println("Fin de la partie!!");
        } else {
            matriceCellules[ligne][colonne].revelerCellule();
            if (matriceCellules[ligne][colonne].getNbBombesAdjacentes()==0){
                if (ligne-1>0 && colonne-1>0 && matriceCellules[ligne-1][colonne-1].isDevoilee()==false){
                    matriceCellules[ligne-1][colonne-1].revelerCellule();
                }
                if (ligne-1>0 && colonne>0 && matriceCellules[ligne-1][colonne].isDevoilee()==false){
                    matriceCellules[ligne-1][colonne].revelerCellule();
                }
                if (ligne-1>0 && colonne+1<9 && matriceCellules[ligne-1][colonne+1].isDevoilee()==false){
                    matriceCellules[ligne-1][colonne+1].revelerCellule();
                }   
                if (ligne>0 && colonne-1>0 && matriceCellules[ligne][colonne-1].isDevoilee()==false){
                    matriceCellules[ligne][colonne-1].revelerCellule();
                }
                if (ligne>0 && colonne+1<9 && matriceCellules[ligne][colonne+1].isDevoilee()==false){
                    matriceCellules[ligne][colonne+1].revelerCellule();
                }
                if (ligne+1<9 && colonne-1>0 && matriceCellules[ligne+1][colonne-1].isDevoilee()==false){
                    matriceCellules[ligne+1][colonne-1].revelerCellule();
                }  
                if (ligne+1<9 && colonne<9 && matriceCellules[ligne+1][colonne].isDevoilee()==false){
                    matriceCellules[ligne+1][colonne].revelerCellule();
                }
                if (ligne+1<9 && colonne+1<9 && matriceCellules[ligne+1][colonne+1].isDevoilee()==false){
                    matriceCellules[ligne+1][colonne+1].revelerCellule();
                }  
            
            }
      
        }
               
    }
    public boolean getPresenceBombe(int ligne, int colonne){
        if(matriceCellules[ligne][colonne].getPresenceBombe()== true){
            return true;
        }
        else{ 
            return false;
        }
    }
    public boolean toutesCellulesRevelees(){
        boolean result=true;
        for (int x = 0;x<10;x++){
            for (int y = 0;y<10;y++){
        if (matriceCellules[x][y].isDevoilee() == false && matriceCellules[x][y].getPresenceBombe()==false){
            result=false;
        }
        return result;    
            }
}
}
}



