import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Menu extends JMenu {
    MyJframe myframe;
    MainPanel mainPanel = new MainPanel();
    JPanel upperPanel = new JPanel();
    JPanel lowerPanel = new JPanel();
    JButton witaj;
    JButton nowy = new JButton("Nowy");
    JButton edytuj = new JButton("Edytuj");
    JButton usun = new JButton("Usun");
    Pracownik pracownik;
    ZmianaHaslaDialog zmianaNazwyDialog;

    public Menu(Pracownik pracownik) {
        this.pracownik = pracownik;
        setLayout(new BorderLayout());
        setConfigUpperPanel();
        this.add(upperPanel, BorderLayout.NORTH);
        this.add(this.mainPanel , BorderLayout.CENTER);
        this.setVisible(true);

    }
    private void setConfigUpperPanel(){
        witaj = new JButton("Witaj " + ((Uzytkownik) pracownik).getInit()+"!");
        upperPanel.setLayout(new BorderLayout());
        upperPanel.add(witaj,BorderLayout.LINE_END);
        witaj.addActionListener(e->{
            zmianaNazwyDialog = new ZmianaHaslaDialog(myframe,pracownik);
        });
        lowerPanel.setLayout(new FlowLayout());
        nowy.addActionListener(e -> {
            if(MainPanel.isInPracownicy){
                new NowyUzytDialog(myframe);
            }else if(MainPanel.isInDzialy){
                new NowyDzialDialog(myframe);
            }
        });
        lowerPanel.add(nowy);
        edytuj.addActionListener(e->{
            if(MainPanel.isInPracownicy){
                if(MainPanel.pracownicy.getSelectedRow() != -1);

            }else if (MainPanel.isInDzialy)
                if(MainPanel.dzialy.getSelectedRow() != -1) {
                    int row = MainPanel.dzialy.getSelectedRow();
                    new EdyDzialDialog(myframe, (DzialPraco) MainPanel.dzialy.getValueAt(row,0));
                }
        });
        lowerPanel.add(edytuj);
        usun.addActionListener(e-> {
            if(MainPanel.isInDzialy)
                if(MainPanel.dzialy.getSelectedRow() != -1) {
                    int i = JOptionPane.showConfirmDialog(null, "Czy jestes pewny?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                    if(i== JOptionPane.YES_OPTION) {
                        removeForDzialy();
                    }
                }
            if(MainPanel.isInPracownicy)
                if(MainPanel.pracownicy.getSelectedRow() != -1) {
                    int i = JOptionPane.showConfirmDialog(null, "Czy jestes pewny?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                    if(i== JOptionPane.YES_OPTION) {
                        removeForPracownicy();
                    }
                }
        });
        lowerPanel.add(usun);
        upperPanel.add(lowerPanel, BorderLayout.CENTER);
    }
    private void removeForDzialy() {
        DzialPraco.getDzialy().remove(MainPanel.dzialy.getSelectedRow());
        ((DefaultTableModel) MainPanel.dzialy.getModel()).removeRow(MainPanel.dzialy.getSelectedRow());
        MainPanel.dzialy.revalidate();
        MainPanel.dzialy.repaint();
    }
    private void removeForPracownicy() {
        int row = MainPanel.pracownicy.getSelectedRow();
        if(pracownik == MainPanel.pracownicy.getValueAt(row,0)){
            JOptionPane.showMessageDialog(null, "Probujesz usunac swoje konto!");
            return;
        }
        Pracownik.listapracownikow.remove(MainPanel.pracownicy.getValueAt(MainPanel.pracownicy.getSelectedRow(), 0));
        ((DefaultTableModel) MainPanel.pracownicy.getModel()).removeRow(MainPanel.pracownicy.getSelectedRow());
        MainPanel.pracownicy.revalidate();
        MainPanel.pracownicy.repaint();
    }
}
