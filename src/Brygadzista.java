import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Brygadzista extends Uzytkownik{
    List<String> ListaBrygad = new ArrayList<>();
    List<Zlecenie> historiaZlecenBrygadzisty = new ArrayList<>();

    public Brygadzista() {
        super();
    }

    public Brygadzista(String name, String surrname, String birth, DzialPraco dzial, String login, String haslo) {
        super(name, surrname, birth, dzial, login, haslo);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public void jakabrygada(Brygadzista b){
        System.out.println(b.ListaBrygad);
    }

}
