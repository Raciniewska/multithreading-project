/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr_lab_9;

/**
 *
 * @author student
 */
public class Magazyn {
    
    int POJEMNOSC_SZAFKI = 600;
    Towary towary[];
    Typ typy;
    
    public Magazyn(){
        typy= new Typ();
        towary =new Towary[typy.iloscTypow];
        for(int i=0;i<typy.iloscTypow;i++){
            towary[i]=new Towary(i);
        }
    }
    //zwraca ile udało sie pobrać
    public synchronized int pobierz(int index, int ile){
        if(ile<=towary[index].ilosc){
            towary[index].zmniejsz(ile);
            return ile;
        }
        else{
            int ileJestNaStanie=towary[index].ilosc;
            towary[index].zmniejsz(ileJestNaStanie);
            return ileJestNaStanie;
        }
    }
    
    //zwraca ile udało sie dodac
    public synchronized int dodaj(int index, int ile){
        int ileJestNaStanie=towary[index].ilosc;
        int ileMoznaAktualnieDodac = POJEMNOSC_SZAFKI-ileJestNaStanie;
        if(ileMoznaAktualnieDodac>=ile){
           towary[index].zwieksz(ile);
            return ile; 
        }
        else{
            towary[index].zwieksz(ileMoznaAktualnieDodac);
            return ileMoznaAktualnieDodac;
        }
    }
    public synchronized void wyswietl(){
        System.out.println("sklad magazynu");
        for(int i=0;i<typy.iloscTypow;i++){
            System.out.println("Polka : "+typy.nazwy[towary[i].numer]+" ma ilosc: "+Integer.toString(towary[i].ilosc));
        }
    }
}
