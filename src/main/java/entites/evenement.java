/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dell
 */
public class evenement {
    private int id_e ;
    private String nom_e ;
    private LocalDate date_debut_e ;
    private LocalDate date_fin_e ;
    private String description_e;
    private String categorie_e;

    
    
    
    
    public evenement() {
    }

   
    
    
    public evenement(String nom_e, LocalDate date_debut_e, LocalDate date_fin_e, String description_e, String categorie_e) {
        this.nom_e = nom_e;
        this.date_debut_e = date_debut_e;
        this.date_fin_e = date_fin_e;
        this.description_e = description_e;  //blech id teb3a ajouter puisk id A,I
        this.categorie_e = categorie_e;
    }

    public evenement(int id_e, String nom_e, LocalDate date_debut_e, LocalDate date_fin_e, String description_e, String categorie_e) {
        this.id_e = id_e;
        this.nom_e = nom_e;
        this.date_debut_e = date_debut_e;  //modifier lazem t3ayat ll id bech tbadel 
        this.date_fin_e = date_fin_e;
        this.description_e = description_e;
        this.categorie_e = categorie_e;
    }

    public int getId_e() {
        return id_e;
    }

    public String getNom_e() {
        return nom_e;
    }

    public LocalDate getDate_debut_e() {
        return date_debut_e;
    }

    public LocalDate getDate_fin_e() {
        return date_fin_e;
    }

    public String getDescription_e() {
        return description_e;
    }

    public String getCategorie_e() {
        return categorie_e;
    }

    public void setId_e(int id_e) {
        this.id_e = id_e;
    }

    public void setNom_e(String nom_e) {
        this.nom_e = nom_e;
    }

    public void setDate_debut_e(LocalDate date_debut_e) {
        this.date_debut_e = date_debut_e;
    }

    public void setDate_fin_e(LocalDate date_fin_e) {
        this.date_fin_e = date_fin_e;
    }

    public void setDescription_e(String description_e) {
        this.description_e = description_e;
    }

    public void setCategorie_e(String categorie_e) {
        this.categorie_e = categorie_e;
    }

    @Override
    public String toString() {
        return "evenement{" + "id_e=" + id_e + ", nom_e=" + nom_e + ", date_debut_e=" + date_debut_e + ", date_fin_e=" + date_fin_e + ", description_e=" + description_e + ", categorie_e=" + categorie_e + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final evenement other = (evenement) obj;
        if (this.id_e != other.id_e) {
            return false;
        }
        if (!Objects.equals(this.nom_e, other.nom_e)) {
            return false;
        }
        if (!Objects.equals(this.description_e, other.description_e)) {
            return false;
        }
        if (!Objects.equals(this.categorie_e, other.categorie_e)) {
            return false;
        }
        if (!Objects.equals(this.date_debut_e, other.date_debut_e)) {
            return false;
        }
        if(!Objects.equals(this.date_fin_e, other.date_fin_e)) {
            return false;
        }
        return true;
    }

    

  
    
}
