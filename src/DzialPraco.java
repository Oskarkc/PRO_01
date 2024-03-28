import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DzialPraco {
    private String nazwa;
    private static List<String> dzialy =  new ArrayList<>();
    private List<Pracownik> listaPracownikow;
    private DzialPraco(String nazwa) throws NotUniqueNameException{
        if(Isnameunique(nazwa)) throw new NotUniqueNameException();
        this.nazwa=nazwa;
        dzialy.add(nazwa);
        listaPracownikow=new ArrayList<>();
        System.out.println("Dzial stworzony pomyslnie");

    }
    public static DzialPraco CreateDzial(String nazwa){
        return new DzialPraco(nazwa);
    }
    public boolean Isnameunique(String nazwa){
        for (int i = 0; i < dzialy.size(); i++) {
            if(dzialy.get(i).equals(nazwa)){
                return true;
            }
        }
        return false;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Pracownik> getListaPracownikow() {
        return listaPracownikow;
    }
}
