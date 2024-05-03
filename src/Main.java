import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){

        DzialPraco marketing = DzialPraco.CreateDzial("Marketing");
           //  DzialPraco dzial = new DzialPraco();
        //DzialPraco marketing2 = DzialPraco.CreateDzial("Marketing");

    Uzytkownik Franek = new Uzytkownik("Franek" , "Wytrych", LocalDate.of(2002,12,2), marketing,"Fran123","haslo123");
    Uzytkownik Tomasz = new Uzytkownik("Tomasz" , "Wons", LocalDate.of(2001,12,2), marketing,"tom123","haslo123");
//        System.out.println(Pracownik.listapracownikow);
//        Franek.setName("Zdzislaw");
//        Franek.setSurrname("Lens");
//        System.out.println(Franek);

    Brygadzista Oskar = new Brygadzista("Oskar","Tybur",LocalDate.of(2002,12,31), marketing,"Osk123","haslo123");
        Brygadzista Marek = new Brygadzista("Marek","Hans",LocalDate.of(2002,12,31), marketing,"mar123","haslo123");
    Brygada brygada = new Brygada("Alpha",Oskar);
    Brygada brygada2 = new Brygada("Beta",Oskar);
      //  System.out.println(Oskar.ListaBrygad);
//
//    brygada2.DodajDoBrygady(Marek);
//    brygada2.DodajDoBrygady(Pracownik.listapracownikow);
//    System.out.println(brygada2.getPracownicy());
//

    Praca p1 = new Praca(RodzajPracy.Ogolna , 5000, "Czyszczenie rur");
        Praca p2 = new Praca(RodzajPracy.Wymiana , 8000, "Wywoz smieci");
        Praca p3 = new Praca(RodzajPracy.Demontaz , 3000, "Zlew zepsuty");
        Praca p4 = new Praca(RodzajPracy.Montaz , 10000, "Szpachlowanie scian");

    List<Praca> praca = new ArrayList<>();
    praca.add(p1);
    praca.add(p2);
    List<Praca> praca2 = new ArrayList<>();
    praca2.add(p3);
    List<Praca> praca3 = new ArrayList<>();
    praca3.add(p4);

    Zlecenie zlecenie1 = new Zlecenie(true, brygada, praca2);
    Zlecenie zlecenie2 = new Zlecenie(true,brygada,praca3);
    Zlecenie zlecenie3 = new Zlecenie(false,brygada, praca);

//
//        System.out.println(zlecenie1);
//        System.out.println(p1);
////
//        System.out.println(Zlecenie.getMapa("#Z1"));
//        System.out.println(Praca.getmapa("#P1"));

        //System.out.println(Oskar.historiaZlecenBrygadzisty);

        Thread thread1 = new Thread(zlecenie3);
        Thread thread2 = new Thread(zlecenie2);
        Thread thread3 = new Thread(zlecenie1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}