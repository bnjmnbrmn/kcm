
import edu.uiowa.cs.baberman.kcm.basic.BasicKC;
import edu.uiowa.cs.baberman.kcm.basic.BasicKCMS;
import edu.uiowa.cs.baberman.kcm.basic.BasicLeafKey;
import edu.uiowa.cs.baberman.kcm.basic.RootBasicKC;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 *
 * @author bnjmnbrmn
 */
public class KCMTest2 {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jframe = new JFrame("KCM Test");
                jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                RootBasicKC root = new RootBasicKC();
                
                root.setKey(BasicKC.KeyPosition.Q, new BasicLeafKey("Q", "Test"));
                
                
                BasicKCMS kcms =
                        new BasicKCMS(root);
                
                jframe.add(kcms);
                
                jframe.pack();
                
                jframe.setVisible(true);
            
            }
            
        });
        
        
       
    }
    
}
