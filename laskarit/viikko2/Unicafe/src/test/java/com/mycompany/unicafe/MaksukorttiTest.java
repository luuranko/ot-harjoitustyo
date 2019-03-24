package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
    @Test
    public void vaheneekoSaldo() {
        kortti.otaRahaa(1);
        assertTrue(kortti.saldo() == 9);
    }
    
    public void vaheneekoSaldoTrue() {
        assertTrue(kortti.otaRahaa(1) == true);
    }
    
    public void vaheneekoSaldoFalse() {
        assertTrue(kortti.otaRahaa(11) == false);
    }
    
    @Test
    public void eiPidaMuuttua() {
        kortti.otaRahaa(11);
        assertTrue(kortti.saldo() == 10);
    }
    
    @Test
    public void alkusaldoOikein(){
        assertTrue(kortti.saldo()==10);
    }
    
    @Test
    public void rahaaLisaa() {
        kortti.lataaRahaa(10);
        assertTrue(kortti.saldo()==20);
    }
    
    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
}
