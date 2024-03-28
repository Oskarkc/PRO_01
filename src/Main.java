import java.util.ArrayList;
import java.util.List;

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
        brygada1.DodajDoBrygady(marcin);
        List<Pracownik> lista = new ArrayList<>();
        lista.add(fran);
        lista.add(kekw);
        brygada1.DodajDoBrygady(lista);
        System.out.println(brygada1.getPracownicy());
        System.out.println(ferdek.ListaBrygad);
        Zlecenie nowe = new Zlecenie<>(true);
       System.out.println(nowe.getDataUtworzenia());
    }

}