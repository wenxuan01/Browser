package browser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class Browser extends JFrame {

    public Browser() {
        initComponents();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Browser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        setPreferredSize(new java.awt.Dimension(1366, 728));
        pack();
        //setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    private void initComponents() {

        settingsMenu = new JPopupMenu();
        jMenuBar1 = new JMenuBar();
        jMenuBar2 = new JMenuBar();
        jSeparator1 = new JSeparator();
        mainPane = new JTabbedPane();
        jScrollBar1 = new JScrollPane();
        jTextField1 = new JTextField();
        main = new JPanel();
        top = new JPanel();

        jMenuBar1.setToolTipText("Opens a new tab");
        jMenuBar1.setName("New tab");
        jMenuBar2.setToolTipText("Switch to ASCII encoding");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        main.setLayout(new BorderLayout());
        main.setPreferredSize(new Dimension(1366, 718));
        mainPane.setPreferredSize(new Dimension(500, 708));
        top.setPreferredSize(new Dimension(50, 10));

        getContentPane().add(main);
        main.add(mainPane, BorderLayout.SOUTH);
        main.add(top, BorderLayout.NORTH);

        jTextField1.setText("jTextField1");
        jTextField1.setBounds(0, 0, 30, 30);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        //  jScrollBar1.setViewportView(jTextField1);

        mainPane.addTab("Default", jScrollBar1);

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    Document getPage(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void update(Document page) {
        //TODO: main rendering of page
    }
    private JMenuBar jMenuBar1, jMenuBar2;
    private JScrollPane jScrollBar1;
    private JSeparator jSeparator1;
    private JTabbedPane mainPane;
    private JTextField jTextField1;
    private JPopupMenu settingsMenu;
    private JPanel main, top;
    public boolean isAscii;
}
