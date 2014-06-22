package edu.uiowa.cs.baberman.kcm;

import java.awt.Color;
import javax.swing.Action;

/**
 * 
 * 
 *
 * @author bnjmnbrmn
 */
public class SubmenuKey extends ActionKey {

    private ThirtyKeyKC submenu;

    public ThirtyKeyKC getSubmenu() {
        return submenu;
    }

    public void setSubmenu(ThirtyKeyKC submenu) {
        this.submenu = submenu;
    }
    
    public SubmenuKey(Color outerColor, Color innerColor,
            String positionLabelText, String itemLabelText) {
        super(outerColor, innerColor, positionLabelText, itemLabelText);
    }

    public SubmenuKey(String positionLabelText, String itemLabelText) {
        super(positionLabelText, itemLabelText);
    }
}
