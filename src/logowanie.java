import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class logowanie extends JFrame {
    static Pracownik prac;
    JPanel panelusername;
    JLabel Username = new JLabel("Username");
    JLabel Password = new JLabel("Password");
    JCheckBox dohasla = new JCheckBox("Pokaz haslo");
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);
    JButton zaloguj = new JButton("Zaloguj");
    public logowanie() {
        this.setTitle("Logowanie");
        this.setLayout(new GridLayout(2,1));
        this.setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setconfigurationusername();
        zaloguj.addActionListener(e->{
            if(Pracownik.znajdzUzytkownika(username.getText(),password.getText())){
                JOptionPane.showMessageDialog(null,"Zalogowano Pomyslnie");
                dispose();
                new MyJframe(prac);
            }else{
                JOptionPane.showMessageDialog(null,"Login lub Haslo są nieprawidłowe");
            }
        });
        this.add(panelusername);
        this.add(zaloguj);
        pack();
        setVisible(true);
    }
    public void setconfigurationusername(){
        panelusername = new JPanel();
        panelusername.setLayout(new FlowLayout());
        username.setText("siema");
        password.setText("123");
        panelusername.add(Username);
        panelusername.add(username);
        panelusername.add(Password);
        panelusername.add(password);
        password.setEchoChar('*');
        dohasla.addActionListener(e -> {
            if (dohasla.isSelected()) {
                password.setEchoChar((char) 0);
            }
            else {
                password.setEchoChar('*');
            }
        });
        panelusername.add(dohasla);
    }
    public static void setPracownik(Pracownik praco){
        prac=praco;
    }
}
