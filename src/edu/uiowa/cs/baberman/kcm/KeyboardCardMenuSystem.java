package edu.uiowa.cs.baberman.kcm;

import edu.uiowa.cs.baberman.kcm.KeyboardCard;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author bnjmnbrmn
 */
public abstract class KeyboardCardMenuSystem extends JPanel {
	
	protected KeyboardCardMenuSystem() {
		super(new BorderLayout());
	}
	
	/**
	 * Changes the card hierarchy to that of the given root.
	 * 
	 * @param newRootCard -- the root card of the new hierarchy to be used.  
	 * This must have been added already to the menu system using 
	 * {@link #addRoot(edu.uiowa.cs.baberman.kcm.KeyboardCard) addRoot(KeyboardCard)}.
	 * To check if it has been added, use {@link #getRoots() getRoots()}.
	 */
	public abstract void setCurrentRoot(KeyboardCard newRootCard);
	
	public abstract KeyboardCard getCurrentRoot();
	
	/**
	 * 
	 * @return an array of the root KeyboardCards.  Root cards should be added
	 * and removed using the 
	 * {@link #addRoot(edu.uiowa.cs.baberman.kcm.KeyboardCard) addRoot(KeyboardCard)}
	 * and
	 * {@link #removeRoot(edu.uiowa.cs.baberman.kcm.KeyboardCard) removeRoot(KeyboardCard)}
	 * methods.
	 */
	public abstract KeyboardCard[] getRoots();
	public abstract void addRoot(KeyboardCard root);
	public abstract void removeRoot(KeyboardCard root);
}
