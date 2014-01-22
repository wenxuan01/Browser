package browser;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.*;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

public class Tab extends JPanel {

    static int index = -1;
    int i;

    public Tab() {
        index++;
        setLayout(new BorderLayout());

        JScrollPane main = new JScrollPane();
        JPanel top = new JPanel();
        final JTextField url = new JTextField();
        
        url.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == 13) {
                    update(url.getText());
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }

        });
        
        top.setLayout(null);
        url.setSize(500,50);
        top.add(url);
        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = new int[800];
        gbl.rowHeights = new int[600];
        for (int i = 0; i < gbl.columnWidths.length; i++) {
            gbl.columnWidths[i] = 1;
        }
        for (int i = 0; i < gbl.rowHeights.length; i++) {
            gbl.rowHeights[i] = 1;
        }
        JPanel html = new JPanel(gbl);
        html.add(new JTextField());
        main.setViewportView(html);
/*
        GridBagConstraints gbc_top = new GridBagConstraints();
        gbc_top.gridx = 0;
        gbc_top.gridy = 0;
        gbc_top.gridheight = 2;
        gbc_top.gridwidth = 8;
        gbc_top.weightx = 0;
        gbc_top.weighty = 0;*/

        this.add(top, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        this.i = index;
    }

    public int getIndex() {
        return this.i;
    }

    private void update(String url) {
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Connected to " + url);
    }
}
