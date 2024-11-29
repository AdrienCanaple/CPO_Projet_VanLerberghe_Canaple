/*
 * Mini projet 
 * Louison van Lerberghe/Adrien Canaple 
 * TDB
 * novembre 2024
 */
package projet_vanlerberghe_canaple;



/**
 *
 * @author louison_vl
 */
public class Cellule {
    
    private boolean presenceBombe;
    private boolean devoilee;
    private int NbBombesAdjacentes;

    
    public boolean getPresenceBombe() {
        return presenceBombe;
    }

    public boolean isDevoilee() {
        return devoilee;
    }

    public int getNbBombesAdjacentes() {
        return NbBombesAdjacentes;
    }
    
    public void placerBombe(){
        presenceBombe=true;    
    }
    
    public void revelerCellule(){
        devoilee=true;
    }

    public void setNbBombesAdjacentes(int NbBombesAdjacentes) {
        this.NbBombesAdjacentes = NbBombesAdjacentes;
    }
     

    @Override
    public String toString() {
        String affichage = "";
        if (devoilee==false){
            affichage = "?";
        } else if (presenceBombe==true && devoilee==true) {
            affichage =  "B";
        } else if (NbBombesAdjacentes>0 && presenceBombe==false && devoilee==true){
            affichage =  NbBombesAdjacentes+"";
        } else if (devoilee==true && presenceBombe==false && NbBombesAdjacentes==0) {
            affichage =  " ";
        }
        return affichage;
    }
    
}
