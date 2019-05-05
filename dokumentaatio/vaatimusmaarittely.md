# Vaatimusmäärittely
### Sovelluksen tarkoitus
Maailmanluontisovelluksen tarkoituksena on auttaa itse luodun fiktiivisen maailman asutusten ja hahmojen tietojen säilyttämisessä ja hallinnassa. Jokaisella käyttäjällä on oma maailmansa, johon voi lisätä kaupunkeja ja hahmoja ja muokata niiden tietoja.
### Käyttäjät
Sovelluksella on ainoastaan yksi käyttäjärooli, jossa pääsee käsiksi vain omaan maailmaan.
### Perusversion tarjoamat toiminnallisuudet
- Käyttäjätilin luonti
  - Ensimmäisessä näkymässä, kirjautumissivulla, on nappi toiseen näkymään, jossa voi luoda uuden käyttäjätilin.
  - Käyttäjä syöttää käyttäjänimen ja salasanan, joita hän käyttää kirjautumiseen.
  - Käyttäjänimen ja salasanan pitää kummankin olla alle 21 merkkiä, eivätkä ne saa olla tyhjiä tai sisältää puolipisteitä
- Kirjautumissivu
  - Käyttäjä syöttää aiemmin luomansa käyttäjätilin käyttäjänimen ja salasanan, ja painettuaan kirjautumisnappia pääsee käyttäjäsivulleen
- Pääsivu
  - Käyttäjäsivulla on neljä nappia, jotka johtavat uusiin näkymiin:
  - *New character* -> hahmonluontisivu
  - *New settlement* -> asutuksenluontisivu
  - *Your characters* -> hahmovalikko
  - *Your settlements* -> asutusvalikko
- Asutusvalikko
  - Näkymä listaa käyttäjän luomat asutukset nimen mukaan aakkosjärjestyksessä
  - Painamalla asutuksen nimeä pääsee kyseisen asutuksen sivulle
  - Valikosta pääsee takaisin pääsivulle painamalla *Return*-nappia
- Hahmovalikko
  - Näkymä listaa käyttäjän luomat hahmot nimen mukaan aakkosjärjestyksessä
  - Painamalla hahmon nimeä pääsee kyseisen hahmon sivulle
  - Valikosta pääsee takaisin pääsivulle painamalla *Return*-nappia
- Asutuksenluonti
  - Sivu on tyhjä pohja uudelle asutukselle, ja kohtia voi muokata tai jättää tyhjäksi
  - Tyhjään pohjaan kuuluvat asutuksen nimi (Name), kuvaus (Description), väestö (Population), hallinto (Government), kulttuuri (Culture) ja maantiede (Geography)
  - Jokaisen tekstikentän vieressä on *Random*-nappi, joka tuottaa satunnaisesti generoidun kuvauksen kenttään
  - *Save*-nappi, joka tallentaa kaikki muutokset tyhjään pohjaan ja lisää asutuksen asutusvalikkoon, mutta nappi ei toimi jos asutuksen nimi on jätetty tyhjäksi tai jos käyttäjällä on jo sen niminen asutus
  - *Return*-nappi, jolla pääsee takaisin pääsivulle ja muutoksia ei tallenneta
- Hahmonluonti
  - Sivu on tyhjä pohja uudelle hahmolle, ja kohtia voi muokata tai jättää tyhjäksi
  - Tyhjään pohjaan kuuluvat hahmon nimi (Name), ulkonäkö (Appearance), luonne (Personality), tavoite (Goal), kyvyt (Ability) ja heikkous (Weakness)
  - *Save*-nappi, joka tallentaa kaikki muutokset tyhjään pohjaan ja lisää hahmon hahmovalikkoon, mutta nappi ei toimi jos hahmon nimi on jätetty tyhjäksi tai jollain toisella käyttäjän hahmolla on sama nimi
  - *Return*-nappi, jolla pääsee takaisin pääsivulle ja muutoksia ei tallenneta
- Asutussivu
  - Näyttää kaikki kaupungille syötetyt tiedot
  - *Return*-nappi vie takaisin asutusvalikkoon
  - *Modify*-nappi vie asutuksenmuokkaustilaan
- Hahmosivu
  - Näyttää kaikki hahmolle syötetyt tiedot
  - *Return*-nappi vie takaisin hahmovalikkoon
  - *Modify*-nappi vie hahmonmuokkaustilaan
- Asutuksenmuokkaustila
  - Muuten sama kuin asutuksenluontinäkymä, mutta tyhjien kenttien sijaan sisältö kopioidaan asutuksen tiedoista, *Save*-nappi päivittää tiedot kaupunkiin eikä luo uutta ja *Return*-nappi vie asutussivulle pääsivun sijaan
- Hahmonmuokkaustila
  - Muuten sama kuin hahmonluontinäkymä, mutta tyhjien kenttien sijaan sisältö kopioidaan hahmon tiedoista, *Save*-nappi päivittää hahmon tiedot eikä luo uutta ja *Return*-nappi vie hahmon sivulle käyttäjäsivun sijaan

### Jatkokehitysideoita

Alkuperäisistä jatkokehitysideoista ehdittiin toteuttaa satunnaisgeneraattoritoiminto.

- mahdollisuus poistaa hahmoja tai asutuksia
- yhteys hahmojen ja asutusten välille niin, että tiedetään mitkä hahmot asuvat missäkin asutuksessa
