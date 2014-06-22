
import edu.uiowa.cs.baberman.kcm.KCMS;
import edu.uiowa.cs.baberman.kcm.ThirtyKeyKC;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.piccolo2d.PCanvas;
import org.piccolo2d.nodes.PPath;

/**
 *
 * @author bnjmnbrmn
 */
public class KCMTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jframe = new JFrame("KCM Test");
                jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ThirtyKeyKC root = ThirtyKeyKC.createRootCard();

                root.putNewLeaf(ThirtyKeyKC.KeyPosition.P)
                        .setMenuItemText("Test");

                KCMS kcms = new KCMS(root);

                jframe.add(kcms);

                jframe.pack();
                jframe.setVisible(true);

            }
        });
    }
}
