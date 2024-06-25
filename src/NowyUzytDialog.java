import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NowyUzytDialog extends JDialog {
    JPanel panel = new JPanel();
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JTextField text3 = new JTextField();
    JTextField text5 = new JTextField();
    JTextField text6 = new JTextField();
    JComboBox comboBox = new JComboBox();
    JCheckBox isBrygadzista = new JCheckBox("Czy brygadzista");
    JButton create = new JButton("CREATE");
    public NowyUzytDialog(JFrame parent) {
        super(parent,true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(parent);
        this.setTitle("Nowy");
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        initcomp();
        initCombobox();
        this.add(panel);
        create.addActionListener(e -> {
            if(isFieldEmpty()) {
                JOptionPane.showMessageDialog(parent, "Please enter a valid text");
            }else if(!isBrygadzista.isSelected() && !isFieldEmpty()){
                new Uzytkownik(text1.getText(), text2.getText(), text3.getText(), (DzialPraco) comboBox.getSelectedItem(), text5.getText(), text6.getText());
                MainPanel.setconfigPracownicy();
                JOptionPane.showMessageDialog(null,"Pomyslnie stworzono uzytkownika");
                this.dispose();
            }else {
                new Brygadzista(text1.getText(), text2.getText(), text3.getText(), (DzialPraco) comboBox.getSelectedItem(), text5.getText(), text6.getText());
                MainPanel.setconfigPracownicy();
                JOptionPane.showMessageDialog(null,"Pomyslnie stworzono uzytkownika");
                this.dispose();
            }
        });
        pack();
        setVisible(true);
    }
    private void initcomp(){
        panel.add(new JLabel("Imie"));
        panel.add(text1);
        panel.add(new JLabel("Nazwisko"));
        panel.add(text2);
        panel.add(new JLabel("Data Urodzenia"));
        panel.add(text3);
        panel.add(new JLabel("Dzial"));
        panel.add(comboBox);
        panel.add(new JLabel("Login"));
        panel.add(text5);
        panel.add(new JLabel("Haslo"));
        panel.add(text6);
        panel.add(isBrygadzista);
        panel.add(create);
    }
    public void initCombobox(){
        DefaultComboBoxModel<DzialPraco> model = new DefaultComboBoxModel<>();
        comboBox.setModel(model);
        for(DzialPraco dzialy : DzialPraco.dzialy2){
            model.addElement(dzialy);
        }
    }
    private boolean isFieldEmpty(){
        if(text1.getText().isEmpty() || text2.getText().isEmpty()
                || text3.getText().isEmpty() || text5.getText().isEmpty()
                || text6.getText().isEmpty())
            return true;
        return false;
    }

}
