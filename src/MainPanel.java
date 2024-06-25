import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;

public class MainPanel extends JPanel {
    MyJframe myJframe;
    static boolean isInDzialy = false;
    static boolean isInPracownicy = false;
    JPanel all = new JPanel();
    JPanel leftpanel = new JPanel();
    JPanel centerPanel = new JPanel();
     static JTable pracownicy = new JTable();
    static JTable dzialy = new JTable();
    JButton dzial = new JButton("Dzial");
    JButton uzytkownik = new JButton("Uzytkownik");
    JButton brygadzista = new JButton("Brygadzista");
    JButton brygada = new JButton("Brygada");
    JButton zlecenie = new JButton("Zlecenie");
    JButton praca = new JButton("Prace");
    static JButton wyloguj = new JButton("Wyloguj");
    public MainPanel(){
        this.setLayout(new BorderLayout());
        setconfigPracownicy();
        setconfigDzial();
        configLeftPanel();
        all.setLayout(new BorderLayout());
        all.add(leftpanel, BorderLayout.WEST);
        all.add(centerPanel, BorderLayout.CENTER);
        this.add(all);
        this.setVisible(true);
        dzialy.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                new ShowListDzialDialog(myJframe,(DzialPraco) dzialy.getValueAt(dzialy.rowAtPoint(e.getPoint()),0));
            }
        });
    }

    public static void setconfigPracownicy() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Imię i Nazwisko");
        Collections.sort(Pracownik.listapracownikow);
        for (Pracownik pracownik : Pracownik.listapracownikow){
            model.addRow(new Object[]{pracownik});
        }
        pracownicy.setModel(model);
        pracownicy.getColumnModel().getColumn(0).setPreferredWidth(400);
        pracownicy.setDefaultEditor(Object.class,null);
    }
    public static void setconfigDzial(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nazwa Dzialu");
        Collections.sort(DzialPraco.dzialy2);
        for(DzialPraco nazwa : DzialPraco.dzialy2){
            model.addRow(new Object[]{nazwa});
        }
        dzialy.setModel(model);
        dzialy.getColumnModel().getColumn(0).setPreferredWidth(400);
        dzialy.setDefaultEditor(Object.class,null);
    }
    public static void setconfigBrygada(){

    }
    public static void setconfigBrygadzista(){

    }
    public static void setconfigZlecenia(){

    }
    public static void setconfigPraca(){

    }
    public void switcher(){
        isInDzialy = false;
        isInPracownicy = false;
    }
    public void configLeftPanel(){
        centerPanel.setLayout(new FlowLayout());
        leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));
        leftpanel.add(dzial);
        dzial.addActionListener(e-> {
            switcher();
            isInDzialy = true;
            centerPanel.removeAll();
            centerPanel.add(new JScrollPane(dzialy));
            revalidate();
            repaint();
        });
        leftpanel.add(uzytkownik);
        uzytkownik.addActionListener(e-> {
            switcher();
            isInPracownicy = true;
            centerPanel.removeAll();
            centerPanel.add(new JScrollPane(pracownicy));
            revalidate();
            repaint();
        });
        leftpanel.add(brygadzista);
        leftpanel.add(brygada);
        leftpanel.add(zlecenie);
        leftpanel.add(praca);
        leftpanel.add(wyloguj);
    }
}
