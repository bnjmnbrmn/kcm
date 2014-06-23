package edu.uiowa.cs.baberman.kcm;

import java.awt.Paint;
import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;

/**
 *
 * @author bnjmnbrmn
 */
class HoleKey extends CardKey  {

	private PNode frame;
	
	private PPath top;
	private PPath bottom;
	private PPath left;
	private PPath right;
	
	HoleKey(Paint outerKeyPaint) {
		top = PPath.createRectangle(0, 0, 
				OUTER_WIDTH, (OUTER_HEIGHT-INNER_HEIGHT)/2);
		bottom = PPath.createRectangle(0,
				OUTER_HEIGHT - (OUTER_HEIGHT - INNER_HEIGHT)/2,
				OUTER_WIDTH, (OUTER_HEIGHT-INNER_HEIGHT)/2);
	}

    @Override
    void setOuterPaint(Paint paint) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	
}
