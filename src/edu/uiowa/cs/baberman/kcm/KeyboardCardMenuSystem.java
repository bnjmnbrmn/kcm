package edu.uiowa.cs.baberman.kcm;

/**
 *
 * @author bnjmnbrmn
 */
public interface KeyboardCardMenuSystem {
	public void setCurrentRoot(KeyboardCard root);
	public KeyboardCard getCurrentRoot();
	
	/**
	 * 
	 * @return an array of the root KeyboardCards.  Root cards should be added
	 * and removed using the 
	 * {@link #addRoot(edu.uiowa.cs.baberman.kcm.KeyboardCard) addRoot(KeyboardCard)}
	 * and
	 * {@link #removeRoot(edu.uiowa.cs.baberman.kcm.KeyboardCard) removeRoot(KeyboardCard)}
	 * methods.
	 */
	public KeyboardCard[] getRoots();
	public void addRoot(KeyboardCard root);
	public void removeRoot(KeyboardCard root);
}
