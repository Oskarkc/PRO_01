import java.io.*;
import java.util.*;

abstract class Pracownik implements Comparable<Pracownik>, Serializable {
    private logowanie log;
    private String name;
    private String surrname;
    private String birthdate;
    private DzialPraco dzial;
    static List<Pracownik> listapracownikow = new ArrayList<>();

    public Pracownik(){

    }

    public Pracownik(String name, String surrname, String birth, DzialPraco dzial) {
        this.name = name;
        this.surrname = surrname;
        this.birthdate = birth;
        this.dzial = dzial;
        listapracownikow.add(this);
        Collections.sort(listapracownikow);
        dzial.getListaPracownikow().add(this);
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

    public static boolean znajdzUzytkownika(String login, String password) {
        for (Pracownik pracownik : listapracownikow) {
            if (pracownik instanceof Uzytkownik)
                if (((Uzytkownik) pracownik).getLogin().equals(login) &&
                        ((Uzytkownik) pracownik).getHaslo().equals(password)) {
                    logowanie.setPracownik(pracownik);
                    return true;
                }
            if (pracownik instanceof Brygadzista)
                if (((Brygadzista) pracownik).getLogin().equals(login) &&
                        ((Brygadzista) pracownik).getHaslo().equals(password)) {
                    logowanie.setPracownik(pracownik);
                    return true;
                }
        }
        return false;
    }

    @Override
    public int compareTo(Pracownik o) {
        return this.name.compareTo(o.name);
    }

    public static String isInstanceofUzytkownik(Pracownik pracownik) {
        if (pracownik instanceof Uzytkownik) {
            return "Uzytkownik";
        } else
            return "Brygadzista";
    }

    public void setDzial(DzialPraco dzial) {
        this.dzial = dzial;
    }
}
