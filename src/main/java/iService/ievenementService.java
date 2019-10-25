/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iService;

/**
 *
 * @author Dell
 */
import entites.evenement;
import java.util.List;
public interface ievenementService {
    
    public void creerevenement(evenement e);
    public void modifierevenement(evenement e);
    public void supprimerevenement(evenement e);
    public List<evenement> afficherevenement();
   
}


