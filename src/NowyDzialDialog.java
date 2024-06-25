import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class NowyDzialDialog extends JDialog {
    JPanel panel = new JPanel();
    JTextField textField = new JTextField();
    JButton okButton = new JButton("CONFIRM");
    public NowyDzialDialog(JFrame parent) {
        super(parent,true);
        this.setTitle("Nowy Dzial");
        this.setSize(300,300);
        setPanel();
        setLocationRelativeTo(parent);
        this.add(panel);
        pack();
        setVisible(true);
    }
    public void setPanel() {
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(new JLabel("Podaj nazwe Dzialu"));
        panel.add(textField);
        panel.add(okButton);
        okButton.addActionListener(e -> {
            if(DzialPraco.Isnameunique(textField.getText()) || textField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Blad!, Pozostawiles puste pole lub taki dzial juz istnieje!");
            }else{
                DzialPraco.CreateDzial(textField.getText());
                MainPanel.setconfigDzial();
                JOptionPane.showMessageDialog(null,"Dzial utworzony");
                this.dispose();
            }
        });
    }
}
