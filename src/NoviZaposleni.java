import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class NoviZaposleni extends JFrame {
    private JPanel NZPanel;
    private JTextField tfIme;
    private JLabel lblGodine;
    private JLabel lblIme;
    private JTextField tfGodine;
    private JLabel lblAdresa;
    private JTextField tfAdresa;
    private JLabel lblPlata;
    private JTextField tfPlata;
    private JButton btnSave;
    private JButton btnBack;

    public NoviZaposleni(){
        this.setContentPane(NZPanel);
        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String ime=tfIme.getText();
                int godine= Integer.parseInt(tfGodine.getText());
                String adresa=tfAdresa.getText();
                double plata= Double.parseDouble(tfPlata.getText());
                Session session = HibernateUtil.createSessionFactory().openSession();

                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    Zaposleni zaposleni = new Zaposleni(ime,godine,adresa,plata);
            session.persist(zaposleni);
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
