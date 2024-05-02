import java.util.Date;

public class Uzytkownik extends Pracownik{
    private String login;
    private String haslo;
    private String Init="";
    public Uzytkownik(String name, String surrname, String birth, DzialPraco dzial,String login, String haslo) {
        super(name, surrname, birth, dzial);
        this.login=login;
        this.haslo=haslo;
        this.Init+=name.charAt(0);
        this.Init+=surrname.charAt(0);
    }

    @Override
    public String toString() {
        return super.toString()+ " " + this.Init;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        this.Init="";
        this.Init+=name.charAt(0);
        this.Init+=getSurrname().charAt(0);
    }

    @Override
    public void setSurrname(String surrname) {
        super.setSurrname(surrname);
        this.Init="";
        this.Init+=getName().charAt(0);
        this.Init+=surrname.charAt(0);
    }

    public String getInit() {
        return (String)Init;
    }
}
