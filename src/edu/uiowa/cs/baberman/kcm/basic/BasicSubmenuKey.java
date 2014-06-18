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

    private BasicKC submenu;

    public BasicKC getSubmenu() {
        return submenu;
    }

    public void setSubmenu(BasicKC submenu) {
        this.submenu = submenu;
    }
    
    public BasicSubmenuKey(Color outerColor, Color innerColor,
            String positionLabelText, String itemLabelText) {
        super(outerColor, innerColor, positionLabelText, itemLabelText);
    }

    public BasicSubmenuKey(String positionLabelText, String itemLabelText) {
        super(positionLabelText, itemLabelText);
    }
}
