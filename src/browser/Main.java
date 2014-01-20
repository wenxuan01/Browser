package browser;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    private JTabbedPane contentPane;

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
       // top.setLayout(null);

    }

    public void newTab() {
        JPanel page = new JPanel(new BorderLayout());
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

        page.add(top,BorderLayout.NORTH);
        page.add(main,BorderLayout.SOUTH);
        contentPane.addTab("New Tab",page);
    }
}
