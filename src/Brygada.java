import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Brygada implements Serializable {
    String nazwa;
    Brygadzista brygadzista;
    List<Pracownik> pracownicy = new ArrayList<>();
    static List<Brygada> brygady = new ArrayList<>();

    public Brygada() {
        readFromFile();
    }

    public Brygada(String nazwa, Brygadzista brygadzista) {
        this.nazwa = nazwa;
        this.brygadzista = brygadzista;
        brygady.add(this);
        brygadzista.ListaBrygad.add(this.nazwa);
        saveToFile();
    }
    public void DodajDoBrygady(Pracownik a){

            this.pracownicy.add(a);
            System.out.println("Pomyslnie dodano " + a + " do brygadt");

    }
    public void DodajDoBrygady(List<Pracownik> a){
        if(a.stream().anyMatch(e -> e.getClass().equals(Uzytkownik.class))){
            System.out.println("Nie mozna dodac listy pracownikow do brygady, w liscie znajduje obiekt klasy Uzytkownik!");
        }else {
            this.pracownicy.addAll(a);
            System.out.println("Pomyslnie dodano liste pracownikow");
        }
    }

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    @Override
    public String toString() {
        return this.nazwa + " " + this.brygadzista;
    }
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFileName()))) {
            oos.writeObject(brygady);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String getFileName() {
        return "C:\\Users\\oskik\\IdeaProjects\\PRO_01\\src\\brygadybaza.bin";
    }
    private void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFileName()))) {
            this.brygady = (List<Brygada>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.brygady = new ArrayList<>();
        }catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
