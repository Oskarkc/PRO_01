import java.util.Collections;

public class Praca extends Thread{
    private static int counter=1;
    private int numerPracy;
    private RodzajPracy rodzajPracy;
    private int Czaspracy;
    private boolean Isdone;
    private String opis;
    private Collections praca;

private void setNrPracy(){
    this.numerPracy=counter++;
}
}
