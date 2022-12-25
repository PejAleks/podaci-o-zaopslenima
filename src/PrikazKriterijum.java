import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.List;

public class PrikazKriterijum extends JFrame{
    private JPanel PKPanel;
    private JLabel lblIme;
    private JTextField tfIme;
    private JLabel lblGodine;
    private JTextField tfGodine;
    private JLabel lblAdresa;
    private JTextField tfAdresa;
    private JLabel lblPlata;
    private JTextField tfPlata;
    private JButton btnIme;
    private JButton btnGodine;
    private JButton btnAdresa;
    private JButton btnPlata;
    private JButton btnBack;
    private JTable tbl;

    public PrikazKriterijum(){
        this.setContentPane(PKPanel);

        btnIme.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String ime=tfIme.getText();
                DefaultTableModel model=new DefaultTableModel();
                model.addColumn("Id");
                model.addColumn("Ime");
                model.addColumn("Godine");
                model.addColumn("Adresa");
                model.addColumn("Plata");
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx =session.beginTransaction();
                List<Zaposleni> zaposleniList;
                String zaposleni="from Zaposleni as z where z.ime=:ime";
                Query query=session.createQuery(zaposleni);
                query.setParameter("ime",ime);
                zaposleniList=query.list();
                for (Zaposleni z:zaposleniList){
                    String[] row={String.valueOf(z.getId()),z.getIme(), String.valueOf(z.getGodine()),z.getAdresa(), String.valueOf(z.getPlata())};
                    model.addRow(row);
                }
                tbl.setModel(model);
                tx.commit();
            }
        });

        btnGodine.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int godine= Integer.parseInt(tfGodine.getText());
                DefaultTableModel model=new DefaultTableModel();
                model.addColumn("Id");
                model.addColumn("Ime");
                model.addColumn("Godine");
                model.addColumn("Adresa");
                model.addColumn("Plata");
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx =session.beginTransaction();
                List<Zaposleni> zaposleniList;
                String zaposleni="from Zaposleni as z where z.godine=:godine";
                Query query=session.createQuery(zaposleni);
                query.setParameter("godine",godine);
                zaposleniList=query.list();
                for (Zaposleni z:zaposleniList){
                    String[] row={String.valueOf(z.getId()),z.getIme(), String.valueOf(z.getGodine()),z.getAdresa(), String.valueOf(z.getPlata())};
                    model.addRow(row);
                }
                tbl.setModel(model);
                tx.commit();
            }
        });

        btnAdresa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String adresa=tfAdresa.getText();
                DefaultTableModel model=new DefaultTableModel();
                model.addColumn("Id");
                model.addColumn("Ime");
                model.addColumn("Godine");
                model.addColumn("Adresa");
                model.addColumn("Plata");
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx =session.beginTransaction();
                List<Zaposleni> zaposleniList;
                String zaposleni="from Zaposleni as z where z.adresa=:adresa";
                Query query=session.createQuery(zaposleni);
                query.setParameter("adresa",adresa);
                zaposleniList=query.list();
                for (Zaposleni z:zaposleniList){
                    String[] row={String.valueOf(z.getId()),z.getIme(), String.valueOf(z.getGodine()),z.getAdresa(), String.valueOf(z.getPlata())};
                    model.addRow(row);
                }
                tbl.setModel(model);
                tx.commit();
            }
        });

        btnPlata.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double plata= Double.parseDouble(tfPlata.getText());
                DefaultTableModel model=new DefaultTableModel();
                model.addColumn("Id");
                model.addColumn("Ime");
                model.addColumn("Godine");
                model.addColumn("Adresa");
                model.addColumn("Plata");
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx =session.beginTransaction();
                List<Zaposleni> zaposleniList;
                String zaposleni="from Zaposleni as z where z.plata=:plata";
                Query query=session.createQuery(zaposleni);
                query.setParameter("plata",plata);
                zaposleniList=query.list();
                for (Zaposleni z:zaposleniList){
                    String[] row={String.valueOf(z.getId()),z.getIme(), String.valueOf(z.getGodine()),z.getAdresa(), String.valueOf(z.getPlata())};
                    model.addRow(row);
                }
                tbl.setModel(model);
                tx.commit();
            }
        });

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
