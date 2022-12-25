import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class Main extends JFrame {
    private JPanel mainPanel;
    private JLabel lblinf;
    private JButton btnNZ;
    private JButton btnIP;
    private JButton btnIZ;
    private JButton btnPB;
    private JButton btnPK;
    private JButton btnExit;

    public Main(){
        this.setContentPane(mainPanel);
        btnNZ.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
                NoviZaposleni nz= new NoviZaposleni();;
                nz.setSize(400,400);
                nz.setLocationRelativeTo(null);
                nz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                nz.setVisible(true);

            }
        });
        btnIP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
                IzmenaPodataka ip= ip = new IzmenaPodataka();
                ip.setSize(400,400);
                ip.setLocationRelativeTo(null);
                ip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ip.setVisible(true);
            }
        });

        btnIZ.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
                BrisanjeZaposleng br= new BrisanjeZaposleng();
                br.setSize(400,400);
                br.setLocationRelativeTo(null);
                br.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                br.setVisible(true);
            }
        });

        btnPB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
                PrikazBaze pb= new PrikazBaze();
                pb.setSize(400,400);
                pb.setLocationRelativeTo(null);
                pb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pb.setVisible(true);
            }
        });

        btnPK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
                PrikazKriterijum pk= new PrikazKriterijum();
                pk.setSize(400,400);
                pk.setLocationRelativeTo(null);
                pk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pk.setVisible(true);
            }
        });

        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
            }
        });
    }

    public static void main(String[] args) {
        Main f=new Main();
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }
    public void close(){
        WindowEvent closeWindow=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
}
