package edu.uiowa.cs.baberman.kcm;

import edu.uiowa.cs.baberman.kcm.ActionKey;
import javax.swing.Action;

/**
 *
 * @author bnjmnbrmn
 */
public interface SubmenuKey extends ActionKey {

	/**
	 * 
	 * @return a list of all {@link Action Action}s performed when selecting the key, in the 
	 * order in which they are performed (first Action at index 0).  This should be
	 * equivalent to {@link #getPreSubmenuDisplayActions()} concatenated with 
	 * {@link #getPostSubmenuDisplayActions()}
	 */
	@Override
	public Action[] getActions();

	public Action[] getPreSubmenuDisplayActions();

	public Action[] getPostSubmenuDisplayActions();
}
