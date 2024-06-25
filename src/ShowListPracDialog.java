import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowListPracDialog extends javax.swing.JDialog {
    JPanel panel = new JPanel();
    JTable table = new JTable();
    public ShowListPracDialog(java.awt.Frame parent, Zlecenie zlec) {
        super(parent, true);
        this.setTitle("Zlecenie"+zlec);
        this.setSize(400,400);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Prace");
        table.setModel(model);
        for (Praca prac : zlec.prace){
            model.addRow(new Object[]{prac});
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
