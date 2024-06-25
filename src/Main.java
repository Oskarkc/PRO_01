import java.awt.*;
import java.util.Arrays;

import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DzialPraco dzial = DzialPraco.CreateDzial("jeden");
        Uzytkownik uzy1 = new Uzytkownik("maniek","bonk","31.12.2002",dzial,"siema","123");
        Uzytkownik uzy = new Uzytkownik("marek","bonk","31.12.2002",dzial,"siema","333");
        new logowanie();
    }

}