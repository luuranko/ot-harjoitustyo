# Vaatimusmäärittely
### Sovelluksen tarkoitus
Maailmanluontisovelluksen tarkoituksena on auttaa itse luodun fiktiivisen maailman paikkojen ja hahmojen tietojen säilyttämisessä ja hallinnassa. Jokaisella käyttäjällä on oma maailmansa, johon voi lisätä kaupunkeja ja hahmoja ja muokata niiden tietoja.
### Käyttäjät
Sovelluksella on ainoastaan yksi käyttäjärooli, jossa pääsee käsiksi vain omaan maailmaan.
### Perusversion tarjoamat toiminnallisuudet
- Käyttäjätilin luonti
  - Ensimmäisessä näkymässä, kirjautumissivulla, on nappi toiseen näkymään, jossa voi luoda uuden käyttäjätilin.
  - Käyttäjä syöttää käyttäjänimen ja salasanan, joita hän käyttää kirjautumiseen.
- Kirjautuminen
  - Käyttäjä syöttää aiemmin luomansa käyttäjätilin käyttäjänimen ja salasanan, ja painettuaan kirjautumisnappia pääsee käyttäjäsivulleen
- Käyttäjäsivu
  - Käyttäjäsivulla on neljä nappia, jotka johtavat uusiin näkymiin: Kaupungit, Hahmot, Luo kaupunki, Luo hahmo
- Kaupunkihakemisto
  - Näkymä listaa käyttäjän luomat kaupungit nimen mukaan aakkosjärjestyksessä
  - Painamalla kaupungin nimeä pääsee kyseisen kaupungin sivulle
  - Hakemistosta pääsee takaisin käyttäjäsivulle painamalla takaisin-nappia
- Hahmohakemisto
  - Näkymä listaa käyttäjän luomat hahmot nimen mukaan aakkosjärjestyksessä
  - Painamalla hahmon nimeä pääsee kyseisen hahmon sivulle
  - Hakemistosta pääsee takaisin käyttäjäsivulle painamalla takaisin-nappia
- Kaupunginluonti
  - Sivu on tyhjä pohja uudelle kaupungille, ja kohtia voi muokata tai jättää tyhjäksi
  - Tyhjään pohjaan kuuluvat kaupungin nimi, kuvaus, väestö, hallinto, kulttuuri, maantiede ja muita
  - Alhaalla on nappi, joka tallentaa kaikki muutokset tyhjään pohjaan ja lisää kaupungin kaupunkien hakemistoon, mutta nappi ei toimi jos kaupungin nimi on jätetty tyhjäksi
  - Myös nappi, jolla pääsee takaisin käyttäjäsivulle ja muutoksia ei tallenneta
- Hahmonluonti
  - Sivu on tyhjä pohja uudelle hahmolle, ja kohtia voi muokata tai jättää tyhjäksi
  - Tyhjään pohjaan kuuluvat hahmon nimi, ulkonäön kuvaus, luonne, tavoite, pelko ja muita
  - Alhaalla on nappi, joka tallentaa kaikki muutokset tyhjään pohjaan ja lisää hahmon hahmohakemistoon, mutta nappi ei toimi jos hahmon nimi on jätetty tyhjäksi
  - Myös nappi, jolla pääsee takaisin käyttäjäsivulle ja muutoksia ei tallenneta
- Kaupunkisivu
  - Näyttää kaikki kaupungille syötetyt tiedot
  - Nappi takaisin hakemistoon
  - Nappi muokkaustilaan
- Hahmosivu
  - Näyttää kaikki hahmolle syötetyt tiedot
  - Nappi takaisin hakemistoon
  - Nappi muokkaustilaan
- Kaupunginmuokkaustila
  - Muuten sama kuin kaupunginluontinäkymä, mutta tyhjien kenttien sijaan sisältö kopioidaan kaupungin tiedoista, tallennusnappi päivittää tiedot kaupunkiin eikä luo uutta ja takaisin-nappi vie kaupunkisivulle käyttäjäsivun sijaan
- Hahmonmuokkaustila
  - Muuten sama kuin hahmonluontinäkymä, mutta tyhjien kenttien sijaan sisältö kopioidaan hahmon tiedoista, tallennusnappi päivittää hahmon tiedot eikä luo uutta ja takaisin-nappi vie hahmon sivulle käyttäjäsivun sijaan
### Jatkokehitysideoita
Jos aika sallii, ohjelmaan lisätään seuraavat toiminnallisuudet:
- Hahmojen ja kaupunkien poistaminen
- Yhteys hahmojen ja kaupunkien välille: kaupunkisivulle linkki listaan hahmoista, jotka asuvat kyseisessä kaupungissa
- Kaupunkihakemistossa kaupunkien järjestäminen väestön perusteella
- Sekä hahmon- että kaupunginluontiin/muokkaukseen erinäisille kohdille napit, jotka generoivat satunnaisen vastauksen tyhjään kenttään
- Toiminnallisuus, jossa voi kaupunkien tai hahmojen kuvauksissa/muissa kohdissa linkittää toisten hahmojen tai kaupunkien sivuille
- Rakennukset ja järjestöt, jotka voi linkittää hahmoihin ja kaupunkeihin
- Käyttäjänimen tai salasanan vaihtaminen
