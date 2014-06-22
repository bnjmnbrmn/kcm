package edu.uiowa.cs.baberman.kcm;

import edu.uiowa.cs.baberman.kcm.ThirtyKeyKC.KeyPosition;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import org.piccolo2d.PCanvas;
import org.piccolo2d.nodes.PText;

/**
 *
 * @author bnjmnbrmn
 */
public class KCMS extends JPanel {

    public static final double CARD_STACK_X_OFFSET = 10;
    public static final double CARD_STACK_Y_OFFSET = 10;

    public static final double BORDER_WIDTH = 10;

    private final PCanvas canvas = new PCanvas();
    private final List<ThirtyKeyKC> roots = new ArrayList<ThirtyKeyKC>();

    PCanvas getCanvas() {
        return canvas;
    }

    private ThirtyKeyKC currentRoot;
    

    public KCMS(ThirtyKeyKC rootCard) {
        super();
        
        canvas.getLayer().addChild(rootCard.getNode());
        
        add(canvas, BorderLayout.CENTER);
        
        canvas.setPreferredSize(
                new Dimension((int) (rootCard.getWidth() + 2 * CARD_STACK_X_OFFSET + BORDER_WIDTH),
                        (int) (rootCard.getHeight() + 2 * CARD_STACK_Y_OFFSET + BORDER_WIDTH))
        );

        canvas.setZoomEventHandler(null);
        canvas.setPanEventHandler(null);

        setInputAndActionMaps();

        if(System.getProperty("os.name").equals("Linux"));
            new LinuxKeyRepeatAdjuster().addAutomaticKeyRepeatOnOff();

    }

    private class LinuxKeyRepeatAdjuster {

        private Container topLevelAncestor = null;

        private WindowAdapter windowFocusAndClosingListener = new WindowAdapter() {

            @Override
            public void windowGainedFocus(WindowEvent e) {
                turnOffKeyRepeat();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                turnOnKeyRepeat();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                turnOnKeyRepeat();
            }

        };

        public void addAutomaticKeyRepeatOnOff() {
            KCMS.this.addHierarchyListener(new HierarchyListener() {

                @Override
                public void hierarchyChanged(HierarchyEvent e) {

                    if (topLevelAncestor != null && topLevelAncestor instanceof Window) {
                        System.out.println("old topLevelAncestor instanceof Window");
                        ((Window) topLevelAncestor).removeWindowFocusListener(windowFocusAndClosingListener);
                        ((Window) topLevelAncestor).removeWindowListener(windowFocusAndClosingListener);
                    }
                    //TO DO:  take care of case where topLevelAncestor is an Applet

                    topLevelAncestor = KCMS.this.getTopLevelAncestor();

                    if (topLevelAncestor != null && topLevelAncestor instanceof Window) {
                        System.out.println("new topLevelAncestor instanceof Window");
                        ((Window) topLevelAncestor).addWindowFocusListener(windowFocusAndClosingListener);
                        ((Window) topLevelAncestor).addWindowListener(windowFocusAndClosingListener);
                    }
                    //TO DO:  take care of case where topLevelAncestor is an Applet
                }

            });
        }

        private void turnOffKeyRepeat() {
            try {
                System.out.println("Turning off KeyRepeat");
                Runtime.getRuntime().exec("xset -r");
            } catch (IOException ex) {
                Logger.getLogger(KCMS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        private void turnOnKeyRepeat() {
         
            try {
                System.out.println("Turning on KeyRepeat");
                Runtime.getRuntime().exec("xset r");
            } catch (IOException ex) {
                Logger.getLogger(KCMS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

    private void setInputAndActionMaps() {
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();
        
        for (final KeyPosition kp : ThirtyKeyKC.KeyPosition.values()) {
            im.put(KeyStroke.getKeyStroke(kp.getVK_CODE(), 0, false), kp.getKeyLabel() + "Pressed");

            am.put(kp.getKeyLabel() + "Pressed", new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            });

            im.put(KeyStroke.getKeyStroke(kp.getVK_CODE(), 0, true), kp.getKeyLabel() + "Released");

            am.put(kp.getKeyLabel() + "Released", new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(kp.getKeyLabel() + "Released");
                }
            });
        }
    }


    public void setCurrentRoot(ThirtyKeyKC root) {
        if (roots.contains(root)) {
            this.currentRoot = root;
        } else {
            throw new RuntimeException("Tried to set the current root to one that had not been added");
        }
    }

    
    public ThirtyKeyKC getCurrentRoot() {
        return currentRoot;
    }

    public ThirtyKeyKC[] getRoots() {
        ThirtyKeyKC[] toReturn = new ThirtyKeyKC[roots.size()];
        return roots.toArray(toReturn);
    }

    public void addRoot(ThirtyKeyKC root) {
        roots.add(root);
    }

    public void removeRoot(ThirtyKeyKC root) {
        roots.remove(root);
    }

}