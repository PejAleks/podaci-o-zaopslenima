import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class IzmenaPodataka extends JFrame{
    private JPanel IPPanel;
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
    private JButton btnAdreda;
    private JButton btnPlata;
    private JButton btnSve;
    private JButton btnBack;
    private JLabel lblID;
    private JTextField tfID;

    public IzmenaPodataka(){
        this.setContentPane(IPPanel);

        btnIme.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id= Integer.parseInt(tfID.getText());
                String ime=tfIme.getText();
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    Zaposleni izime =session.get(Zaposleni.class,id);
                    izime.setIme(ime);
                    session.update(izime);
                    tx.commit();
                }
                catch(HibernateException ex) {
                    if(tx != null) {
                        tx.rollback();
                    }
                    System.out.println(e);
                }
                finally {
                    HibernateUtil.close();
                }
            }
        });

        btnGodine.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id= Integer.parseInt(tfID.getText());
                int godine= Integer.parseInt(tfGodine.getText());
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    Zaposleni izgodine =session.get(Zaposleni.class,id);
                    izgodine.setGodine(godine);
                    session.update(izgodine);
                    tx.commit();
                }
                catch(HibernateException ex) {
                    if(tx != null) {
                        tx.rollback();
                    }
                    System.out.println(e);
                }
                finally {
                    HibernateUtil.close();
                }
            }
        });

        btnAdreda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id= Integer.parseInt(tfID.getText());
                String adresa=tfAdresa.getText();
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    Zaposleni izadresa =session.get(Zaposleni.class,id);
                    izadresa.setAdresa(adresa);
                    session.update(izadresa);
                    tx.commit();
                }
                catch(HibernateException ex) {
                    if(tx != null) {
                        tx.rollback();
                    }
                    System.out.println(e);
                }
                finally {
                    HibernateUtil.close();
                }
            }
        });

        btnPlata.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id= Integer.parseInt(tfID.getText());
                double plata= Double.parseDouble(tfPlata.getText());
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    Zaposleni izplata =session.get(Zaposleni.class,id);
                    izplata.setPlata(plata);
                    session.update(izplata);
                    tx.commit();
                }
                catch(HibernateException ex) {
                    if(tx != null) {
                        tx.rollback();
                    }
                    System.out.println(e);
                }
                finally {
                    HibernateUtil.close();
                }
            }
        });

        btnSve.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id= Integer.parseInt(tfID.getText());
                String ime=tfIme.getText();
                int godine= Integer.parseInt(tfGodine.getText());
                String adresa=tfAdresa.getText();
                double plata= Double.parseDouble(tfPlata.getText());
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    Zaposleni z=new Zaposleni(id,ime,godine,adresa,plata);
                    session.update(z);
                    tx.commit();
                }
                catch(HibernateException ex) {
                    if(tx != null) {
                        tx.rollback();
                    }
                    System.out.println(e);
                }
                finally {
                    HibernateUtil.close();
                }
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
