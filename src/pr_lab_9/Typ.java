/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr_lab_9;
import java.util.Random;
/**
 *
 * @author student
 */
public class Typ {
    int pomidor=0;
    int ogorek=1;
    int cebula=2;
    String nazwy[]={"pomidor","ogorek","cebula"};
    Random generator = new Random();
    int iloscTypow=3;
    public int losuj(){
        return generator.nextInt(3);
    }
    
}
