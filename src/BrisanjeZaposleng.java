import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class BrisanjeZaposleng extends JFrame {
    private JPanel BRZaposlenog;
    private JLabel lblID;
    private JTextField tfID;
    private JButton btnSave;
    private JButton btnBack;

    public BrisanjeZaposleng() {
        this.setContentPane(BRZaposlenog);

        btnSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int id = Integer.parseInt(tfID.getText());
                Session session = HibernateUtil.createSessionFactory().openSession();
                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    Zaposleni z = session.get(Zaposleni.class, id);
                    session.delete(z);
                    tx.commit();
                } catch (HibernateException ex) {
                    if (tx != null) {
                        tx.rollback();
                    }
                    System.out.println(e);
                } finally {
                    HibernateUtil.close();
                }
            }
        });

        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                close();
                Main f = new Main();
                f.setSize(400, 400);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}