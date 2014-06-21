
import edu.uiowa.cs.baberman.kcm.basic.BasicKC;
import edu.uiowa.cs.baberman.kcm.basic.BasicKCMS;
import edu.uiowa.cs.baberman.kcm.basic.BasicLeafKey;
import edu.uiowa.cs.baberman.kcm.basic.BasicSubmenuKey;
import edu.uiowa.cs.baberman.kcm.basic.RootBasicKC;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author bnjmnbrmn
 */
public class KCMTest3 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame jframe = new JFrame("KCM Test");
                jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jframe.addFocusListener(new FocusListener() {

                    @Override
                    public void focusGained(FocusEvent e) {
                        try {
                            Runtime.getRuntime().exec("xset -r");
                            System.out.println("focus gained");
                        } catch (IOException ex) {
                            Logger.getLogger(KCMTest3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        try {
                            Runtime.getRuntime().exec("xset r");
                            System.out.println("focus lost");
                        } catch (IOException ex) {
                            Logger.getLogger(KCMTest3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                jframe.addWindowFocusListener(new WindowFocusListener() {

                    @Override
                    public void windowGainedFocus(WindowEvent e) {
                        try {
                            System.out.println("window gained focus");
                            Runtime.getRuntime().exec("xset -r");
                        } catch (IOException ex) {
                            Logger.getLogger(KCMTest3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    @Override
                    public void windowLostFocus(WindowEvent e) {
                        try {
                            System.out.println("window lost focus");
                            Runtime.getRuntime().exec("xset r");
                        } catch (IOException ex) {
                            Logger.getLogger(KCMTest3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                jframe.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.out.println("Window closing");
                        try {
                            Runtime.getRuntime().exec("xset r");
                        } catch (IOException ex) {
                            Logger.getLogger(KCMTest3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                RootBasicKC root = new RootBasicKC();

                root.setKey(BasicKC.KeyPosition.Q, new BasicLeafKey("Q", "Testtesttesttesttest"));

//                
//                BasicSubmenuKey ska = root.putNewSubmenu(BasicKC.KeyPosition.A, "A", "Test submenu");
//                
//                ska.addAction(new AbstractAction() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        System.out.println("submenu Action performed");
//                    }
//                    
//                });
//                
//                ska.addPreAction(new AbstractAction() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        System.out.println("submenu PreAction performed");
//                    }
//                    
//                });
//                
//                BasicKC sma = ska.getSubmenu();
                BasicKCMS kcms
                        = new BasicKCMS(root);
                
                jframe.add(kcms);

                jframe.pack();

                jframe.setVisible(true);
            }
        });
    }
}
