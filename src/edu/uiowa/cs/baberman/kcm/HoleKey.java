package edu.uiowa.cs.baberman.kcm;

import java.awt.Paint;
import org.piccolo2d.nodes.PPath;

/**
 *
 * @author bnjmnbrmn
 */
class HoleKey extends CardKey {

    private final PPath top;
    private final PPath bottom;
    private final PPath left;
    private final PPath right;

    HoleKey(Paint outerKeyPaint) {

        final double horizontalBarHeight = (OUTER_HEIGHT - INNER_HEIGHT) / 2;
        final double verticalBarWidth = (OUTER_WIDTH - INNER_WIDTH) / 2;
        final double verticalBarHeight = OUTER_HEIGHT - 2*horizontalBarHeight;
        
        top = PPath.createRectangle(0, 0,
                OUTER_WIDTH, horizontalBarHeight);
        bottom = PPath.createRectangle(0, OUTER_HEIGHT - horizontalBarHeight,
                OUTER_WIDTH, horizontalBarHeight);
        left = PPath.createRectangle(0, horizontalBarHeight,
                verticalBarWidth,verticalBarHeight);
        right = PPath.createRectangle(OUTER_WIDTH - verticalBarWidth, 
                horizontalBarHeight, verticalBarWidth, verticalBarHeight);
        
        setOuterPaint(outerKeyPaint);
        
        getNode().addChild(top);
        getNode().addChild(bottom);
        getNode().addChild(left);
        getNode().addChild(right);
    }

    @Override
    void setOuterPaint(Paint paint) {
        top.setPaint(paint);
        bottom.setPaint(paint);
        left.setPaint(paint);
        right.setPaint(paint);
    }

}
