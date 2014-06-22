package edu.uiowa.cs.baberman.kcm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Action;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

/**
 *
 * @author bnjmnbrmn
 */
public abstract class ActionKey extends NonHoleKey {

    private PText positionLabel; //typically a single, large charater
    private PText itemLabel; //i.e. menu item label (like "File" or "Open")

    public ActionKey(Color outerColor, Color innerColor,
            String positionLabelText, String itemLabelText) {
        super(outerColor, innerColor);

        positionLabel = new PText(positionLabelText);
        adjustPositionLabel(positionLabel);
        getNode().addChild(positionLabel);

        setMenuItemText(itemLabelText);
//        itemLabel = new PText(itemLabelText);
//        adjustItemLabel(itemLabel);
//        getNode().addChild(itemLabel);
    }

    
    public ActionKey setMenuItemText(String itemText) {
        if (positionLabel != null) {
            getNode().removeChild(itemLabel);
        }
        itemLabel = new PText(itemText);
        adjustItemLabel(itemLabel);
        getNode().addChild(itemLabel);
        return this;
    }

    private void adjustPositionLabel(PText positionLabel) {
        positionLabel.setTextPaint(Color.WHITE);

        double xOffset = 10;
        double yOffset = 5;

        positionLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN,
                26));

        positionLabel.setOffset(xOffset, yOffset);

    }

    private void adjustItemLabel(PText itemLabel) {
        itemLabel.setHorizontalAlignment(Component.CENTER_ALIGNMENT);
        itemLabel.setFont(
                itemLabel.getFont()
                .deriveFont(Font.BOLD)
                .deriveFont((float) 14.0));

        itemLabel.setConstrainWidthToTextWidth(false);

        itemLabel.setWidth(INNER_WIDTH);
        itemLabel.setHeight(INNER_HEIGHT);

        itemLabel.setOffset(OUTER_WIDTH / 2 - itemLabel.getWidth() / 2,
                OUTER_HEIGHT / 2 - itemLabel.getHeight() / 2);

    }

    public ActionKey(String positionLabelText, String itemLabelText) {
        this(DEFAULT_OUTER_COLOR, DEFAULT_INNER_COLOR,
                positionLabelText, itemLabelText);
    }

    private List<Action> preDisplayActions = new ArrayList<Action>();

    public List<Action> getPreDisplayActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<Action> actions = new ArrayList<Action>();

    public List<Action> getActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ActionKey addAction(Action action) {
        actions.add(action);
        return this;
    }

    public ActionKey addPreDisplayAction(Action action) {
        preDisplayActions.add(action);
        return this;
    }

}
