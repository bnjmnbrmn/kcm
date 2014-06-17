package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.SubmenuKey;
import java.awt.Color;
import javax.swing.Action;

/**
 * 
 * 
 *
 * @author bnjmnbrmn
 */
public class BasicSubmenuKey extends BasicActionKey implements SubmenuKey {

    public BasicSubmenuKey(Color outerColor, Color innerColor,
            String positionLabelText, String itemLabelText) {
        super(outerColor, innerColor, positionLabelText, itemLabelText);
    }

}
