/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.ActionKey;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Paint;
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
public abstract class BasicActionKey extends BasicNonHoleKey implements ActionKey {


    private PText positionLabel; //typically a single, large charater
    private PText itemLabel; //i.e. menu item label (like "File" or "Open")

    public BasicActionKey(Color outerColor, Color innerColor,
            String positionLabelText, String itemLabelText) {
        super(outerColor, innerColor);

        positionLabel = new PText(positionLabelText);
        adjustPositionLabel(positionLabel);
        getNode().addChild(positionLabel);

        itemLabel = new PText(itemLabelText);
        adjustItemLabel(itemLabel);
        getNode().addChild(itemLabel);
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

    public BasicActionKey(String positionLabelText, String itemLabelText) {
        this(DEFAULT_OUTER_COLOR, DEFAULT_INNER_COLOR,
                positionLabelText, itemLabelText);
    }

    @Override
    public List<Action> getPreDisplayActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Action> getPostDisplayActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
