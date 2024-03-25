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
        this.pracownicy.add(a);
    }
    public void DodajDoBrygady(List<Pracownik> a){
        this.pracownicy.addAll(a);
    }

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }
    String k;
}
