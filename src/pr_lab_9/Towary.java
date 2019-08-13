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
public class Towary {
    int ilosc;
    int numer;
    public Towary(int index){
        this.ilosc=0;
        this.numer=index;
    }
    public int zwieksz(int ile){
        ilosc= ilosc +ile;
        return this.ilosc;
    }
    public int zmniejsz(int ile){
        ilosc=ilosc - ile;
        return this.ilosc;
    }
}
