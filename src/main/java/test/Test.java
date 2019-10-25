/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package test;

import entites.evenement;
import entites.festival;
import java.time.LocalDate;
import java.time.LocalDateTime;
import service.evenementService;
import service.festivalService;

/**
 *
 * @author Dell
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        evenementService ps = new evenementService();
         festivalService fs = new festivalService();
        LocalDate currentTime = LocalDate.now(); 
        
        
        LocalDate date1 = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
         LocalDate date2 = currentTime.withDayOfMonth(25).withYear(2023).withMonth(12);
           LocalDate date3 = currentTime.withDayOfMonth(25).withYear(2026).withMonth(12);
         LocalDate date4 = currentTime.withDayOfMonth(25).withYear(2028).withMonth(12);
         
         //ps.creerevenement(new evenement("esprit",date1,date2,"aaaa","ccccccccc"));
        // ps.supprimerevenement(e1);
       // System.out.println(ps.afficherevenement());
       fs.creerfestival(new festival("esprit",date1,date2,"aaaa","ccccccccc","a"));
       
      evenement e1 = new evenement(4,"esprit",date3,date4,"ddddddd","hhhhhhh");
        
      ps.modifierevenement(e1);
        
       
       
    }
    
}
