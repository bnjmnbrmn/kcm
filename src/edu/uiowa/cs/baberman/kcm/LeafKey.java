package edu.uiowa.cs.baberman.kcm;


import java.awt.Color;
import java.awt.Paint;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 * @author bnjmnbrmn
 */
public class LeafKey extends ActionKey {

    LeafKey(Paint outerPaint, Paint innerPaint,
            String positionLabelText, String itemLabelText) {
        super(outerPaint, innerPaint, positionLabelText, itemLabelText);
    }
    
    LeafKey(String positionLabelText, String itemLabelText) {
        super(positionLabelText, itemLabelText);
    }

    @Override
    public LeafKey setMenuItemText(String itemText) {
        super.setMenuItemText(itemText);
        return this;
    }
    
    @Override
    public LeafKey addPreDisplayPressAction(Action action) {
        super.addPreDisplayPressAction(action);
        return this;
    }
    
    @Override
    public LeafKey addPressAction(Action action) {
        super.addPressAction(action);
        return this;
    }

    @Override
    public LeafKey addPreDisplayReleaseAction(Action action) {
        super.addPreDisplayReleaseAction(action);
        return this;
    }

    @Override
    public LeafKey addReleaseAction(Action action) {
        super.addReleaseAction(action);
        return this;
    }
    
}
