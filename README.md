# Seminarska naloga za UVP1
![image](https://user-images.githubusercontent.com/71169333/164452151-1be739a8-f590-4c0c-8263-4d1fc9b4080d.png)


Program za Turistično agencijo, narejen v prog. jeziku Java ☕
Funkcinalnosti programa:
- Uporabniški vmesnik, kjer se lahko registrera uporabnika, prijavi navaden_uporabnik ali admin 
- Če se prijavi navaden_uporabnik ima na voljo funkcionalnosti, kot so: iskanje in rezervacija počitnic
- Če se prijavi admin ima na voljo vse funckionalnosti uporabnika + vse admin funkcionalnosti

## Namestiev
1. Odpreš ukazno vrstico in napišeš gh repo clone RokZ999/semiraskaUVP1 ali ročno preneseš v skupno poljubno imeanovano mapo naslednje datoteke: UporabniskiVmesnik.jar in uporabniki.txt pocitnice.txt
2. Zazenes RUN program.bat, ki v ozadju naredi naslednji korak, ki ga lahko izvedeš tudi sam 
-> Odpreš mapo v ukazni vrstici in napišeš ukaz: java -jar TuristicnaAgencijaCLI.jar

## Prevajnje kode/posodblanje in kreiranje JAR datoteke

Uporabi: UPDATE-PROGRAM.bat

ali ročno z ukazi v ukazni vrstici:

```
javac *.java
jar cvfm TuristicnaAgencijaCLI.jar manifest.txt *.class
java -jar TuristicnaAgencijaCLI.jar
```
