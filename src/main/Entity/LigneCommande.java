/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author PC
 */
public class LigneCommande {
   
    private int idarticle;
    private int qte;

    @Override
    public String toString() {
        return "LigneCommande{"  + ", idarticle=" + idarticle + ", qte=" + qte + '}';
    }

   
    public int getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(int idarticle) {
        this.idarticle = idarticle;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public LigneCommande() {
    }

    public LigneCommande( int idarticle, int qte) {
        
        this.idarticle = idarticle;
        this.qte = qte;
    }
    
}
