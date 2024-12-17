
/*
 * mini-projet démineur 
 * 20/11/2024
 * Adrien CANAPLE Louison Van Lerberghe
 */
package projet_vanlerberghe_canaple;


import java.util.Random;


public class GrilleDeJeu {
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;
    public Cellule [][] matriceCellules = new Cellule [nbLignes][nbColonnes];
    
    
    public GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.matriceCellules = new Cellule [nbLignes][nbColonnes];
        
        for (int x=0; x<nbLignes; x++){
            for (int y=0; y<nbColonnes; y++) {
                matriceCellules[x][y]= new Cellule();
            }
        }
    }

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
        for (int x = 0;x<nbLignes;x++){
            for (int y = 0;y<nbColonnes;y++){
                int NbBombesAdjacentes = 0;
                if(matriceCellules[x][y].getPresenceBombe()==false){
                for (int a = x-1;a<=x+1;a++){
                    for(int b= y-1;b<=y+1;b++ ){
                        if (0<=a && a<nbLignes && 0<=b && b<nbColonnes){
                        if (matriceCellules[a][b].getPresenceBombe()== true){
                        NbBombesAdjacentes++;
                    }
                    }
                }
                }
                matriceCellules[x][y].setNbBombesAdjacentes(NbBombesAdjacentes);
            }
            }
        }
    }
    
    public void revelerCellule(int ligne, int colonne){
        if(matriceCellules[ligne][colonne].isDevoilee()){
            return;
        }
       matriceCellules[ligne][colonne].revelerCellule();
        if (matriceCellules[ligne][colonne].getPresenceBombe()== true){
            System.out.println("Fin de la partie!!");
        } else {           
            if (matriceCellules[ligne][colonne].getNbBombesAdjacentes()==0){
              for(int i= ligne-1;i<=ligne+1;i++){
                  for(int j = colonne-1; j<=colonne+1 ; j++){
                      if (i>=0 && i <nbLignes){
                          if(j>=0 && j<nbColonnes){
                              this.revelerCellule(i,j);
                          }
                      }
                  }
              }
            
            }
      
        }
               
    }
    public boolean getPresenceBombe(int ligne, int colonne){
        return matriceCellules[ligne][colonne].getPresenceBombe();
    }
    public boolean toutesCellulesRevelees(){
        boolean result=true;
        for (int x = 0;x<nbLignes;x++){
            for (int y = 0;y<nbColonnes;y++){
        if (matriceCellules[x][y].isDevoilee() == false && matriceCellules[x][y].getPresenceBombe()== false){
            result=false;
        }
            }
        }
        return result;              
}
    @Override
    public String toString() {
        String affichage = "";
        int cpt = 0;
        for (int x = 0;x<nbLignes;x++){
            for (int y = 0;y<nbColonnes;y++){
        if (matriceCellules[x][y].isDevoilee()==false){
            affichage = affichage + "? ";
            cpt++;
        } else if (matriceCellules[x][y].getPresenceBombe()==true && matriceCellules[x][y].isDevoilee()==true) {
            affichage = affichage + "B ";
            cpt++;
        } else if (matriceCellules[x][y].getNbBombesAdjacentes()>0 && matriceCellules[x][y].getPresenceBombe()==false && matriceCellules[x][y].isDevoilee()==true){
            affichage =  affichage + matriceCellules[x][y].getNbBombesAdjacentes()+" ";
            cpt++;
        } else if (matriceCellules[x][y].isDevoilee()==true && matriceCellules[x][y].getPresenceBombe()==false && matriceCellules[x][y].getNbBombesAdjacentes()==0) {
            affichage = affichage + "  ";
            cpt++;
        }
        if(cpt == nbColonnes){
            cpt = 0;
            affichage = affichage +"\n";
        }
    }
        }
        return affichage;
    }
}
