import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


    public class ShowListBryg extends javax.swing.JDialog {
        JPanel panel = new JPanel();
        JTable table = new JTable();
        public ShowListBryg(java.awt.Frame parent, Brygada brygada) {
            super(parent, true);
            this.setTitle("Brygada "+brygada.toString());
            this.setSize(400,400);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Brygadzista");
            model.addColumn("Pracownicy");
            table.setModel(model);
            for (Pracownik prac : brygada.pracownicy){
                model.addRow(new Object[]{brygada.brygadzista,prac});
            }
            panel.setLayout(new BorderLayout());
            panel.add(new JScrollPane(table), BorderLayout.CENTER);
            table.getColumnModel().getColumn(0).setPreferredWidth(400);
            table.setDefaultEditor(Object.class, null);
            this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            this.add(panel);
            this.setLocationRelativeTo(parent);
            pack();
            this.setVisible(true);
        }

    }

