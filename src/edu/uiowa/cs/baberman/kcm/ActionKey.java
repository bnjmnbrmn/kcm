package edu.uiowa.cs.baberman.kcm;

import javax.swing.Action;

/**
 *
 * This should not be directly implemented.  
 * Use {@link LeafKey} or {@link SubmenuKey} as the direct super-type instead.
 * 
 * @author bnjmnbrmn
 */
public interface ActionKey extends NonHoleKey {
	public Action[] getActions();
}
