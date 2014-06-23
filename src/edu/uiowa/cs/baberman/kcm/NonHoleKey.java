package edu.uiowa.cs.baberman.kcm;

import java.awt.Color;
import java.awt.Paint;
import org.piccolo2d.nodes.PPath;

/**
 *
 * @author bnjmnbrmn
 */
abstract class NonHoleKey extends CardKey {

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

    NonHoleKey(Paint outerPaint, Paint innerPaint) {
        outerSquare = PPath.createRectangle(
                0, 0, OUTER_WIDTH, OUTER_HEIGHT);
        outerSquare.setStrokePaint(outerPaint);
        outerSquare.setPaint(outerPaint);
        getNode().addChild(outerSquare);

        innerSquare = PPath.createRectangle(
                (OUTER_WIDTH - INNER_WIDTH) / 2.0,
                (OUTER_HEIGHT - INNER_HEIGHT) / 2.0,
                INNER_WIDTH,
                INNER_HEIGHT);
        innerSquare.setPaint(innerPaint);
        getNode().addChild(innerSquare);
    }

    NonHoleKey() {
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
