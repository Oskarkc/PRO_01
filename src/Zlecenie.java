import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class Zlecenie implements Runnable, Serializable {
    private static int zlecenie = 1;
    private String numerzlecenia;
    private Status currentstatus;
    private LocalDateTime DataUtworzenia;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;
    private Rodzajzlecenia IsPlanned;
    private Brygada brygada;
    public List<Praca> prace;
    static List<Zlecenie> zlecenia = new ArrayList<>();

    public Zlecenie() {
        readFromFile();
    }

    public Zlecenie(boolean IsPlanned) {
        this.currentstatus = Status.UTWORZONE;
        this.DataUtworzenia = LocalDateTime.now();
        this.IsPlanned = IsPlanned ? Rodzajzlecenia.PLANOWANE : Rodzajzlecenia.NIEPLANOWANE;
        this.numerzlecenia = SetNrZlecenia();
        zlecenia.add(this);
        saveToFile();
    }

    public Zlecenie(boolean IsPlanned, Brygada brygada) {
        this(IsPlanned);
        this.brygada = brygada;
        brygada.brygadzista.historiaZlecenBrygadzisty.add(this);
    }

    public Zlecenie(boolean IsPlanned, List<Praca> prace) {
        this(IsPlanned);
        this.prace = prace;

    }

    public Zlecenie(boolean IsPlanned, Brygada brygada, List<Praca> prace) {
        this(IsPlanned, brygada);
        this.prace = prace;
    }

    public void DodajPrace(Praca praca) {
        this.prace.add(praca);
    }

    public LocalDateTime getDataUtworzenia() {
        return DataUtworzenia;
    }

    private String SetNrZlecenia() {
        return "#Z" + zlecenie++;
    }

    public void StatusZlecenia() {
        System.out.println(this.currentstatus);
    }

    public void dodajbrygade(Brygada brygada) {
        if (this.brygada == null) {
            this.brygada = brygada;
            brygada.brygadzista.historiaZlecenBrygadzisty.add(this);
            System.out.println("Pomyslnie dodano brygade do zlecenia " +
                    this.numerzlecenia);
        } else System.out.println("Zlecenie posiada juz brygade");
    }

    @Override
    public String toString() {
        return numerzlecenia ;
    }

    @Override
    public void run() {
        if (this.brygada == null || prace == null) throw new ZlecenieError();
        this.dataRozpoczecia = LocalDateTime.now();
        for (int i = 0; i < prace.size(); i++) {
            synchronized (prace) {
                prace.get(i).start();
                try {
                    sleep(prace.get(i).Czaspracy);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                prace.get(i).interrupt();
            }
        }
        System.out.println("Zlecenie wykonane");
        this.dataZakonczenia = LocalDateTime.now();

    }
    public Status getCurrentstatus() {
        return currentstatus;
    }
    public String getDataZakonczenia() {
        if(dataZakonczenia == null) {
            return "";
        }
        return dataZakonczenia.toString();
    }
    private static String getFileName() {
        return "C:\\Users\\oskik\\IdeaProjects\\PRO_01\\src\\zleceniabaza.bin";
    }
    private void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getFileName()))) {
            this.zlecenia = (List<Zlecenie>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            zlecenia = new ArrayList<>();

        }catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFileName()))) {
            oos.writeObject(this.zlecenia);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
