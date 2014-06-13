package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.KeyboardCard;
import java.util.List;
import org.piccolo2d.PCanvas;
import edu.uiowa.cs.baberman.kcm.KeyboardCardMenuSystem;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author bnjmnbrmn
 */
public class BasicKCMS extends KeyboardCardMenuSystem {
	
	public static final double CARD_STACK_X_OFFSET = 10;
	public static final double CARD_STACK_Y_OFFSET = 10;
	
	public static final double BORDER_WIDTH = 10;
	
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
		
		//TO DO:  SET SIZE/PREFERED SIZE OF CANVAS
		
		add(canvas, BorderLayout.CENTER);
		
		setPreferredSize(
				new Dimension( (int)(rootCard.getWidth() + 2*CARD_STACK_X_OFFSET + BORDER_WIDTH), 
				(int) (rootCard.getHeight() + 2*CARD_STACK_Y_OFFSET + BORDER_WIDTH) )
				);
		
		
		
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
