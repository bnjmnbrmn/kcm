package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.KeyboardCard;
import java.util.List;
import org.piccolo2d.PCanvas;
import edu.uiowa.cs.baberman.kcm.KeyboardCardMenuSystem;
import java.awt.BorderLayout;

/**
 *
 * @author bnjmnbrmn
 */
public class BasicKCMS extends KeyboardCardMenuSystem {
	
	private PCanvas canvas;
	
	PCanvas getCanvas() {
		return canvas;
	}
	
	private KeyboardCard currentRoot;
	private List<KeyboardCard> roots;
	
	
	public BasicKCMS(RootBasicKC rootCard) {
		super();
		
		canvas = new PCanvas();
		
		
		canvas.getLayer().addChild(rootCard.getNode());
		
		add(canvas, BorderLayout.CENTER);
		
	}
	

	@Override
	public void setCurrentRoot(KeyboardCard root) {
		if (roots.contains(root))
			this.currentRoot = root;
	}

	@Override
	public KeyboardCard getCurrentRoot() {
		return currentRoot;
	}

	@Override
	public KeyboardCard[] getRoots() {
		KeyboardCard[] toReturn = new KeyboardCard[roots.size()];
		return roots.toArray(toReturn);
	}

	
	@Override
	public void addRoot(KeyboardCard root) {
		roots.add(root);
	}

	@Override
	public void removeRoot(KeyboardCard root) {
		roots.remove(root);
	}

}
