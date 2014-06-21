
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
				
				
				System.out.println("-3");
				jframe.add(kcms);
				
				//jframe.setSize(1000, 1000);
				System.out.println("-2");
				jframe.pack();
				System.out.println("-1");
				jframe.setVisible(true);
                                System.out.println("0");
                                JFrame jframe2 = new JFrame();
                                System.out.println("1");
                                jframe2.add(kcms);
                                System.out.println("2");
                                jframe2.pack();
                                System.out.println("2.5");
                                jframe2.setVisible(true);
                                System.out.println("3");
                                
			}
		});
	}
}
