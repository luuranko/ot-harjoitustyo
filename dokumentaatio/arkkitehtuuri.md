# Arkkitehtuurikuvaus

### Rakenne

Ohjelmassa on kaksi pakkausta: *maailmanluontisovellus.domain* ja *maailmanluontisovellus.ui*

*maailmanluontisovellus.domain*-pakkaus käsittelee sovelluslogiikan, ja *maailmanluontisovellus.ui* käsittelee JavaFX:llä tehdyn graafisen käyttöliittymän luomisen. Domain-pakkaus sisältää myös FileHandler-luokan, joka huolehtii pysyväistallennuksesta tiedostoihin.

### Käyttöliittymä

Sovelluksen näkymät:
- kirjautumissivu
- uuden käyttäjän luomissivu
- pääsivu
- hahmonluomissivu
- asutuksenluomissivu
- hahmovalikko
- asutusvalikko
- hahmosivu
- asutussivu
- hahmonmuokkaussivu
- asutuksenmuokkaussivu

Näkymät on toteutettu luokan *UserInterface* metodeina, jotka "vuorottelevat" stagella. Näkymämetodit kutsuvat toisiaan ja siten vaihtavat näkymää, kun napinpainalluksesta kuuluu seurata näkymänvaihdos. Metodit kutsuvat sovelluslogiikan luokkia tietoa muokatessa ja hakiessa. 

### Sovelluslogiikka

Sovelluslogiikkaan kuuluvat luokat *Logic*, *User*, *Character*, *Settlement*, *FileHandler*, *FileLogic* ja *RandomGenerator*.

Luokka *User* kuvaa käyttäjää. Käyttäjällä on sisäiset listat, joihin voi lisätä *Character*- ja *Settlement*-olioita.

Luokka *RandomGenerator* vastaa satunnaisten piirteiden luomisesta, ja sen metodit palauttavat String-muotoisia vastauksia.

Luokka *Logic* vastaa yleisestä sovelluslogiikasta. Sen metodit liittyvät sovelluksen toiminnallisuuksien toteuttamiseen sisäisessä muistissa.

Luokka *FileHandler* vastaa tiedostojen luomisesta, lukemisesta ja niihin kirjoittamisesta.

Luokka *FileLogic* luo yhteyden luokkien *Logic* ja *FileHandler* välille. Se vastaa siitä, että sovelluksen käynnistyessä tiedostoista luetaan niiden tiedot ja ne välitetään sisäiselle muistille eli luokalle *Logic*. Kun sovellus sammutetaan oikeaoppisesti, se siirtää sisäisen muistin tiedot luokalle *FileHandler*, joka kirjoittaa ne tiedostoihin, siten tallentaen tiedot pysyväismuistiin.

### Tiedostot

Sovellus tallentaa käyttäjät tiedostoon *userlist.txt*, hahmot tiedostoon *charalist.txt* ja asutukset tiedostoon *settlelist.txt*.

Käyttäjät tallennetaan muodossa `käyttäjänimi;salasana;id`:

```
Lauri;juusto;0
Sammakko;lammikko;1
```

Hahmot tallennetaan muodossa `käyttäjänimi;id;nimi;ulkonäkö;luonne;tavoite;kyvyt;heikkous;`:

```
Lauri;0;Pelle;fit and grey;mischievous and greedy;fulfilling a destiny;crafting and spiritual powers;gullible
Lauri;1;Pöllö;petite and teal;nosy and quiet;knowledge;navigation and martial arts;overconfident
```

Asutukset tallennetaan muodossa `käyttäjänimi;id;nimi;kuvaus;väestö;hallinto;kulttuuri;maantiede`:

```
Lauri;0;Laavavaara; ; ; ; ; 
Lauri;1;Pönde;used to be a military fortress;village;the strongest warrior;peaceful;on an island
Lauri;2;Sivistys;ancient;diverse;a mage;closed-off;next to a lake
```

### Sovelluksen puutteet ja ongelmat

- Käyttöliittymä on suoritettu vain yhdessä luokassa, ja näkymänluomismetodeissa on paljon toistoa
- Sovellus ei estä käyttäjää syöttämästä puolipisteitä hahmojen tai asutusten kuvauskenttiin, vaikka tämä rikkoo sovelluksen toiminnallisuutta
