package edu.uiowa.cs.baberman.kcm;

import javax.swing.KeyStroke;

/**
 *
 * This should not be directly implemented.  Use {@link LeafKey}, {@link SubmenuKey},
 * {@link HoleKey}, or {@link BlankKey} instead.
 * 
 * @author bnjmnbrmn
 */
public interface CardKey {
	
	/**
	 * 
	 * 
	 * @return the virtual key code, as defined in {@link javax.swing.KeyStroke}. 
	 */
	public int getVKCode();
}
