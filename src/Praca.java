import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Praca extends Thread {
    private static int counter=1;
    private String numerPracy;
    private RodzajPracy rodzajPracy;
     int Czaspracy;
    private boolean Isdone;
    private String opis;
    private List<Praca> praca;
    private static Map<String,Praca> mapa = new HashMap<>();
    public Praca(RodzajPracy rodzajPracy, int czaspracy, String opis) {
        this.numerPracy = setNrPracy();
        this.rodzajPracy = rodzajPracy;
        Czaspracy = czaspracy;
        this.opis = opis;
        mapa.put(numerPracy,this);
    }

private String setNrPracy(){
    return  "#P"+counter++;
}

    @Override
    public void run() {
        boolean isactive = true;
        while (isactive) {
            System.out.println(this);

            try {
                sleep(1000);

            } catch (InterruptedException e) {
                this.Isdone = true;
                System.out.println("Praca " + numerPracy + " wykonana!");
                isactive=false;
            }
        }
    }

    @Override
    public String toString() {
        return this.numerPracy+ " Rodzaj: " + this.rodzajPracy+ " Czy skonczona: " + this.Isdone+ " Czas pracy: "+ (this.Czaspracy/1000) + "sek. Opis: " + this.opis;
    }
    public static Praca getmapa(String numerPracy) {
        return mapa.get(numerPracy);
    }
}
