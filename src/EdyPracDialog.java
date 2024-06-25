import javax.swing.*;
import java.awt.event.ActionListener;

public class EdyPracDialog extends JDialog {
    JPanel panel = new JPanel();
    JTextField textimie = new JTextField();
    JTextField textnazwisko = new JTextField();
    JComboBox comboBox = new JComboBox();
    JButton confirm = new JButton("Confirm");
    Pracownik pracownik;
    JButton ok = new JButton("CONFIRM");
    public EdyPracDialog(JFrame parent, Pracownik pracownik) {
        super(parent,true);
        this.pracownik = pracownik;
        this.setTitle("Zmien Nazwe");
        setConfigEdycja();
        this.add(panel);
        pack();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }
    public void setConfigEdycja(){
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nowe imie"));
        panel.add(textimie);
        panel.add(new JLabel("Nazwisko"));
        panel.add(textnazwisko);
        panel.add(new JLabel("Wybierz nowy dzial"));
        DefaultComboBoxModel<DzialPraco> model = new DefaultComboBoxModel<>();
        comboBox.setModel(model);
        for(DzialPraco dzialy : DzialPraco.dzialy2){
            model.addElement(dzialy);
        }
        panel.add(comboBox);
        panel.add(confirm);
        confirm.addActionListener(e -> {
            pracownik.setName(textimie.getText());
            pracownik.setSurrname(textnazwisko.getText());
            pracownik.setDzial((DzialPraco) comboBox.getSelectedItem());
            JOptionPane.showMessageDialog(null, "Pomyslnie zmieniono");
            MainPanel.pracownicy.revalidate();
            MainPanel.pracownicy.repaint();
        });
    }
}
