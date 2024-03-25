import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

abstract class Pracownik{
    private String name;
    private String surrname;
    private String birthdate;
    private DzialPraco dzial;
    static List<Pracownik> listapracownikow = new ArrayList<>();
    public Pracownik(String name, String surrname, String birth, DzialPraco dzial){
        this.name=name;
        this.surrname=surrname;
        this.birthdate=birth;
        this.dzial=dzial;
        listapracownikow.add(this);
    }

    @Override
    public String toString() {
        return this.name + " " + this.surrname;
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
}
