import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

public class Zlecenie {
    private static int zlecenie=1;
    private String numerzlecenia;
    private Status currentstatus;
    private LocalDateTime DataUtworzenia=LocalDateTime.now();
    private boolean IsPlanned;
    private Brygada brygada;
    private Collection<Praca> prace;
   public Zlecenie(boolean IsPlanned){
       this.currentstatus=Status.UTWORZONE;
       this.IsPlanned=IsPlanned;
       this.numerzlecenia=SetNrZlecenia();
    }
    public Zlecenie(boolean IsPlanned, Brygada brygada){
       this.currentstatus=Status.UTWORZONE;
       this.IsPlanned=IsPlanned;
       this.brygada=brygada;
       this.numerzlecenia=SetNrZlecenia();
   }
   public Zlecenie(boolean IsPlanned,Collection<Praca> prace) {
       this.currentstatus=Status.UTWORZONE;
       this.IsPlanned=IsPlanned;
       this.prace=prace;
       this.numerzlecenia=SetNrZlecenia();
   }
   public Zlecenie(boolean IsPlanned, Brygada brygada, Collection<Praca> prace){
       this.currentstatus=Status.UTWORZONE;
   this.IsPlanned=IsPlanned;
   this.brygada=brygada;
   this.prace.addAll(prace);
   this.numerzlecenia=SetNrZlecenia();
   }
public void DodajPrace(Praca praca){
       this.prace.add(praca);
}

    public LocalDateTime getDataUtworzenia() {
        return DataUtworzenia;
    }
    private String SetNrZlecenia(){
           return "#"+zlecenie++;
       }

    public void StatusZlecenia() {
        System.out.println(this.currentstatus);
    }
}
