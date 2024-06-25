import javax.swing.*;
import java.awt.event.ActionListener;

public class ZmianaHaslaDialog extends JDialog {
    JPanel contentPanel = new JPanel();
    JButton confirm = new JButton("CONFIRM");
    JPasswordField haslo = new JPasswordField(20);
    JCheckBox checkbox = new JCheckBox("Pokaz Haslo");
    Pracownik pracownik;
    public ZmianaHaslaDialog(JFrame parent, Pracownik pracownik) {
        super(parent,true);
        this.pracownik = pracownik;
        this.setTitle("Zmiana Hasla");
        this.setSize(500,500);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        haslo.setEchoChar('*');
        contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
        contentPanel.add(new JLabel("Wprowadz nowe haslo"));
        contentPanel.add(haslo);
        contentPanel.add(checkbox);
        checkbox.addActionListener(e -> {
            if(checkbox.isSelected()) {
                haslo.setEchoChar((char) 0);
            }else
                haslo.setEchoChar('*');
        });

        contentPanel.add(confirm);
        confirm.addActionListener(e->{
                ((Uzytkownik) pracownik).setHaslo(haslo.getText());
                int odp = JOptionPane.showConfirmDialog(null,"Czy jestes pewny?","Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if(odp == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,"Haslo zmienione pomyslnie!");
                    this.dispose();
                }else
                    this.dispose();
        });
        this.add(contentPanel);
        pack();
        this.setVisible(true);
    }
}
