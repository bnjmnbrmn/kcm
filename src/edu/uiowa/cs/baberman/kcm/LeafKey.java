package edu.uiowa.cs.baberman.kcm;


import java.awt.Color;
import java.awt.Paint;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 * @author bnjmnbrmn
 */
public class LeafKey extends ActionKey {

    public LeafKey(Paint outerPaint, Paint innerPaint,
            String positionLabelText, String itemLabelText) {
        super(outerPaint, innerPaint, positionLabelText, itemLabelText);
    }
    
    public LeafKey(String positionLabelText, String itemLabelText) {
        super(positionLabelText, itemLabelText);
    }

    @Override
    public LeafKey setMenuItemText(String itemText) {
        super.setMenuItemText(itemText);
        return this;
    }

    @Override
    public LeafKey addAction(Action action) {
        super.addAction(action);
        return this;
    }

    @Override
    public LeafKey addPreDisplayAction(Action action) {
        super.addPreDisplayAction(action);
        return this;
    }
    
    
}
