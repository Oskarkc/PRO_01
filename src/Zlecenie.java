import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Zlecenie implements Runnable {
    private static int zlecenie=1;
    final private String numerzlecenia;
    private Status currentstatus;
    private LocalDateTime DataUtworzenia;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;
    final private boolean IsPlanned;
    private Brygada brygada;
    private List<Praca> prace;
   public Zlecenie(boolean IsPlanned){
       this.currentstatus=Status.UTWORZONE;
       this.IsPlanned=IsPlanned;
       this.numerzlecenia=SetNrZlecenia();
       this.prace=new ArrayList<>();
    }
    public Zlecenie(boolean IsPlanned, Brygada brygada){
       this.currentstatus=Status.UTWORZONE;
       this.IsPlanned=IsPlanned;
       this.brygada=brygada;
       this.numerzlecenia=SetNrZlecenia();
        this.prace=new ArrayList<>();
       brygada.brygadzista.historiaZlecenBrygadzisty.add(this);
   }
   public Zlecenie(boolean IsPlanned,List<Praca> prace) {
       this.currentstatus=Status.UTWORZONE;
       this.IsPlanned=IsPlanned;
       this.prace=prace;
       this.numerzlecenia=SetNrZlecenia();
   }
   public Zlecenie(boolean IsPlanned, Brygada brygada, List<Praca> prace){
       this.currentstatus=Status.UTWORZONE;
   this.IsPlanned=IsPlanned;
   this.brygada=brygada;
   this.prace.addAll(prace);
   this.numerzlecenia=SetNrZlecenia();
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
        return numerzlecenia;
    }

    @Override
    public void run() {

    }
}
