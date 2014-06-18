package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.NonHoleKey;
import java.awt.Color;
import java.awt.Paint;
import org.piccolo2d.nodes.PPath;

/**
 *
 * @author bnjmnbrmn
 */
public abstract class BasicNonHoleKey extends BasicCardKey implements NonHoleKey {

    public static final Color DEFAULT_INNER_COLOR = Color.LIGHT_GRAY;

    private PPath outerSquare;

    PPath getOuterSquare() {
        return outerSquare;
    }

    void setOuterSquare(PPath outerSquare) {
        this.outerSquare = outerSquare;
    }

    private PPath innerSquare;

    PPath getInnerSquare() {
        return innerSquare;
    }

    void setInnerSquare(PPath innerSquare) {
        this.innerSquare = innerSquare;
    }

    public BasicNonHoleKey(Color outerColor, Color innerColor) {
        outerSquare = PPath.createRectangle(
                0, 0, OUTER_WIDTH, OUTER_HEIGHT);
        outerSquare.setStrokePaint(outerColor);
        outerSquare.setPaint(outerColor);
        getNode().addChild(outerSquare);

        innerSquare = PPath.createRectangle(
                (OUTER_WIDTH - INNER_WIDTH) / 2.0,
                (OUTER_HEIGHT - INNER_HEIGHT) / 2.0,
                INNER_WIDTH,
                INNER_HEIGHT);
        innerSquare.setPaint(innerColor);
        getNode().addChild(innerSquare);
    }

    BasicNonHoleKey() {
        outerSquare = PPath.createRectangle(
                0, 0, OUTER_WIDTH, OUTER_HEIGHT);
        outerSquare.setStrokePaint(DEFAULT_OUTER_COLOR);
        outerSquare.setPaint(DEFAULT_OUTER_COLOR);
        getNode().addChild(outerSquare);

        innerSquare = PPath.createRectangle(
                (OUTER_WIDTH - INNER_WIDTH) / 2.0,
                (OUTER_HEIGHT - INNER_HEIGHT) / 2.0,
                INNER_WIDTH,
                INNER_HEIGHT);
        innerSquare.setPaint(DEFAULT_INNER_COLOR);
        getNode().addChild(innerSquare);
    }

    @Override
    void setOuterPaint(Paint paint) {
        outerSquare.setPaint(paint);
        outerSquare.setStrokePaint(paint);
    }
    
    void setInnerPaint(Paint paint) {
        innerSquare.setPaint(paint);
    }

    
}
