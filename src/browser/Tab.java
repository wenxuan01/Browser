package browser;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.apache.commons.validator.routines.UrlValidator;
import net.sf.image4j.codec.ico.ICODecoder;

public class Tab extends JPanel {

    public static List<String> history = new ArrayList<>();
    public JLabel tabComp = new JLabel();
    final JTextField url_ = new JTextField();

    public Tab() {
        tabComp.setText("New Tab");
        setLayout(new BorderLayout());

        JScrollPane main = new JScrollPane();
        JPanel top = new JPanel();

        url_.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == 10) {
                    String url = url_.getText();
                    UrlValidator validator = new UrlValidator();
                    if (validator.isValid(url) || validator.isValid("http://" + url) || validator.isValid("http://www." + url)) {
                        if (!url.startsWith("www.")) {
                            url = "www." + url;
                        }
                        if (!url.startsWith("http://")) {
                            url = "http://" + url;
                        }
                    } else {
                        url = "http://www.google.com/search?q=" + url;
                    }
                    boolean connected = update(url);
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });

        top.setLayout(new BorderLayout());
        top.setPreferredSize(new Dimension(500, 30));
        url_.setPreferredSize(new Dimension(200, 20));
        top.add(url_, BorderLayout.CENTER);
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

    }

    private boolean update(String url) {
        Document doc;
        ImageIcon icon;

        tabComp.setText("Connecting...");
        tabComp.setIcon(Main.icons.get("Loading_Animation"));

        history.add(url);
        try {
            System.out.println("Attempting to connect to " + url);
            doc = Jsoup.connect(url).userAgent("Mozilla").timeout(10 * 1000).get();
            System.out.println("Connected to " + url);
        } catch (IOException e) {
            System.err.println(e);
            System.out.println("Failed to connect to " + url);
            System.out.println();
            return false;
        }

        tabComp.setText(doc.title());
        String iconurl;

        try {
            iconurl = doc.head().select("meta[itemprop=image]").first().attr("abs:content");
        } catch (NullPointerException e) {
            try {
                iconurl = doc.head().select("link[href~=.*\\.(ico|png)]").first().attr("abs:href");
            } catch (NullPointerException ex) {
                iconurl = doc.baseUri() + "/favicon.ico"; // Unreliable, used as last resort

            }
        }

        System.out.println("Resolved icon url: " + iconurl);

        if (iconurl.endsWith(".ico")) {
            try {
                icon = new ImageIcon(ICODecoder.read(new URL(iconurl).openStream()).get(0));
                tabComp.setIcon(icon);
            } catch (IOException ex) {
                System.err.println(ex);
                System.out.println("Failed to parse icon from " + iconurl);
            }
        } else if (iconurl.endsWith(".png")) {
            try {
                BufferedImage b = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = b.createGraphics();
                g.drawImage(ImageIO.read(new URL(iconurl).openStream()), 0, 0, b.getWidth(), b.getHeight(), this);
                icon = new ImageIcon(b);
                tabComp.setIcon(icon);
            } catch (IOException ex) {
                System.out.println("Failed to parse icon from " + iconurl);
            }
        }
        System.out.println();
        return true;
    }
}
