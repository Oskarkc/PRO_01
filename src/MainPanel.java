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
    static boolean isInBrygady = false;
    static boolean isInZlecenia = false;
    JPanel all = new JPanel();
    JPanel leftpanel = new JPanel();
    JPanel centerPanel = new JPanel();
     static JTable pracownicy = new JTable();
    static JTable dzialy = new JTable();
    static JTable brygady = new JTable();
    static JTable zlecenia = new JTable();
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
        setconfigZlecenia();
        setconfigBrygada();
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
        brygady.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                new ShowListBryg(myJframe,(Brygada) brygady.getValueAt(brygady.rowAtPoint(e.getPoint()),0));
            }
        });
        zlecenia.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Zlecenie zlecenie1=((Zlecenie) zlecenia.getValueAt(zlecenia.rowAtPoint(e.getPoint()),zlecenia.columnAtPoint(e.getPoint())));
                if(zlecenie1.prace==null){
                    JOptionPane.showMessageDialog(null,"Brak prac w zleceniu!");
                    return;
                }
                        new ShowListPracDialog(myJframe,zlecenie1);
            }});
    }

    public static void setconfigPracownicy() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Imię i Nazwisko");
        model.addColumn("Stopien");
        pracownicy.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        Collections.sort(Pracownik.listapracownikow);
        for (Pracownik pracownik : Pracownik.listapracownikow){
            model.addRow(new Object[]{pracownik,pracownik.getClass().getSimpleName()});
        }
        pracownicy.setModel(model);
        pracownicy.getColumnModel().getColumn(0).setPreferredWidth(400);
        pracownicy.setDefaultEditor(Object.class,null);
    }
    public static void setconfigDzial(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nazwa Dzialu");
        Collections.sort(DzialPraco.dzialy2);
        dzialy.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        for(DzialPraco nazwa : DzialPraco.dzialy2){
            model.addRow(new Object[]{nazwa});
        }
        dzialy.setModel(model);
        dzialy.getColumnModel().getColumn(0).setPreferredWidth(400);
        dzialy.setDefaultEditor(Object.class,null);
    }
    public static void setconfigBrygada(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nazwa Brygady");
        for (Brygada bryg : Brygada.brygady){
            model.addRow(new Object[]{bryg});
        }
        brygady.setModel(model);
        brygady.getColumnModel().getColumn(0).setPreferredWidth(400);
        brygady.setDefaultEditor(Object.class,null);
    }
    public static void setconfigBrygadzista(){

    }
    public static void setconfigZlecenia(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data Utworzenia");
        model.addColumn("Numer Zlecenia");
        model.addColumn("Status");
        for (Zlecenie zlec : Zlecenie.zlecenia){
            model.addRow(new Object[]{zlec.getDataUtworzenia(),zlec,zlec.getCurrentstatus(),zlec.getDataZakonczenia()});
        }
        zlecenia.setModel(model);
        zlecenia.getColumnModel().getColumn(0).setPreferredWidth(400);
        zlecenia.setDefaultEditor(Object.class,null);
    }
    public static void setconfigPraca(){

    }
    public void switcher(){
        isInDzialy = false;
        isInPracownicy = false;
        isInBrygady = false;
        isInZlecenia = false;
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
        brygada.addActionListener(e -> {
            switcher();
            isInBrygady = true;
            centerPanel.removeAll();
            centerPanel.add(new JScrollPane(brygady));
            revalidate();
            repaint();
        });
        leftpanel.add(zlecenie);
        zlecenie.addActionListener(e -> {
            switcher();
            isInZlecenia = true;
            centerPanel.removeAll();
            centerPanel.add(new JScrollPane(zlecenia));
            revalidate();
            repaint();
        });
        leftpanel.add(praca);
        leftpanel.add(wyloguj);
    }
}
