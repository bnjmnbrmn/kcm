package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.BlankKey;
import org.piccolo2d.nodes.PPath;

/**
 *
 * @author bnjmnbrmn
 */
public class BasicBlankKey extends BasicCardKey implements BlankKey {

	public BasicBlankKey(BasicKC card) {
		super(card);
		PPath square = PPath.createRectangle(0, 0, BasicCardKey.DEFAULT_KEY_WIDTH, BasicCardKey.DEFAULT_KEY_HEIGHT);
		square.setPaint(card.backgroundColor);
		getNode().addChild(square);
	}

}
