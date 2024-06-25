import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class s31581 {
    public static void main(String[] args) {
        DzialPraco baza = new DzialPraco();
        Uzytkownik bazaa = new Uzytkownik();
        Brygada bazabry = new Brygada();
        Zlecenie bazazlecenie = new Zlecenie();
        DzialPraco jeden = DzialPraco.CreateDzial("jfasfsy");
        Brygadzista brygadzista = new Brygadzista("witold","fajranek","31.12.2002",jeden,"witam","halo");
        Uzytkownik uzytkownik = new Uzytkownik("franek","Danonek","31.12.2002",jeden,"witam","halo");
        Brygada brygada = new Brygada("brygada",brygadzista);
        brygada.DodajDoBrygady(uzytkownik);
        brygada.DodajDoBrygady(uzytkownik);


        List<Praca> prace = new ArrayList<>();
        Praca praca = new Praca(RodzajPracy.Ogolna,3,"szybka");
        Praca praca2 = new Praca(RodzajPracy.Ogolna,2,"qucik");
        prace.add(praca);
        prace.add(praca2);
        Zlecenie zlecenie = new Zlecenie(true,prace);

        new logowanie();
    }
}