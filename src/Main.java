import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     DzialPraco nowy = DzialPraco.CreateDzial("nazwa");
        DzialPraco nowy1 = DzialPraco.CreateDzial("nazwa1");
        Uzytkownik marcin = new Uzytkownik("Marcin","Bonk","31.12.2002",nowy,"maciek123","maciek123");
        Uzytkownik fran = new Uzytkownik("fran","Bonk","31.12.2002",nowy,"maciek123","maciek123");
        Uzytkownik kekw = new Uzytkownik("kekw","Bonk","31.12.2002",nowy,"maciek123","maciek123");
        Brygadzista ferdek = new Brygadzista("Franek","bogadnowicz","31.12.2002",nowy,"siemano","siemano");
        Brygada brygada1 = new Brygada("Alpha",ferdek);
        brygada1.DodajDoBrygady(ferdek);
        List<Pracownik> lista = new ArrayList<>();
        lista.add(fran);
        lista.add(kekw);
        brygada1.DodajDoBrygady(lista);
        System.out.println(brygada1.getPracownicy());
        System.out.println(ferdek.ListaBrygad);
        Zlecenie nowe = new Zlecenie(true);
       System.out.println(nowe.getDataUtworzenia());
        System.out.println(nowy.getListaPracownikow());
        System.out.println(Pracownik.listapracownikow);
        nowe.dodajbrygade(brygada1);
        nowe.dodajbrygade(brygada1);
        Praca p = new Praca(RodzajPracy.Ogolna, 10000, "naprawic rury");
        Praca b = new Praca(RodzajPracy.Ogolna, 6000, "naprawic rury");
        Praca c = new Praca(RodzajPracy.Ogolna, 7000, "naprawic rury");
        List<Praca> a = new ArrayList<>();
        a.add(p);
        a.add(b);
        a.add(c);
        Zlecenie z = new Zlecenie(true,brygada1);
        Thread thread = new Thread(z);
        thread.start();
    }

}