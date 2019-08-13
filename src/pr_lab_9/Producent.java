/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr_lab_9;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Producent extends Thread {
    Magazyn magazyn;
    int numerProducenta;
    Typ typ = new Typ();
    int MAX_PRODUCENTA=199;
    Random generator = new Random();
    
    public Producent(Magazyn mag, int numer){
        this.magazyn=mag;
        this.numerProducenta= numer;
    }
    
    public void run() {
        int pom=0;
        int index=0;
        int ilosc=0;
        int ileCzekam=0;
        while(true){
            if(ilosc==0){
                index = typ.losuj();
                ilosc = generator.nextInt(MAX_PRODUCENTA)+1;
                System.out.println("Producent o numerze "+Integer.toString(numerProducenta)+" wyprodukował "+Integer.toString(ilosc)+" "+typ.nazwy[index]);
                ilosc=ilosc-magazyn.dodaj(index,ilosc);
                System.out.println("Producentowi o numerze "+Integer.toString(numerProducenta)+" zostalo do dostarczenia "+Integer.toString(ilosc));
            }
            else{
                ilosc=ilosc-magazyn.dodaj(index,ilosc);
                System.out.println("Producentowi o numerze "+Integer.toString(numerProducenta)+" zostalo do dostarczenia "+Integer.toString(ilosc));
                ileCzekam++;
            }
            if(ilosc==0){
                System.out.println("Producent o numerze "+Integer.toString(numerProducenta)+" dostarczyl cale zamowienie ");
                ileCzekam=0;
            }
            if(ileCzekam ==3){
                System.out.println("Producent o numerze "+Integer.toString(numerProducenta)+" nie doczekał się dostarczenia całego zamówienia ");
                ileCzekam=0;
                ilosc=0;
            }
            pom++;
            if(pom==5){
                magazyn.wyswietl();
                pom=0;
            }
             try {
                sleep(generator.nextInt(500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
