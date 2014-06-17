package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.BlankKey;
import org.piccolo2d.PNode;

/**
 *
 * @author bnjmnbrmn
 */
public class RootBasicKC extends BasicKC {
	public RootBasicKC() {
		for (BasicKC.KeyPosition keyPosition : KeyPosition.values() ) {
			setKey(keyPosition,new BasicBlankKey(getBackgroundColor(), getKeyColor()));
		}
	}
}
