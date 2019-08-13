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
public class Konsument extends Thread {
    Magazyn magazyn;
    Typ typ;
    int MAX_KONSUMENTA=50;
    int numerKonsumenta;
    Random generator = new Random();
    
    public Konsument(Magazyn mag, int numer){
        this.numerKonsumenta=numer;
        this.magazyn=mag;
        typ = new Typ();
    }
    
    public void run () {
        int index=0;
        int ilosc=0;
        int ileCzekam=0;
        while(true){
            if(ilosc==0){
                index = typ.losuj();
                ilosc = generator.nextInt(MAX_KONSUMENTA)+1;
                System.out.println("Konsument o numerze "+Integer.toString(numerKonsumenta)+" zlozyl zamowienie na "+typ.nazwy[index]);
                ilosc=ilosc-magazyn.pobierz(index,ilosc);
                System.out.println("Konsumentowi o numerze "+Integer.toString(numerKonsumenta)+" zostalo do odebrania"+Integer.toString(ilosc));
            }
            else{
                ilosc=ilosc-magazyn.pobierz(index,ilosc);
                System.out.println("Konsumentowi o numerze "+Integer.toString(numerKonsumenta)+" zostalo do odebrania"+Integer.toString(ilosc));
                ileCzekam++;
            }
            if(ilosc==0){
                System.out.println("Konsument o numerze "+Integer.toString(numerKonsumenta)+" pobrał cale zamowienie");
                ileCzekam=0;
            }
            if(ileCzekam==3){
                 System.out.println("Konsument o numerze "+Integer.toString(numerKonsumenta)+" nie doczekał się odbioru całego zamówienia ");
                 ileCzekam=0;
                 ilosc=0;
            }
             try {
                sleep(generator.nextInt(500));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
