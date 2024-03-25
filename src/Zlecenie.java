import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class Zlecenie<T> {
    private LocalDateTime DataUtworzenia=LocalDateTime.now();
    private boolean IsPlanned;
    private Brygada brygada;
    private Collection<T> prace;
   public Zlecenie(boolean IsPlanned){
       this.IsPlanned=IsPlanned;
    }
    public Zlecenie(boolean IsPlanned, Brygada brygada){
       this.IsPlanned=IsPlanned;
       this.brygada=brygada;
   }
   public Zlecenie(boolean IsPlanned,Collection<T> prace) {
       this.IsPlanned=IsPlanned;
   }
   public Zlecenie(boolean IsPlanned, Brygada brygada, Collection<T>prace){
   this.IsPlanned=IsPlanned;
   this.brygada=brygada;
   this.prace=prace;
   }
public void DodajPrace(Collection<T> praca){
       this.prace.addAll(praca);
}
}
