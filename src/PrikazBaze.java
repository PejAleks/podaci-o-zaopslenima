import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.stringtemplate.v4.ST;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.List;

public class PrikazBaze extends JFrame{
    private JPanel PBPanel;
    private JTable tbl;
    private JButton btnBack;

    public PrikazBaze(){
        this.setContentPane(PBPanel);
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Ime");
        model.addColumn("Godine");
        model.addColumn("Adresa");
        model.addColumn("Plata");
        Session session = HibernateUtil.createSessionFactory().openSession();

        Transaction tx =session.beginTransaction();
        List<Zaposleni> zaposleniList;
        String zaposleni="from Zaposleni";
        Query query=session.createQuery(zaposleni);
        zaposleniList=query.list();
        for (Zaposleni z:zaposleniList){
            String[] row={String.valueOf(z.getId()),z.getIme(), String.valueOf(z.getGodine()),z.getAdresa(), String.valueOf(z.getPlata())};
        model.addRow(row);
        }
        tbl.setModel(model);
        tx.commit();

        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                close();
                Main f=new Main();
                f.setSize(400,400);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
    public void close(){
        WindowEvent closeWindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}
