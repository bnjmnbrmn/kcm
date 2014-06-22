
import edu.uiowa.cs.baberman.kcm.KCMS;
import edu.uiowa.cs.baberman.kcm.KeyboardCard;
import edu.uiowa.cs.baberman.kcm.ThirtyKey;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
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

                ThirtyKey root 
						= ThirtyKey.createRootCard();

                root.putNewLeaf(KeyEvent.VK_Q)
                        .setMenuItemText("Test");

				root.putNewLeaf(ThirtyKey.KeyPosition.P)
						.setMenuItemText("Test2");
				
                KCMS<ThirtyKey> kcms 
						= new KCMS<ThirtyKey>(root);

                jframe.add(kcms);

                jframe.pack();
                jframe.setVisible(true);

            }
        });
    }
}
