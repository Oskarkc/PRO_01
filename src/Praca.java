import java.util.Collections;
import java.util.List;

public class Praca extends Thread {
    private static int counter=1;
    private String numerPracy;
    private RodzajPracy rodzajPracy;
    private int Czaspracy;
    private boolean Isdone;
    private String opis;
    private List<Praca> praca;
    public Praca(RodzajPracy rodzajPracy, int czaspracy, boolean isdone, String opis, List<Praca> praca) {
        this.numerPracy = setNrPracy();
        this.rodzajPracy = rodzajPracy;
        Czaspracy = czaspracy;
        Isdone = isdone;
        this.opis = opis;
        this.praca = praca;
    }

private String setNrPracy(){
    return  "#P"+counter++;
}
}
