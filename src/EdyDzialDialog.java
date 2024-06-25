import javax.swing.*;
import java.awt.event.ActionListener;

public class EdyDzialDialog extends JDialog {
    JPanel panel = new JPanel();
    JTextField text = new JTextField();
    DzialPraco dzial;
    JButton ok = new JButton("CONFIRM");
    public EdyDzialDialog(JFrame parent, DzialPraco dzial) {
        super(parent,true);
        this.dzial = dzial;
        this.setTitle("Zmien Nazwe");
        setconfipanel();
        this.add(panel);
        pack();
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
    }
    public void setconfipanel(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Nazwa Dzialu"));
        panel.add(text);
        panel.add(ok);
        ok.addActionListener(e->{
            if(DzialPraco.Isnameunique(text.getText())){
               JOptionPane.showMessageDialog(null, "Nazwa nie jest unikatowa");
               this.dispose();
            }else{
                dzial.setNazwa(text.getText());
                MainPanel.setconfigDzial();
                this.dispose();
            }
        });
    }
}
