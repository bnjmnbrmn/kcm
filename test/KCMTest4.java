
import edu.uiowa.cs.baberman.kcm.basic.BasicKCMS;
import edu.uiowa.cs.baberman.kcm.basic.RootBasicKC;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorListener;

/**
 *
 * @author bnjmnbrmn
 */
public class KCMTest4 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jframe = new JFrame("KCM Test");
                jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                RootBasicKC root = new RootBasicKC();

                BasicKCMS kcms
                        = new BasicKCMS(root);

                
                jframe.add(kcms);
                jframe.pack();
                jframe.setVisible(true);
            }
        });
    }
}
