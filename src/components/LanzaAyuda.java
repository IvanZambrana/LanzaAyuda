
package components;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


public class LanzaAyuda {
    JTextArea output;
    JScrollPane scrollPane;
    
    public HelpSet obtenFicAyuda(){
        try {
            ClassLoader cl = LanzaAyuda.class.getClassLoader();
            File file = new  File(LanzaAyuda.class.getResource("help/fichero_helpset.hs").getFile());
            URL url = file.toURI().toURL();
            // crea un objeto Helpset
            HelpSet hs = new HelpSet(null,url);
            return hs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Fichero HelpSet no encontrado");
            return null;
        }
    }   

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem1, menuItem2;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("Ayuda");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem1 = new JMenuItem("Contenido de Ayuda");
        menuItem2 = new JMenuItem("About");
        
        //Creamos HelpBroker
        HelpSet hs = obtenFicAyuda();
        HelpBroker hb = hs.createHelpBroker();
        
        //Asociamos la ayuda a un elemento del menú
        hb.enableHelpOnButton(menuItem1, "ayuda", hs);
        
        //Hacer que el componente responda a la pulsación de la tecla F1
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        
        
        menu.add(menuItem1);
        menu.add(menuItem2);

        menuBar.add(menu);

        return menuBar;
    }

    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

 
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Aplicación Swing con Ayuda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        LanzaAyuda demo = new LanzaAyuda();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());

        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
