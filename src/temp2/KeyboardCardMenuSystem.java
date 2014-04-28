package temp2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.piccolo2d.PCanvas;

/**
 *
 * @author bnjmnbrmn
 */
public class KeyboardCardMenuSystem extends JPanel {

	PCanvas canvas;
	List<RootKeyboardCard> rootKeyboardCards;
	RootKeyboardCard currentRoot;

	public KeyboardCardMenuSystem(RootKeyboardCard defaultRoot) {
		super(new BorderLayout());
		
		setBackground(Color.yellow);

		canvas = new PCanvas();

		rootKeyboardCards = new ArrayList<RootKeyboardCard>();
		rootKeyboardCards.add(defaultRoot);
		currentRoot = defaultRoot;
		
//		canvas.getLayer().addChild(currentRoot.getView());
		
		setSize(new Dimension(1100, 500));
	}
	
//	public void addRootCard(RootKeyboardCard rootCard) {
//		rootKeyboardCards.add(rootCard);
//	}
//	
//	public List<RootKeyboardCard> getRootCards() {
//		return rootKeyboardCards;
//	}
//	
//	public void setCurrentRootCard() {
//		
//	}
}
