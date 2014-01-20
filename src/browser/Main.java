package browser;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    private JTabbedPane contentPane;
    private JButton settingsBtn;

    private JScrollPane main;

    public Main() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        pack();
        setVisible(true);
    }

//http://www.javaworld.com/article/2076095/core-java/download-a-website-for-offline-browsing.html
    private void initComponents() {
        contentPane = new JTabbedPane();

        setContentPane(contentPane);
        JPanel top = new JPanel();
        settingsBtn = new JButton();

        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = new int[]{100, 100, 100, 100, 100, 100, 100, 100}; // SUM = 800
        gbl.rowHeights = new int[]{100, 100, 100, 100, 100, 100, 100}; //SUM = 600

        GridBagConstraints gbc_top = new GridBagConstraints();
        gbc_top.gridx = 0;
        gbc_top.gridy = 0;
        gbc_top.gridheight = 2;
        gbc_top.gridwidth = 2;
        gbc_top.weightx = 0;
        gbc_top.weighty = 0;
        top.setLayout(null);
        contentPane.add(top, gbc_top);

    }

    public void newTab() {
        JScrollPane main = new JScrollPane();        
        JPanel top = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = new int[]{100, 100, 100, 100, 100, 100, 100, 100}; // SUM = 800
        gbl.rowHeights = new int[]{100, 100, 100, 100, 100, 100, 100}; //SUM = 600
        main.setViewportView(null);
        

        GridBagConstraints gbc_top = new GridBagConstraints();
        gbc_top.gridx = 0;
        gbc_top.gridy = 0;
        gbc_top.gridheight = 2;
        gbc_top.gridwidth = 2;
        gbc_top.weightx = 0;
        gbc_top.weighty = 0;
        top.setLayout(null);

    }
}
