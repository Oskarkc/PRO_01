import javax.swing.*;
import java.io.*;
import java.util.*;

public class DzialPraco implements Comparable<DzialPraco>,Serializable {
    private String nazwa;
    private static List<String> dzialy=new ArrayList<>();
    public static List<DzialPraco> dzialy2=new ArrayList<>();
    private List<Pracownik> listaPracownikow;
    public DzialPraco() {
        readFromFile();
    }
    private DzialPraco(String nazwa) throws NotUniqueNameException{
        if(Isnameunique(nazwa)) throw new NotUniqueNameException();
        this.nazwa=nazwa;
        dzialy.add(nazwa);
        dzialy2.add(this);
        Collections.sort(dzialy2);
        listaPracownikow=new ArrayList<>();
        System.out.println("Dzial stworzony pomyslnie");
        saveToFile();
    }
    public static DzialPraco CreateDzial(String nazwa){
        return new DzialPraco(nazwa);
    }
    public static boolean Isnameunique(String nazwa){
        for (int i = 0; i < dzialy.size(); i++) {
            if(dzialy.get(i).equals(nazwa)){
                return true;
            }
        }
        return false;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public static List<String> getDzialy() {
        return dzialy;
    }
    public int compareTo(DzialPraco o) {
        return this.nazwa.compareTo(o.nazwa);
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    private  void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFileName()))) {
            oos.writeObject(dzialy2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String getFileName() {
        return "C:\\Users\\oskik\\IdeaProjects\\PRO_01\\src\\dzialybaza.bin";
    }
    private void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFileName()))) {
            this.dzialy2 = (List<DzialPraco>) ois.readObject();
            this.dzialy.clear();
            for (DzialPraco dzial : dzialy2) {
                dzialy.add(dzial.getNazwa());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            dzialy2 = new ArrayList<>();
        }catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
