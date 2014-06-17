/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.ActionKey;
import java.awt.Color;
import javax.swing.Action;
import org.piccolo2d.nodes.PText;

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
        itemLabel = new PText(itemLabelText);
        getNode().addChild(positionLabel);
        getNode().addChild(itemLabel);
        
    }
    
    @Override
    public Action[] getPreDisplayActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Action[] getPostDisplayActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


}
