package edu.uiowa.cs.baberman.kcm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Component;
import java.awt.Font;
import java.awt.Paint;
import java.awt.event.ActionEvent;
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
abstract class ActionKey extends NonHoleKey {

    private PText positionLabel; //typically a single, large charater
    private PText itemLabel; //i.e. menu item label (like "File" or "Open")

    ActionKey(Paint outerPaint, Paint innerPaint,
            String positionLabelText, String itemLabelText) {
        super(outerPaint, innerPaint);

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

    private final List<Action> preDisplayPressActions = new ArrayList<Action>();

    public List<Action> getPreDisplayPressActions() {
        return preDisplayPressActions;
    }

    public ActionKey addPreDisplayPressAction(Action action) {
        preDisplayPressActions.add(action);
        return this;
    }

    public void performPreDisplayPressActions(ActionEvent e) {
        for (Action action : preDisplayPressActions) {
            action.actionPerformed(e);
        }
    }

    private final List<Action> pressActions = new ArrayList<Action>();

    public List<Action> getPressActions() {
        return pressActions;
    }

    public ActionKey addPressAction(Action action) {
        pressActions.add(action);
        return this;
    }

    public void performPressActions(ActionEvent e) {
        for (Action action : pressActions) {
            action.actionPerformed(e);
        }
    }

    private final List<Action> preDisplayReleaseActions
            = new ArrayList<Action>();

    public List<Action> getPreDisplayReleaseActions() {
        return preDisplayReleaseActions;
    }

    public ActionKey addPreDisplayReleaseAction(Action action) {
        preDisplayReleaseActions.add(action);
        return this;
    }

    public void performPreDisplayReleaseActions(ActionEvent e) {
        for (Action action : preDisplayReleaseActions) {
            action.actionPerformed(e);
        }
    }

    private final List<Action> releaseActions
            = new ArrayList<Action>();

    public List<Action> getReleaseActions() {
        return releaseActions;
    }

    public ActionKey addReleaseAction(Action action) {
        releaseActions.add(action);
        return this;
    }

    public void performReleaseActions(ActionEvent e) {
        for (Action action : releaseActions) {
            action.actionPerformed(e);
        }
    }

    private boolean isActive = true;

    void setActive() {
        itemLabel.setTextPaint(Color.BLACK);
        isActive = true;
    }

    void setInactive() {
        itemLabel.setTextPaint(Color.GRAY);
        isActive = false;
    }

    boolean isActive() {
        return isActive;
    }

    private boolean isPressed = false;

    void setPressed() {
        getInnerSquare().setStroke(new BasicStroke(3.0f));
        isPressed = true;
    }

    void setReleased() {
        getInnerSquare().setStroke(new BasicStroke(1.0f));
        isPressed = false;
    }

    boolean isPressed() {
        return isPressed;
    }
}
