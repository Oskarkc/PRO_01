import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Brygadzista extends Uzytkownik{
    List<String> ListaBrygad = new ArrayList<>();

    public Brygadzista(String name, String surrname, String birth, DzialPraco dzial, String login, String haslo) {
        super(name, surrname, birth, dzial, login, haslo);
        listapracownikow.add(this);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
