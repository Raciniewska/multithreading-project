/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr_lab_9;
//import pr_lab_9.Magazyn;

/**
 *
 * @author student
 */
public class PR_lab_9 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int LICZBA_PRODUCENTOW=3;
        int LICZBA_KONSUMENTOW=10;
        // TODO code application logic here
        Magazyn magazyn = new Magazyn();
        Producent producenci[]= new Producent[LICZBA_PRODUCENTOW];
        Konsument konsumenci[]= new Konsument[LICZBA_KONSUMENTOW];
        for(int i=0;i<LICZBA_PRODUCENTOW;i++){
          producenci[i] = new Producent(magazyn, i+1);
          producenci[i].start();
        }
        for(int i=0;i<LICZBA_KONSUMENTOW;i++){
          konsumenci[i] = new Konsument(magazyn,(i+1));
          konsumenci[i].start();
        }
        /* for(int i=0;i<LICZBA_PRODUCENTOW;i++){
          try{
             producenci[i].join();
          }
          catch(InterruptedException e) {
            System.out.println("Main thread Interrupted");
         }
        }
        for(int i=0;i<LICZBA_KONSUMENTOW;i++){
            try{
                konsumenci[i].join();
            }
            catch(InterruptedException e) {
                 System.out.println("Main thread Interrupted");
            }
        }*/
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(Lab9_rozpr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
