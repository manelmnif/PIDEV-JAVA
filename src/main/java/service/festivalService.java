package service;


import entites.festival;
import iService.ievenementService;
import iService.ifestivalService;
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

public class festivalService implements ifestivalService{
   Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;
    PreparedStatement pst;
    private static evenementService instance;
    public festivalService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
           
    
    
    
   
   @Override
    public void creerfestival(festival fe) {
        try {
            String req1="INSERT INTO `festival` "
                    + "(`nom_fe`,`date_debut_fe`,`date_fin_fe`,`description_fe`,`img_fe`) "
                    + "VALUES ( '"+fe.getNom_fe()+"', '"
                    +fe.getDate_debut_fe()+"','"+fe.getDate_fin_fe()+"','"+fe.getDescription_fe()+"','"+fe.getCategorie_fe()+"');";
            
            
         
            ste.executeUpdate(req1);
        } catch (SQLException ex) {
            Logger.getLogger(festivalService.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
    }
     private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

   @Override
    public void modifierfestival(festival fe) {
        String sql = "UPDATE evenement SET nom_fe=?, date_debut_fe=?, date_fin_fe=?, description_fe=?, img_e=? where id_fe="+fe.getId_fe();
 
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
        
        
        ps.setString(1, fe.getNom_fe());
        
          Date date1 = Date.from(fe.getDate_debut_fe().atStartOfDay(ZoneId.systemDefault()).toInstant());
          Date date2 = Date.from(fe.getDate_fin_fe().atStartOfDay(ZoneId.systemDefault()).toInstant());

        ps.setDate(2, convertUtilToSql(date1));
        ps.setDate(3, convertUtilToSql(date2));
        ps.setString(4, fe.getDescription_fe());
        ps.setString(5, fe.getCategorie_fe());

        int rowsUpdated = ps.executeUpdate();
          if (rowsUpdated > 0) {
            System.out.println("L'ev a été modifier avec succès");
          }
          } catch (SQLException ex) {
                     System.out.println("Erreur"+ex.getMessage());
 
          }
    }
    
    
    

   
   @Override
    public void supprimerfestival(festival fe) {
        try {
            String req1="delete from festival where"
                    + " id_fe=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, fe.getId_fe());
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(evenementService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
   
   @Override
    public List<festival> afficherfestival() {
      
      List<festival> festival = new ArrayList<>();
      festival fe = null ;
      String req2="select * from festival";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              fe = new festival();
                      fe.setId_fe(res.getInt("id_fe"));
                      fe.setNom_fe(res.getString("nom_fe") );
                      Date d1 =res.getDate("date_debut_fe"); 
                      Date d2 =res.getDate("date_fin_fe"); 
                      Instant instant = Instant.ofEpochMilli(d1.getTime());
                      Instant instant1 = Instant.ofEpochMilli(d2.getTime());
                      LocalDate date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
                      LocalDate date1 = instant1.atZone(ZoneId.systemDefault()).toLocalDate();
              System.out.println(date);

                   
        
                      fe.setDate_debut_fe(date);
                      fe.setDate_fin_fe(date1);
                      fe.setDescription_fe(res.getString("description_e"));
                      fe.setCategorie_fe(res.getString("categorie_fe"));
              festival.add(fe);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return festival;
    }
}

/*
    @Override
    public void supprimerfestival(festival fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
}

   
    

*/