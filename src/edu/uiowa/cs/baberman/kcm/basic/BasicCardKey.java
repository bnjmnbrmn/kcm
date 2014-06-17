package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.CardKey;
import java.awt.Color;
import java.awt.Paint;
import org.piccolo2d.PNode;

/**
 *
 * @author bnjmnbrmn
 */
public abstract class BasicCardKey implements CardKey {

    public static final double OUTER_WIDTH = 110;
    public static final double OUTER_HEIGHT = 110;
    public static final double INNER_WIDTH = 100;
    public static final double INNER_HEIGHT = 100;
    
    public static final Color DEFAULT_OUTER_COLOR = Color.DARK_GRAY;
    
    
    private final PNode node;

    public BasicCardKey() {
        node = new PNode();
    }

    PNode getNode() {
        return node;
    }

    
    abstract void setOuterPaint(Paint paint);
}
