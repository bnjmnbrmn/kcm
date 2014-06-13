package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.SubmenuKey;
import javax.swing.Action;

/**
 *
 * @author bnjmnbrmn
 */
public class BasicSubmenuKey extends BasicCardKey implements SubmenuKey {

	public BasicSubmenuKey(BasicKC card) {
		super(card);
	}

	@Override
	public Action[] getActions() {
		//TODO
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Action[] getPreSubmenuDisplayActions() {
		//TODO
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Action[] getPostSubmenuDisplayActions() {
		//TODO
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
