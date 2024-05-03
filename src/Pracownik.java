import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

abstract class Pracownik implements Comparable<Pracownik> {
    private static int counter =1;
    private int ID;
    private String name;
    private String surrname;
    private LocalDate birthdate;
    private DzialPraco dzial;
    static List<Pracownik> listapracownikow = new ArrayList<>();
    public Pracownik(String name, String surrname, LocalDate birth, DzialPraco dzial){
        this.ID = counter++;
        this.name=name;
        this.surrname=surrname;
        this.birthdate=birth;
        this.dzial=dzial;
        listapracownikow.add(this);
        dzial.getListaPracownikow().add(this);
    }

    @Override
    public String toString() {
        return this.name + " " + this.surrname+ " " + this.dzial;
    }

    public String getName() {
        return name;
    }

    public String getSurrname() {
        return surrname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurrname(String surrname) {
        this.surrname = surrname;
    }

    @Override
    public int compareTo(Pracownik o) {
        int imie = this.name.compareTo(o.name);
            if (imie != 0){
                return imie;
        }else{
            return this.birthdate.compareTo(o.birthdate);
        }
    }

    public int getID() {
        return ID;
    }
}
