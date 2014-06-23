package edu.uiowa.cs.baberman.kcm;

import java.awt.Color;
import java.awt.Paint;
import javax.swing.Action;

/**
 * 
 * 
 *
 * @author bnjmnbrmn
 */
public class SubmenuKey<C extends KeyboardCard<C>> extends ActionKey {

    private final KeyboardCard<C> submenu;

    public KeyboardCard<C> getSubmenu() {
        return submenu;
    }

    
    SubmenuKey(Paint outerPaint, Paint innerPaint,
            String positionLabelText, String itemLabelText, KeyboardCard<C> card, Integer keyCode) {
        super(outerPaint, innerPaint, positionLabelText, itemLabelText);
		
		if (!card.getKeyCodes().contains(keyCode))
			throw new RuntimeException("Bad keyCode given to constructor");
		
//		KeyboardCard<C> createSubmenu = card.createSubmenu(keyCode);
				submenu = card.createSubmenu(keyCode);
    }

//    SubmenuKey(String positionLabelText, String itemLabelText) {
//        super(positionLabelText, itemLabelText);
//    }
}
