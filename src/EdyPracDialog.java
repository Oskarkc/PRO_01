import javax.swing.*;

public class EdyPracDialog extends JDialog {
    JPanel panel = new JPanel();
    JTextField text = new JTextField();
    DzialPraco dzial;
    JButton ok = new JButton("CONFIRM");
    public EdyPracDialog(JFrame parent, DzialPraco dzial) {
        super(parent,true);
        this.dzial = dzial;
        this.setTitle("Zmien Nazwe");
        this.add(panel);
        pack();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }
    public void setConfigEdycja(){

    }
}
