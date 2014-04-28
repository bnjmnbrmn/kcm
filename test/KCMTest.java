
import edu.uiowa.cs.baberman.kcm.basic.BasicKCMS;
import edu.uiowa.cs.baberman.kcm.basic.RootBasicKC;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


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
				
				
				RootBasicKC root = new RootBasicKC();
				
				BasicKCMS kcms = 
						new BasicKCMS(root); 
				
				
				
				jframe.add(kcms);
				
				jframe.setSize(1000, 1000);
				
				jframe.setVisible(true);
			}
		});
	}
}
