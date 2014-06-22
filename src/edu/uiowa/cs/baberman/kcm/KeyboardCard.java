package edu.uiowa.cs.baberman.kcm;

import java.awt.Color;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.piccolo2d.PNode;
import static java.awt.event.KeyEvent.*;

/**
 *
 * @author bnjmnbrmn
 */
public abstract class KeyboardCard {
	
	static final Color DEFAULT_ROOT_OUTER_KEY_PAINT = new Color(68,41,242);;
	static final Color DEFAULT_ROOT_INNER_KEY_PAINT = new Color(155,142,237);;
	
	abstract double getWidth();
	abstract double getHeight();

	public abstract List<Integer> getKeyCodes();
	public abstract String getKeyLabelForKeyCode(Integer keyCode);
	public abstract Point2D.Double getKeyPositionForKeyCode(Integer keyCode);
	
	private final PNode node = new PNode();
	final PNode getNode() {
		return node;
	}
	
	private final Paint innerKeyPaint;
	public Paint getInnerKeyPaint() {
		return innerKeyPaint;
	}
	
	private final Paint outerKeyPaint;
	public Paint getOuterKeyPaint() {
		return outerKeyPaint;
	}
	
	KeyboardCard(Paint innerKeyPaint, Paint outerKeyPaint) {
		this.innerKeyPaint = innerKeyPaint;
		this.outerKeyPaint = outerKeyPaint;
	}

	private void putKey(Integer keyCode, CardKey key) {
		if (!getKeyCodes().contains(keyCode))
			throw new RuntimeException("Bad key code argument");
		
		if (cardKeysForKeyCodes.get(keyCode) != null) {
			node.removeChild(cardKeysForKeyCodes.get(keyCode).getNode());
		}
		cardKeysForKeyCodes.put(keyCode, key);
		node.addChild(key.getNode());
		Point2D.Double point = getKeyPositionForKeyCode(keyCode);
        key.getNode().translate(point.x, point.y);
	}
	
	public LeafKey putNewLeaf(Integer keyCode) {
		if (!getKeyCodes().contains(keyCode))
			throw new RuntimeException("Bad key code argument");
		
		LeafKey lk = new LeafKey(getOuterKeyPaint(), getInnerKeyPaint(), 
				getKeyLabelForKeyCode(keyCode), "");
		
		putKey(keyCode, lk);
		
		return lk;
	}
	
	public BlankKey putNewBlankKey(Integer keyCode) {
		if (!getKeyCodes().contains(keyCode))
			throw new RuntimeException("Bad key code argument");
		
		BlankKey bk = new BlankKey(getOuterKeyPaint(), getInnerKeyPaint());
		
		putKey(keyCode, bk);
		
		return bk;
	}

	private final Map<Integer,CardKey> cardKeysForKeyCodes 
			= new HashMap<Integer, CardKey>();
}
