import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Uzytkownik extends Pracownik implements Serializable {
    private String login;
    private String haslo;
    private String Init="";

    public Uzytkownik(){
        readFromFile();
    }

    public Uzytkownik(String name, String surrname, String birth, DzialPraco dzial,String login, String haslo) {
        super(name, surrname, birth, dzial);
        this.login=login;
        this.haslo=haslo;
        this.Init+=name.charAt(0);
        this.Init+=surrname.charAt(0);
        saveToFile();
    }

    @Override
    public String toString() {
        return super.toString();
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

    public String getLogin() {
        return login;
    }
    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFileName()))) {
            oos.writeObject(listapracownikow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFileName()))) {
            this.listapracownikow = (List<Pracownik>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            listapracownikow = new ArrayList<>();
        }catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static String getFileName() {
        return "C:\\Users\\oskik\\IdeaProjects\\PRO_01\\src\\pracownicybaza.bin";
    }
}
