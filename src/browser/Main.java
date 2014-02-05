package browser;

import java.io.File;
import java.net.URL;
import javax.swing.*;
import java.util.HashMap;

public class Main extends JFrame {

    private JTabbedPane contentPane;
    private String configFile = System.getProperty("user.dir") + "Configuration.json";
    public static HashMap<String, ImageIcon> icons;

    public Main() {
        initComponents();
        getConfig();
        loadIcons();
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
        JMenuBar menubar = new JMenuBar();
        JMenu tab = new JMenu("Tab");
        contentPane = new JTabbedPane();
        setContentPane(contentPane);

        newTab();
    }

    private void loadIcons() {
        icons = new HashMap<>();
        URL url = this.getClass().getResource("res/icons/");
        String file = url.toString();
        if (file.startsWith("file:/")) {
            file = file.substring(6);
        }
        File dir = new File(file) {

            public boolean isDirectory() {
                return true;
            }

            public boolean isFile() {
                return false;
            }
        };

        System.out.println(dir.toString());
        for (File f : dir.listFiles()) {
            if (f.isFile() && (f.toString().endsWith(".png") || f.toString().endsWith(".gif"))) {
                System.out.println("Loading icon: " + f.toString());
                icons.put(f.getName().substring(0, f.getName().lastIndexOf(".")), new ImageIcon(f.toString()));
            }
        }
        System.out.println("All icons loaded\n");
    }

    public void newTab() {
        Tab t = new Tab();
        contentPane.addTab("New Tab", t);
        contentPane.setTabComponentAt(contentPane.indexOfComponent(t), t.tabComp);
    }

    private void updateConfig() {
    }

    private void getConfig() {
    }
}