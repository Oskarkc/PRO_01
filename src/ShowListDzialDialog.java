import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ShowListDzialDialog extends javax.swing.JDialog {
    JPanel panel = new JPanel();
    JTable table = new JTable();
    public ShowListDzialDialog(java.awt.Frame parent, DzialPraco dzxial) {
        super(parent, true);
        this.setTitle("Dzial"+dzxial);
        this.setSize(400,400);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Dzial");
        table.setModel(model);
        for (Pracownik prac : dzxial.getListaPracownikow()){
            model.addRow(new Object[]{prac});
        }
        panel.setLayout(new BorderLayout());
        panel.add(table, BorderLayout.CENTER);
        table.getColumnModel().getColumn(0).setPreferredWidth(400);
        table.setDefaultEditor(Object.class, null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.add(panel);
        this.setLocationRelativeTo(parent);
        pack();
        this.setVisible(true);
    }
}
