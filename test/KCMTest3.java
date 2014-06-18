
import edu.uiowa.cs.baberman.kcm.basic.BasicKC;
import edu.uiowa.cs.baberman.kcm.basic.BasicKCMS;
import edu.uiowa.cs.baberman.kcm.basic.BasicLeafKey;
import edu.uiowa.cs.baberman.kcm.basic.BasicSubmenuKey;
import edu.uiowa.cs.baberman.kcm.basic.RootBasicKC;
import java.awt.event.ActionEvent;
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

                RootBasicKC root = new RootBasicKC();

                BasicLeafKey lkq = root.putNewLeaf(BasicKC.KeyPosition.Q)
                        .setMenuItemText("Test Label")
                        .addAction(new AbstractAction() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("Action performed");
                            }

                        }).addPreDisplayAction(new AbstractAction() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("PreAction performed");
                            }

                        });

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
