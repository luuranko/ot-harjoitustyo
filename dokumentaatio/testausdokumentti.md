# Testausdokumentti

### Automatisoidut testit

Automatisoiduissa testeissä testattiin vain pakkauksen maailmanluontisovellus.domain luokkia, eli sovelluslogiikkaa. Näistä tärkeimpiä ovat Logic-luokan testit, jotka testaavat luokkia Logic, User, Character ja Settlement. Luokille ja Character ja Settlement tehtiin yksikkötestejä testaamaan compareTo-metodeja ja muita metodeja, jotka eivät tulleet muiden luokkien testeissä käyttöön.

#### Testauskattavuus

Käyttöliittymän luokat jätettiin testikattavuudesta pois. Sovelluksen rivikattavuus on 96% ja haaraumakattavuus on 93%.

![Kuva testikattavuudesta](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/testikattavuus.png)

FileLogic-luokka jäi testaamatta, ja FileHandler-luokasta ne metodien haarat, jotka palauttaisivat null.

### Järjestelmätestaus

#### Asennus

Sovellusta on käytetty vain Linux-ympäristössä ja manuaalisella järjestelmätestauksella. 

### Sovellukseen jääneet laatuongelmat

Sovellus ei estä käyttäjää syöttämästä puolipisteitä sisältäviä tekstejä hahmojen tai asutusten kuvauksiin, vain nimiin, vaikka tämä voisi rikkoa ohjelman toiminnallisuuden.
