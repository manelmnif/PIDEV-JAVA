/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Dell
 */
public class festival {
    
        private int id_fe ;
    private String nom_fe ;
    private LocalDate date_debut_fe ;
    private LocalDate date_fin_fe ;
    private String description_fe;
    private String categorie_fe;
    private String img_fe;


    public festival() {
    }

    public festival(String nom_fe, LocalDate date_debut_fe, LocalDate date_fin_fe, String description_fe, String categorie_fe, String img_fe) {
        this.nom_fe = nom_fe;
        this.date_debut_fe = date_debut_fe;
        this.date_fin_fe = date_fin_fe;
        this.description_fe = description_fe;
        this.categorie_fe = categorie_fe;
        this.img_fe = img_fe;
    }

    public festival(int id_fe, String nom_fe, LocalDate date_debut_fe, LocalDate date_fin_fe, String description_fe, String categorie_fe, String img_fe) {
        this.id_fe = id_fe;
        this.nom_fe = nom_fe;
        this.date_debut_fe = date_debut_fe;
        this.date_fin_fe = date_fin_fe;
        this.description_fe = description_fe;
        this.categorie_fe = categorie_fe;
        this.img_fe = img_fe;
    }

    public int getId_fe() {
        return id_fe;
    }

    public String getNom_fe() {
        return nom_fe;
    }

    public LocalDate getDate_debut_fe() {
        return date_debut_fe;
    }

    public LocalDate getDate_fin_fe() {
        return date_fin_fe;
    }

    public String getDescription_fe() {
        return description_fe;
    }

    public String getCategorie_fe() {
        return categorie_fe;
    }

    public String getImg_fe() {
        return img_fe;
    }

    public void setId_fe(int id_fe) {
        this.id_fe = id_fe;
    }

    public void setNom_fe(String nom_fe) {
        this.nom_fe = nom_fe;
    }

    public void setDate_debut_fe(LocalDate date_debut_fe) {
        this.date_debut_fe = date_debut_fe;
    }

    public void setDate_fin_fe(LocalDate date_fin_fe) {
        this.date_fin_fe = date_fin_fe;
    }

    public void setDescription_fe(String description_fe) {
        this.description_fe = description_fe;
    }

    public void setCategorie_fe(String categorie_fe) {
        this.categorie_fe = categorie_fe;
    }

    public void setImg_fe(String img_fe) {
        this.img_fe = img_fe;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final festival other = (festival) obj;
        if (this.id_fe != other.id_fe) {
            return false;
        }
        if (!Objects.equals(this.nom_fe, other.nom_fe)) {
            return false;
        }
        if (!Objects.equals(this.description_fe, other.description_fe)) {
            return false;
        }
        if (!Objects.equals(this.categorie_fe, other.categorie_fe)) {
            return false;
        }
        if (!Objects.equals(this.img_fe, other.img_fe)) {
            return false;
        }
        if (!Objects.equals(this.date_debut_fe, other.date_debut_fe)) {
            return false;
        }
        if (!Objects.equals(this.date_fin_fe, other.date_fin_fe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "festival{" + "id_fe=" + id_fe + ", nom_fe=" + nom_fe + ", date_debut_fe=" + date_debut_fe + ", date_fin_fe=" + date_fin_fe + ", description_fe=" + description_fe + ", categorie_fe=" + categorie_fe + ", img_fe=" + img_fe + '}';
    }
    
    
}
