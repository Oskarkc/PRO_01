import javax.swing.*;

public class MyJframe extends JFrame {
    Menu menu;
    Pracownik pracownik;
    MainPanel main;
    public MyJframe(Pracownik pracownik){
        this.pracownik = pracownik;
        menu = new Menu(pracownik);
        this.setSize(720,480);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(menu);
        MainPanel.wyloguj.addActionListener(e->{
            new logowanie();
            this.dispose();
        });
    }
}
