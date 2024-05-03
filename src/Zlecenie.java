import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Thread.sleep;

public class Zlecenie implements Runnable {
    private static int zlecenie=1;
    final private String numerzlecenia;
    private Status currentstatus;
    final private LocalDateTime DataUtworzenia;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;
    final private Rodzajzlecenia IsPlanned;
    private Brygada brygada;
    private List<Praca> prace;
    private static Map<String,Zlecenie> mapa = new HashMap<>();
   public Zlecenie(boolean IsPlanned){
       this.currentstatus=Status.UTWORZONE;
       this.DataUtworzenia=LocalDateTime.now();
       this.IsPlanned=IsPlanned?Rodzajzlecenia.PLANOWANE:Rodzajzlecenia.NIEPLANOWANE;
       this.numerzlecenia=SetNrZlecenia();
       mapa.put(numerzlecenia,this);
    }
    public Zlecenie(boolean IsPlanned, Brygada brygada){
       this.currentstatus=Status.UTWORZONE;
        this.DataUtworzenia=LocalDateTime.now();
       this.IsPlanned=IsPlanned?Rodzajzlecenia.PLANOWANE:Rodzajzlecenia.NIEPLANOWANE;
       this.brygada=brygada;
       this.numerzlecenia=SetNrZlecenia();
       mapa.put(numerzlecenia,this);
       brygada.brygadzista.historiaZlecenBrygadzisty.add(this);
   }
   public Zlecenie(boolean IsPlanned,List<Praca> prace) {
       this.currentstatus=Status.UTWORZONE;
       this.DataUtworzenia=LocalDateTime.now();
       this.IsPlanned=IsPlanned?Rodzajzlecenia.PLANOWANE:Rodzajzlecenia.NIEPLANOWANE;
       this.prace=prace;
       this.numerzlecenia=SetNrZlecenia();
       mapa.put(numerzlecenia,this);
   }
   public Zlecenie(boolean IsPlanned, Brygada brygada, List<Praca> prace){
       this.currentstatus=Status.UTWORZONE;
       this.IsPlanned=IsPlanned?Rodzajzlecenia.PLANOWANE:Rodzajzlecenia.NIEPLANOWANE;
       this.DataUtworzenia=LocalDateTime.now();
   this.brygada=brygada;
   this.prace=prace;
   this.numerzlecenia=SetNrZlecenia();
       mapa.put(numerzlecenia,this);
   brygada.brygadzista.historiaZlecenBrygadzisty.add(this);
   }
public void DodajPrace(Praca praca){
       this.prace.add(praca);
}

    public LocalDateTime getDataUtworzenia() {
        return DataUtworzenia;
    }
    private String SetNrZlecenia(){
           return "#Z"+zlecenie++;
       }

    public void StatusZlecenia() {
        System.out.println(this.currentstatus);
    }
    public void dodajbrygade(Brygada brygada){
       if(this.brygada == null){
           this.brygada=brygada;
           brygada.brygadzista.historiaZlecenBrygadzisty.add(this);
           System.out.println("Pomyslnie dodano brygade do zlecenia "+
                   this.numerzlecenia);
       }else System.out.println("Zlecenie posiada juz brygade");
         }

    @Override
    public String toString() {
        return numerzlecenia +" Status: "+this.currentstatus;
    }

    @Override
    public void run() {
       if(this.brygada==null || prace==null) {throw new ZlecenieError();}

       this.dataRozpoczecia = LocalDateTime.now();
           currentstatus = Status.ROZPOCZETE;
        System.out.println("Zlecenie: "+numerzlecenia +" rozpoczete o godz "+this.dataRozpoczecia);
           for (int i = 0; i < prace.size(); i++) {
               prace.get(i).start();
                   try {
                       sleep(prace.get(i).Czaspracy);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   prace.get(i).interrupt();
               try {
                   sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }

           }
           this.dataZakonczenia = LocalDateTime.now();
           currentstatus = Status.ZAKONCZONE;
           System.out.println("Zlecenie: "+numerzlecenia+" wykonane o godz "+this.dataZakonczenia);

    }

    public LocalDateTime getDataRozpoczecia() {
        return dataRozpoczecia;
    }
    public LocalDateTime getDataZakonczenia() {
       return dataZakonczenia;
    }

    public static Zlecenie getMapa(String s) {
        return mapa.get(s);
    }
}
