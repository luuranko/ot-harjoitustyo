/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author halauri
 */
public class KassapaateTest {
    Kassapaate paate;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void luotuPaateOlemassa() {
        assertTrue(paate!=null);      
    }
    
    @Test
    public void alkuOikein() {
        boolean onko = true;
        if (paate.kassassaRahaa() != 100000) {
            onko = false;
        }
        if (paate.edullisiaLounaitaMyyty() != 0) {
            onko = false;
        }
        if (paate.maukkaitaLounaitaMyyty() != 0) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisOstoRiittaaRahaKasvaaEdu() {
        boolean onko = true;
        paate.syoEdullisesti(500);
        if (paate.kassassaRahaa() != 100000+240) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisOstoRiittaaVaihtorahaaOikeinEdu() {
        boolean onko = true;
        if (paate.syoEdullisesti(500) != 260) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    public void kateisOstoRiittaaRahaKasvaaMauk() {
        boolean onko = true;
        paate.syoEdullisesti(500);
        if (paate.kassassaRahaa() != 100000+400) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisOstoRiittaaVaihtorahaaOikeinMauk() {
        boolean onko = true;
        if (paate.syoMaukkaasti(500) != 100) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisOstoRiittaaLounasmaaraKasvaaEdu() {
        boolean onko = true;
        paate.syoEdullisesti(240);
        if (paate.edullisiaLounaitaMyyty() != 1) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisOstoRiittaaLounasmaaraKasvaaMauk() {
        boolean onko = true;
        paate.syoMaukkaasti(400);
        if (paate.maukkaitaLounaitaMyyty() != 1) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisEiRiitaRahaEiMuutuEdu() {
        boolean onko = true;
        paate.syoEdullisesti(200);
        if (paate.kassassaRahaa() > 100000) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisEiRiitaRahaEiMuutuMauk() {
        boolean onko = true;
        paate.syoMaukkaasti(200);
        if (paate.kassassaRahaa() > 100000) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisEiRiitaVaihtorahaTakaisinEdu() {
        boolean onko = true;
        if (paate.syoEdullisesti(200) != 200) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisEiRiitaVaihtorahaTakaisinMauk() {
        boolean onko = true;
        if (paate.syoMaukkaasti(200) != 200) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kateisEiRiitaMyydytLounaatEivatLisaannyEdu() {
        boolean onko = true;
        paate.syoEdullisesti(200);
        if (paate.edullisiaLounaitaMyyty() != 0) {
            onko = false;
        }
        assertTrue(onko);
    }
    @Test
    public void kateisEiRiitaMyydytLounaatEivatLisaannyMauk() {
        boolean onko = true;
        paate.syoMaukkaasti(200);
        if (paate.maukkaitaLounaitaMyyty() != 0) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void korttiRiittaaPalautusTrueEdu() {
        boolean onko = true;
        if (paate.syoEdullisesti(kortti)== false) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void korttiRiittaaPalautusTrueMauk() {
        boolean onko = true;
        if (paate.syoMaukkaasti(kortti)== false) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void korttiRiittaaLounaitaLisaaEdu() {
        boolean onko = true;
        paate.syoEdullisesti(kortti);
        if (paate.edullisiaLounaitaMyyty() != 1) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void korttiRiittaaLounaitaLisaaMauk() {
        boolean onko = true;
        paate.syoMaukkaasti(kortti);
        if (paate.maukkaitaLounaitaMyyty() != 1) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void korttiEiRiitaPalautusFalseEdu() {
        boolean onko = true;
        kortti.otaRahaa(800);
        if (paate.syoEdullisesti(kortti)==true) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void korttiEiRiitaPalautusFalseMauk() {
        boolean onko = true;
        kortti.otaRahaa(800);
        if (paate.syoMaukkaasti(kortti)==true) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void korttiEiRiitaLounaitaEiLisaaEdu() {
        boolean onko = true;
        kortti.otaRahaa(800);
        paate.syoEdullisesti(kortti);
        if (paate.edullisiaLounaitaMyyty()!=0) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void korttiEiRiitaLounaitaEiLisaaMauk() {
        boolean onko = true;
        kortti.otaRahaa(800);
        paate.syoMaukkaasti(kortti);
        if (paate.maukkaitaLounaitaMyyty()!=0) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kortillaOstoEiLisaaKassaanEdu() {
        boolean onko = true;
        paate.syoEdullisesti(kortti);
        if (paate.kassassaRahaa()!= 100000) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void kortillaOstoEiLisaaKassaanMauk() {
        boolean onko = true;
        paate.syoMaukkaasti(kortti);
        if (paate.kassassaRahaa()!= 100000) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void rahanLatausKassaKasvaa() {
        boolean onko = true;
        paate.lataaRahaaKortille(kortti, 100);
        if (paate.kassassaRahaa() != 100000+100) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void rahanLatausKorttiSaldoKasvaa() {
        boolean onko = true;
        paate.lataaRahaaKortille(kortti, 100);
        if (kortti.saldo()!= 1100) {
            onko = false;
        }
        assertTrue(onko);
    }
    
    @Test
    public void rahanLatausVaaraMaaraEiMuutosta() {
        boolean onko = true;
        paate.lataaRahaaKortille(kortti, -1);
        if (kortti.saldo()!=1000) {
            onko = false;
        }
        assertTrue(onko);
    }
}
