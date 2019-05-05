## Käyttöohje
### Käytön aloitus
Lataa releasesta tiedosto *maailmanluontisovellus.jar*

Lataa tai luo itse tiedosto *config.properties* ja varmista, että sen sisältö on seuraava:
```
userlist.txt=userlist.txt
charalist.txt=charalist.txt
settlelist.txt=settlelist.txt
```

Varmista, että jar-tiedosto ja *config.properties* ovat samassa hakemistossa, esimerkiksi Downloads-kansiossa.

Käynnistä ohjelma kyseisestä kansiosta komentorivillä komennolla `java -jar maailmanluontisovellus.jar`

### Kirjautuminen

![Kuva kirjautumissivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/kirjautumissivu.png)

Kirjautumissivulla voi syöttää käyttäjätunnuksensa ja salasanansa ja painaa *Login*-nappia kirjautuakseen sisään.

Onnistunut kirjautuminen vie pääsivulle.

Uuden käyttäjän luomiseen pääsee painamalla nappia *Create a new account*.

Huom! Ohjelman oikeaoppinen sulkeminen tapahtuu painamalla *Exit*-nappia. Yläruksin painaminen ei tallenna tietoja.

### Uuden käyttäjän luominen

![Kuva käyttäjänluontisivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/kayttajanluontisivu.png)

Käyttäjänluomissivulla voi syöttää käyttäjätunnuksen ja salasanan ja painaa *create account*-nappia luodakseen käyttäjän.

Käyttäjän luonti ei onnistu, jos käyttäjänimi tai salasana ovat tyhjiä, sisältävät puolipisteitä, tai ovat liian pitkiä.

Onnistunut käyttäjänluonti vie takaisin kirjautumissivulle.

### Pääsivu

![Kuva pääsivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/paasivu.png)

Pääsivulta on pääsy ohjelman toimintoihin.

*New character*-nappi vie hahmonluontisivulle.

*New settlement*-nappi vie asutuksenluontisivulle.

*Your characters*-nappi vie hahmovalikkosivulle.

*Your settlements*-nappi vie asutusvalikkosivulle.

*Logout*-nappi kirjaa käyttäjän ulos ja vie takaisin kirjautumissivulle.

### Hahmonluontisivu

![Kuva hahmonluontisivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/hahmonluontisivu.png)

Hahmonluontisivulla voi täyttää tekstikenttiin hahmon tietoja. Vain ylimpänä oleva nimikenttä on pakollinen hahmon luomista varten, muut saa jättää tyhjäksi. Nimi ei kuitenkaan saa olla sama kuin aiemmalla hahmolla.

Halutessaan voi painaa *Random*-nappeja ja saada kunkin vieressä olevaan tekstikenttään satunnaisesti generoidun kuvauksen.

*Save*-nappi luo ja tallentaa uuden hahmon, jos nimi on sallittu.

*Return*-nappi vie takaisin pääsivulle tallentamatta mitään muutoksia.

### Asutuksenluontisivu

![Kuva asutuksenluontisivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/asutuksenluontisivu.png)

Asutuksenluontisivulla voi täyttää tekstikenttiin asutuksen tietoja. Vain ylimpänä oleva nimikenttä on pakollinen asutuksen luontia varten. Nimi ei kuitenkaan saa olla sama kuin jollain aikaisemmalla asutuksella.

*Random*-nappien painaminen tuottaa satunnaisen vastauksen sen vieressä olevaan kenttään.

*Save*-nappi luo ja tallentaa asutuksen, jos nimi on sallittu.

*Return*-nappi vie takaisin pääsivulle tallentamatta mitään muutoksia.

### Hahmovalikkosivu

![Kuva hahmovalikkosivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/hahmovalikkosivu.png)

Hahmovalikkosivulla on vierityspalkki, joka näyttää kaikki käyttäjän luomat hahmot aakkosjärjestyksessä.

Hahmon nimeä painamalla pääsee sen hahmosivulle.

*Return*-nappi vie takaisin pääsivulle.

### Hahmosivu

![Kuva hahmosivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/hahmosivu.png)

Hahmosivulla näkyvät kaikki hahmolle syötetyt tiedot.

*Modify*-nappi vie hahmonmuokkaussivulle.

*Return*-nappi vie takaisin hahmovalikkosivulle.

### Hahmonmuokkaussivu

![Kuva hahmonmuokkaussivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/hahmonmuokkaussivu.png)

Hahmonmuokkaussivulla voi täyttää ja tyhjentää hahmon tietoja samalla tavalla kuin hahmonluonnissa.

*Save*-nappi tallentaa muutokset ja vie takaisin hahmosivulle.

*Return*-nappi vie takaisin hahmosivulle tallentamatta muutoksia.

### Asutusvalikkosivu

![Kuva asutusvalikkosivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/asutusvalikkosivu.png)

Asutusvalikkosivulla on vierityspalkki, joka näyttää kaikki käyttäjän luomat asutukset aakkosjärjestyksessä.

Asutuksen nimeä painamalla pääsee sen asutussivulle.

*Return*-nappi vie takaisin pääsivulle.

### Asutussivu

![Kuva asutussivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/asutussivu.png)

Asutussivulla näkyvät kaikki asutuksen tiedot.

*Modify*-nappi vie asutuksenmuokkaussivulle.

*Return*-nappi vie takaisin asutusvalikkosivulle.

### Asutuksenmuokkaussivu

![Kuva asutuksenmuokkaussivusta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/asutuksenmuokkaussivu.png)

Asutuksenmuokkaussivulla voi täyttää ja tyhjentää asutuksen tietoja yhtä lailla kuin asutuksenluonnissa.

*Save*-nappi tallentaa muutokset ja vie takaisin asutussivulle.

*Return*-nappi vie takaisin asutussivulle tallentamatta muutoksia.
