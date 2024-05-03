import java.util.ArrayList;
import java.util.List;

public class Brygada {
    String nazwa;
    Brygadzista brygadzista;
    List<Pracownik> pracownicy = new ArrayList<>();

    public Brygada(String nazwa, Brygadzista brygadzista) {
        this.nazwa = nazwa;
        this.brygadzista = brygadzista;
        brygadzista.ListaBrygad.add(this.nazwa);
    }
    public void DodajDoBrygady(Pracownik a){
        if(a.getClass().equals(Uzytkownik.class)){
            System.out.println("Nie mozna dodac "+a+" do brygady");
        }else {
            this.pracownicy.add(a);
            System.out.println("Pomyslnie dodano " + a + " do brygadt");
        }
    }
    public void DodajDoBrygady(List<Pracownik> a){
        if(a.stream().anyMatch(e -> e.getClass().equals(Uzytkownik.class))){
            System.out.println("Nie mozna dodac listy pracownikow do brygady, w liscie znajduje obiekt klasy Uzytkownik!");
        }else {
            this.pracownicy.addAll(a);
            System.out.println("Pomyslnie dodano liste pracownikow");
        }
    }

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    @Override
    public String toString() {
        return this.nazwa + " " + this.brygadzista;
    }
}
