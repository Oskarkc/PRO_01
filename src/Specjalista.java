import java.time.LocalDate;
import java.util.Date;

public class Specjalista extends Pracownik{
    private String specjalizacja;
    public Specjalista(String name, String surrname, LocalDate birth, DzialPraco dzial, String specka) {
        super(name, surrname, birth, dzial);
        this.specjalizacja=specka;
        listapracownikow.add(this);
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.specjalizacja;
    }

    @Override
    public int getID() {
        return super.getID();
    }
}
