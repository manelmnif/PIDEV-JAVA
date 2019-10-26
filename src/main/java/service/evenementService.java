/*
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
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entity.Evennement;
import Entity.TypeEvennement;
import Entity.User;
import Service.ievenementService;
import Service.TypeEvenementService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class EvennementService implements ievenementService{
    TypeEvennementService typeEvennementService = new TypeEvennementService();
    SingletonConnexion connect =SingletonConnexion.getInstance();
    Connection conn=connect.getConn();
    
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        User u;
    public EvenementService() {
        try {
            String q = UserSession.getInstance(null,null, null, null, null, null, null).getUserName();
            
            UserService uservice= new UserService();
            u=uservice.get(q);
        } catch (SQLException ex) {
            System.out.println("");
        }
        
    }
            
    
    @Override
    public void ajouterEvennement(Evennement event) {
        try {
          
            
            
            Statement ps=conn.createStatement();            
        if(event.getSalle()!=null)
            ps.executeUpdate("insert into evennement values ("+null+",'"+event.getDescription()+"','"+
                sdf.format(event.getDtDebut())+"','"+sdf.format(event.getDtFin())+"',"+
                event.getNbPlace()+",'"+event.isEntree()+"',"+event.getPrix()+",'"+sdf.format(new Date())+"',"+
                event.getType().getId()+","+event.getSalle().getId()+",'"+event.getImage()+"')");
        else
            ps.executeUpdate("insert into evennement values ("+null+",'"+event.getDescription()+"','"+
                    sdf.format(event.getDtDebut())+"','"+sdf.format(event.getDtFin())+"',"+
                    event.getNbPlace()+",'"+event.isEntree()+"',"+event.getPrix()+",'"+sdf.format(new Date())+"',"+
                    event.getType().getId()+","+null+",'"+event.getImage()+"')");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur d_'ajout \n"+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void modifEvennement(Evennement event) {
        try
        {
            Statement ps=conn.createStatement();
            ps.executeUpdate("UPDATE evennement SET description = '"+event.getDescription()+"', nbPlace = "+event.getNbPlace()+
                    " , dtDebut = '"+event.getDtDebut()+"', dtFin = '"+event.getDtFin()+"', entree= '"+event.isEntree()+         
                    "', prix= '"+event.getPrix()+"' WHERE id = "+event.getId());
        }catch(Exception e)
        {
           System.out.println("mise a jour erreuné"+e.getMessage());
        } 
    }

    @Override
    public void supprEvennement(Evennement event) {
        try {
            Statement ps=conn.createStatement();
            ps.executeUpdate("delete from evennement where id = '"+event.getId()+"'");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erreur de suppression\n"+ex.getMessage());
        }
    }

    @Override
    public ArrayList<Evennement> listerEvennment() {
        ArrayList<Evennement> lstEvennement = new ArrayList<Evennement>();
        TypeEvennement typeEvenet ;
        Salle salle;
        try{
            Statement ps=conn.createStatement();
            ResultSet res; 
            res=ps.executeQuery("select * from 	evennement order by(dtDebut) desc");
            while(res.next()){
                int id = res.getInt("id");
                String desc=res.getString("description");
                Date dtDebut=res.getDate("dtDebut");
                Date dtFin=res.getDate("dtFin");
                int nbPlace=res.getInt("nbPlace");
                String entree=res.getString("entree");
                float prix=res.getFloat("prix");
                Date dateCreation=res.getDate("dateCreation");
                String image=res.getString("image"); 
                int idtype=res.getInt("id_type");
                typeEvenet=typeEvennementService.rechercheTypeEvennementByID(idtype);
                int idsalle = res.getInt("id_salle");
                salle = new Salle();
                Evennement e = new Evennement(id, desc, dtDebut, dtFin, nbPlace, entree, prix, dateCreation, typeEvenet, salle, image);
                lstEvennement.add(e);                  
            }      
        }catch(Exception e)
        {
           System.out.println(""+e.getMessage());
        }   
          return lstEvennement;
    }

    @Override
    public Evennement rechercheEvennementByID(int idd) {
           
            TypeEvennement typeEvenet ;
            Salle salle;
        
        try { 
            Statement ps=conn.createStatement();
            ResultSet res;
            
            res=ps.executeQuery("select * from 	evennement where id="+idd);
            while(res.next())
            {
                int id = res.getInt("id");
                String desc=res.getString("description");
                Date dtDebut=res.getDate("dtDebut");
                Date dtFin=res.getDate("dtFin");
                int nbPlace=res.getInt("nbPlace");
                String entree=res.getString("entree");
                float prix=res.getFloat("prix");
                Date dateCreation=res.getDate("dateCreation");
                String image=res.getString("image"); 
                int idtype=res.getInt("id_type");
                typeEvenet=typeEvennementService.rechercheTypeEvennementByID(idtype);
               
                int idsalle = res.getInt("id_salle");
                salle = new Salle();
                
                Evennement e = new Evennement(id, desc, dtDebut, dtFin, nbPlace, entree, prix, dateCreation, typeEvenet, salle, image);  
                return e ;
            }
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
        return null;
    }
    
    @Override
    public Evennement rechercheEvennementByCrit(String crit) {
           
            TypeEvennement typeEvenet ;
            Salle salle;
        
        try { 
            Statement ps=conn.createStatement();
            ResultSet res;
            
            res=ps.executeQuery("select * from 	evennement where description like '%"+crit+"%' ");
            while(res.next())
            {
                int id = res.getInt("id");
                String desc=res.getString("description");
                Date dtDebut=res.getDate("dtDebut");
                Date dtFin=res.getDate("dtFin");
                int nbPlace=res.getInt("nbPlace");
                String entree=res.getString("entree");
                float prix=res.getFloat("prix");
                Date dateCreation=res.getDate("dateCreation");
                String image=res.getString("image"); 
                int idtype=res.getInt("id_type");
                typeEvenet=typeEvennementService.rechercheTypeEvennementByID(idtype);
               
                int idsalle = res.getInt("id_salle");
                salle = new Salle();
                
                return  new Evennement(id, desc, dtDebut, dtFin, nbPlace, entree, prix, dateCreation, typeEvenet, salle, image);  
                
            }
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Evennement> listerEvennmentProgramee() {

           ArrayList<Evennement> lstEvennement = new ArrayList<Evennement>();
        TypeEvennement typeEvenet ;
        Salle salle;
        try{
            Statement ps=conn.createStatement();
            ResultSet res; 
            res=ps.executeQuery("select * from 	evennement where dtFin > '"+sdf.format(new Date())+"'  order by(dtDebut) desc");
            while(res.next()){
                int id = res.getInt("id");
                String desc=res.getString("description");
                Date dtDebut=res.getDate("dtDebut");
                Date dtFin=res.getDate("dtFin");
                int nbPlace=res.getInt("nbPlace");
                String entree=res.getString("entree");
                float prix=res.getFloat("prix");
                Date dateCreation=res.getDate("dateCreation");
                String image=res.getString("image"); 
                int idtype=res.getInt("id_type");
                typeEvenet=typeEvennementService.rechercheTypeEvennementByID(idtype);
                int idsalle = res.getInt("id_salle");
                salle = new Salle();
                Evennement e = new Evennement(id, desc, dtDebut, dtFin, nbPlace, entree, prix, dateCreation, typeEvenet, salle, image);
                lstEvennement.add(e);                  
            }      
        }catch(Exception e)
        {
           System.out.println(""+e.getMessage());
        }   
          return lstEvennement;
    }
    
    
    
}


   
    

