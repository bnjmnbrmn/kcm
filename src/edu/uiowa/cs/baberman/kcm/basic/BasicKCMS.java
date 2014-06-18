package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.KeyboardCard;
import edu.uiowa.cs.baberman.kcm.KeyboardCardMenuSystem;
import edu.uiowa.cs.baberman.kcm.basic.BasicKC.KeyPosition;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import org.piccolo2d.PCanvas;

/**
 *
 * @author bnjmnbrmn
 */
public class BasicKCMS extends KeyboardCardMenuSystem {

    public static final double CARD_STACK_X_OFFSET = 10;
    public static final double CARD_STACK_Y_OFFSET = 10;

    public static final double BORDER_WIDTH = 10;

    private PCanvas canvas;

    PCanvas getCanvas() {
        return canvas;
    }

    private KeyboardCard currentRoot;
    private List<KeyboardCard> roots;

    public BasicKCMS(RootBasicKC rootCard) {
        super();

        canvas = new PCanvas();

        canvas.getLayer().addChild(rootCard.getNode());

        add(canvas, BorderLayout.CENTER);

        setPreferredSize(
                new Dimension((int) (rootCard.getWidth() + 2 * CARD_STACK_X_OFFSET + BORDER_WIDTH),
                        (int) (rootCard.getHeight() + 2 * CARD_STACK_Y_OFFSET + BORDER_WIDTH))
        );

        canvas.setZoomEventHandler(null);
        canvas.setPanEventHandler(null);

        setInputAndActionMaps();
    }
    
    private void setInputAndActionMaps() {
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();
        
        for (KeyPosition kp : BasicKC.KeyPosition.values()) {
            im.put(KeyStroke.getKeyStroke(kp.getVK_CODE(), 0, false),kp.getKeyLabel()+"Pressed");
            
            am.put(kp.getKeyLabel()+"Pressed", new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //TO DO
                }
            });
            
            im.put(KeyStroke.getKeyStroke(kp.getVK_CODE(), 0, true), kp.getKeyLabel()+"Released");
            
            am.put(kp.getKeyLabel()+"Released", new AbstractAction() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //TO DO
                }
            });
        }
    }

    @Override
    public void setCurrentRoot(KeyboardCard root) {
        if (roots.contains(root)) {
            this.currentRoot = root;
        }
    }

    @Override
    public KeyboardCard getCurrentRoot() {
        return currentRoot;
    }

    @Override
    public KeyboardCard[] getRoots() {
        KeyboardCard[] toReturn = new KeyboardCard[roots.size()];
        return roots.toArray(toReturn);
    }

    @Override
    public void addRoot(KeyboardCard root) {
        roots.add(root);
    }

    @Override
    public void removeRoot(KeyboardCard root) {
        roots.remove(root);
    }

}
