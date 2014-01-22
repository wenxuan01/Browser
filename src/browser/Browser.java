package browser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class Browser extends JFrame {

    public Browser() {
        
    }

    public static void main(String[] args) {
        new Main();
    }


    Document getPage(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    
}
