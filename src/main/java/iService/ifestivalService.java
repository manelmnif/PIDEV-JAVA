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
import entites.festival;
import java.util.List;
public interface ifestivalService {
    
    public void creerfestival(festival fe);
    public void modifierfestival(festival fe);
    public void supprimerfestival(festival fe);
    public List<festival> afficherfestival();
   
}

