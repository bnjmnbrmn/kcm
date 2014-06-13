package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.LeafKey;
import javax.swing.Action;

/**
 *
 * @author bnjmnbrmn
 */
public class BasicLeafKey extends BasicCardKey implements LeafKey {

	public BasicLeafKey(BasicKC card) {
		super(card);
	}

	@Override
	public Action[] getActions() {
		//TODO
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
