package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.LeafKey;
import java.awt.Color;
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


}
