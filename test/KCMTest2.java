
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
                
                root.setKey(BasicKC.KeyPosition.Q, new BasicLeafKey("Q", "Testtesttesttesttest"));
                root.setKey(BasicKC.KeyPosition.W, new BasicLeafKey("W", "Test"));
                root.setKey(BasicKC.KeyPosition.E, new BasicLeafKey("E", "Test"));
                root.setKey(BasicKC.KeyPosition.R, new BasicLeafKey("R", "Test"));
                root.setKey(BasicKC.KeyPosition.T, new BasicLeafKey("T", "Test"));
                root.setKey(BasicKC.KeyPosition.Y, new BasicLeafKey("Y", "Test"));
                root.setKey(BasicKC.KeyPosition.U, new BasicLeafKey("U", "Test"));
                root.setKey(BasicKC.KeyPosition.I, new BasicLeafKey("I", "Test"));
                root.setKey(BasicKC.KeyPosition.O, new BasicLeafKey("O", "Test"));
                root.setKey(BasicKC.KeyPosition.P, new BasicLeafKey("P", "Test"));
                root.setKey(BasicKC.KeyPosition.A, new BasicLeafKey("A", "Test"));
                root.setKey(BasicKC.KeyPosition.S, new BasicLeafKey("S", "Test"));
                root.setKey(BasicKC.KeyPosition.D, new BasicLeafKey("D", "Test"));
                root.setKey(BasicKC.KeyPosition.F, new BasicLeafKey("F", "Test"));
                root.setKey(BasicKC.KeyPosition.G, new BasicLeafKey("G", "Test"));
                root.setKey(BasicKC.KeyPosition.H, new BasicLeafKey("H", "Test"));
                root.setKey(BasicKC.KeyPosition.J, new BasicLeafKey("J", "Test"));
                root.setKey(BasicKC.KeyPosition.K, new BasicLeafKey("K", "Test"));
                root.setKey(BasicKC.KeyPosition.L, new BasicLeafKey("L", "Test"));
                root.setKey(BasicKC.KeyPosition.SEMICOLON, new BasicLeafKey(";", "Test"));
                root.setKey(BasicKC.KeyPosition.Z, new BasicLeafKey("Z", "Test"));
                root.setKey(BasicKC.KeyPosition.X, new BasicLeafKey("X", "Test"));
                root.setKey(BasicKC.KeyPosition.C, new BasicLeafKey("C", "Test"));
                root.setKey(BasicKC.KeyPosition.V, new BasicLeafKey("V", "Test"));
                root.setKey(BasicKC.KeyPosition.B, new BasicLeafKey("B", "Test"));
                root.setKey(BasicKC.KeyPosition.N, new BasicLeafKey("N", "Test"));
                root.setKey(BasicKC.KeyPosition.M, new BasicLeafKey("M", "Test"));
                root.setKey(BasicKC.KeyPosition.COMMA, new BasicLeafKey(",", "Test"));
                root.setKey(BasicKC.KeyPosition.PERIOD, new BasicLeafKey(".", "Test"));
                root.setKey(BasicKC.KeyPosition.SLASH, new BasicLeafKey("/", "Testtest test testtest"));
                
                
                
                
                BasicKCMS kcms =
                        new BasicKCMS(root);
                
                jframe.add(kcms);
                
                jframe.pack();
                
                jframe.setVisible(true);
            
            }
            
        });
        
        
       
    }
    
}
