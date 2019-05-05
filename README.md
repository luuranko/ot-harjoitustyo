# Ohjelmistotekniikka
## Maailmanluontisovellus
Maailmanluontisovelluksen avulla käyttäjä voi pitää kirjaa luomansa maailman hahmoista ja asutuksista. Jokaisella rekisteröityneellä käyttäjällä on oma itse luomansa valikoima hahmoja ja asutuksia, joita voi muokata tai luoda lisää.
### Dokumentaatio

[Käyttöohje](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/luuranko/ot-harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

## Releaset

[Lopullinen](https://github.com/luuranko/ot-harjoitustyo/releases/tag/viikko7)

[Viikko 6](https://github.com/luuranko/ot-harjoitustyo/releases/tag/viikko6)

[Viikko 5](https://github.com/luuranko/ot-harjoitustyo/releases/tag/viikko5)

## Komentorivitoiminnot

Testien suoritus: `mvn test`

Testikattavuusraportin luominen: `mvn jacoco:report`

Suoritettavan jarin generointi: `mvn package`

Checkstyle-raportin luominen: `mvn jxr:jxr checkstyle:checkstyle`

Ohjelman suorittaminen: `java -jar maailmanluontisovellus.jar`

Javadocin generointi: `mvn javadoc:javadoc`
