

import temp2.KeyboardCardMenuSystem;
import temp2.RootBasicKeyboardCard;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import org.piccolo2d.PCanvas;
import org.piccolo2d.extras.PFrame;
import org.piccolo2d.extras.swing.PCacheCanvas;
import org.piccolo2d.nodes.PText;


/**
 *
 * @author bnjmnbrmn
 */
public class KCMTest1 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame jframe = new JFrame("KCM Test");
				jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				RootBasicKeyboardCard root = new RootBasicKeyboardCard();
				
				KeyboardCardMenuSystem kcms = 
						new KeyboardCardMenuSystem(root); 
				
				
				
				jframe.add(kcms);
				
				jframe.setSize(1000, 1000);
				
				jframe.setVisible(true);
			}
		});
	}
}
