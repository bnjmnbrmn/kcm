package edu.uiowa.cs.baberman.kcm;

import java.awt.Color;
import java.awt.Paint;
import javax.swing.Action;
import org.piccolo2d.nodes.PImage;

/**
 *
 *
 *
 * @author bnjmnbrmn
 */
public class SubmenuKey<C extends KeyboardCard<C>> extends ActionKey {

    private final C submenu;
	
	private final PImage arrow;

    public C getSubmenu() {
        return submenu;
    }

    SubmenuKey(Paint outerPaint, Paint innerPaint,
            String positionLabelText, String itemLabelText, KeyboardCard<C> card, Integer keyCode) {
        super(outerPaint, innerPaint, positionLabelText, itemLabelText);

        if (!card.getKeyCodes().contains(keyCode)) {
            throw new RuntimeException("Bad keyCode given to constructor");
        }

        submenu = card.createSubmenu(keyCode);
		
		arrow = new PImage("submenu_arrow.png");
		final double scale = .5;
		arrow.setBounds(
				OUTER_WIDTH-arrow.getWidth()*scale-((OUTER_WIDTH-INNER_WIDTH)/2)-1,
				OUTER_HEIGHT-arrow.getHeight()*scale-((OUTER_HEIGHT-INNER_HEIGHT)/2)-1, 
				arrow.getWidth()*scale, arrow.getHeight()*scale);
		getNode().addChild(arrow);
    }

    @Override
    public SubmenuKey setMenuItemText(String itemText) {
        super.setMenuItemText(itemText);
        return this;
    }

    @Override
    public SubmenuKey addPreDisplayPressAction(Action action) {
        super.addPreDisplayPressAction(action);
        return this;
    }

    @Override
    public SubmenuKey addPressAction(Action action) {
        super.addPressAction(action);
        return this;
    }

    @Override
    public SubmenuKey addPreDisplayReleaseAction(Action action) {
        super.addPreDisplayReleaseAction(action);
        return this;
    }

    @Override
    public SubmenuKey addReleaseAction(Action action) {
        super.addReleaseAction(action);
        return this;
    }
}
