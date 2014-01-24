package browser;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    private JTabbedPane contentPane;
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
        
        /*new Thread(){
            //TODO: Updating titles and other stuff
            public void run(){
                for(; ; ){
                    for(int i = 0; i < contentPane.getTabCount(); i++) contentPane.setTitleAt(i, ((Tab)contentPane.getComponentAt(i)).);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }                
            }
        }.start();*/

    }

    public void newTab() {
        Tab t = new Tab();
        contentPane.addTab("New Tab", t);
        contentPane.setTabComponentAt(t.getIndex(),t.tabComp);
    }
    

}