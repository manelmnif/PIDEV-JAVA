package service;


import entites.evenement;
import iService.ievenementService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionBD;

public class evenementService implements ievenementService{
   Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;
    PreparedStatement pst;
    private static evenementService instance;
    public evenementService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
           
    
    
    
   @Override
    public void creerevenement(evenement e) {
        try {
            String req1="INSERT INTO `evenement` "
                    + "(`nom_e`,`date_debut_e`,`date_fin_e`,`description_e`,`categorie_e`) "
                    + "VALUES ( '"+e.getNom_e()+"', '"
                    +e.getDate_debut_e()+"','"+e.getDate_fin_e()+"','"+e.getDescription_e()+"','"+e.getCategorie_e()+"');";
            
            
         
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
            Logger.getLogger(evenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
    }
     private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

   @Override
    public void modifierevenement(evenement e) {
        String sql = "UPDATE evenement SET nom_e=?, date_debut_e=?, date_fin_e=?, description_e=?, categorie_e=? where id_e="+e.getId_e();
 
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
        
        
        ps.setString(1, e.getNom_e());
        
          Date date1 = Date.from(e.getDate_debut_e().atStartOfDay(ZoneId.systemDefault()).toInstant());
          Date date2 = Date.from(e.getDate_fin_e().atStartOfDay(ZoneId.systemDefault()).toInstant());

        ps.setDate(2, convertUtilToSql(date1));
        ps.setDate(3, convertUtilToSql(date2));
        ps.setString(4, e.getDescription_e());
        ps.setString(5, e.getCategorie_e());

        int rowsUpdated = ps.executeUpdate();
          if (rowsUpdated > 0) {
            System.out.println("L'ev a été modifier avec succès");
          }
          } catch (SQLException ex) {
                     System.out.println("Erreur"+ex.getMessage());
 
          }
    }
    
    
    

   @Override
    public void supprimerevenement(evenement e) {
        try {
            String req1="delete from evenement where"
                    + " id_e=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, e.getId_e());
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(evenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
   @Override
    public List<evenement> afficherevenement() {
      
      List<evenement> evenement = new ArrayList<>();
      evenement e = null ;
      String req2="select * from evenement";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              e = new evenement();
                      e.setId_e(res.getInt("id_e"));
                      e.setNom_e(res.getString("nom_e") );
                      Date d1 =res.getDate("date_debut_e"); 
                      Date d2 =res.getDate("date_fin_e"); 
                      Instant instant = Instant.ofEpochMilli(d1.getTime());
                      Instant instant1 = Instant.ofEpochMilli(d2.getTime());
                      LocalDate date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
                      LocalDate date1 = instant1.atZone(ZoneId.systemDefault()).toLocalDate();
              System.out.println(date);

                   
        
                      e.setDate_debut_e(date);
                      e.setDate_fin_e(date1);
                      e.setDescription_e(res.getString("description_e"));
                      e.setCategorie_e(res.getString("categorie_e"));
              evenement.add(e);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return evenement;
    }

   

   
}

   
    

