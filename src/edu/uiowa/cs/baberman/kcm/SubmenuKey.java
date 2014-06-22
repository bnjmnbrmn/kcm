package edu.uiowa.cs.baberman.kcm;

import java.awt.Color;
import javax.swing.Action;

/**
 * 
 * 
 *
 * @author bnjmnbrmn
 */
public class SubmenuKey<C extends KeyboardCard> extends ActionKey {

    private C submenu;

    public C getSubmenu() {
        return submenu;
    }

    public void setSubmenu(C submenu) {
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
