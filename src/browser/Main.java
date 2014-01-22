package browser;

import java.awt.*;
import javax.swing.*;
import org.jsoup.nodes.Document;

public class Main extends JFrame {

    private JTabbedPane contentPane;
    private int index = -1;
    private Browser browser;

    public Main() {
        browser = new Browser();
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
        
        newTab();

    }

    public void newTab() {        
  
        contentPane.addTab("New Tab",new Tab());
        
    }
    
   
}