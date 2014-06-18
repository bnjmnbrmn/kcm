package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.LeafKey;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 * @author bnjmnbrmn
 */
public class BasicLeafKey extends BasicActionKey implements LeafKey {

    public BasicLeafKey(Color outerColor, Color innerColor,
            String positionLabelText, String itemLabelText) {
        super(outerColor, innerColor, positionLabelText, itemLabelText);
    }
    
    public BasicLeafKey(String positionLabelText, String itemLabelText) {
        super(positionLabelText, itemLabelText);
    }

    @Override
    public BasicLeafKey setMenuItemText(String itemText) {
        super.setMenuItemText(itemText);
        return this;
    }

    @Override
    public BasicLeafKey addAction(Action action) {
        super.addAction(action);
        return this;
    }

    @Override
    public BasicLeafKey addPreDisplayAction(Action action) {
        super.addPreDisplayAction(action);
        return this;
    }
    
    
}
