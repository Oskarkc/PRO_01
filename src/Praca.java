import java.util.Collections;
import java.util.List;

public class Praca extends Thread {
    private static int counter=1;
    private String numerPracy;
    private RodzajPracy rodzajPracy;
     int Czaspracy;
    private boolean Isdone;
    private String opis;
    private List<Praca> praca;
    public Praca(RodzajPracy rodzajPracy, int czaspracy, String opis) {
        this.numerPracy = setNrPracy();
        this.rodzajPracy = rodzajPracy;
        Czaspracy = czaspracy;
        this.opis = opis;
    }
    public Praca(RodzajPracy rodzajPracy, int czaspracy, boolean isdone, String opis) {
        this.numerPracy = setNrPracy();
        this.rodzajPracy = rodzajPracy;
        Czaspracy = czaspracy;
        Isdone = isdone;
        this.opis = opis;
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
        return this.numerPracy+ " " + this.rodzajPracy+ " " + this.Isdone+ " "+ this.Czaspracy + " " + this.opis;
    }
}
