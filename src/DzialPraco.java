import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DzialPraco {
    private static int dzial=1;
    final private String nrdzialu;
    private String nazwa;
    private static List<String> dzialy =  new ArrayList<>();
    private List<Pracownik> listaPracownikow;
    private DzialPraco(String nazwa) throws NotUniqueNameException{
        if(dzialy.contains(nazwa)) throw new NotUniqueNameException();
        this.nazwa=nazwa;
        dzialy.add(nazwa);
        listaPracownikow=new ArrayList<>();
        System.out.println("Dzial stworzony pomyslnie");
        this.nrdzialu=setNrdzialu();
    }
    public static DzialPraco CreateDzial(String nazwa){
        return new DzialPraco(nazwa);
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }

    @Override
    public String toString() {
        return "Dzial " + nazwa + " ";
    }
    public String setNrdzialu() {
        return "D"+dzial++;
    }
}
