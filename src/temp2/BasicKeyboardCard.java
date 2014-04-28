package temp2;

import java.awt.Color;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;

/**
 *
 * @author bnjmnbrmn
 */
class BasicKeyboardCard implements KeyboardCard {

	static final Color DEFAULT_COLOR = Color.pink;
	
	static double WIDTH = 1000;
	
	PNode view;
	
	BasicKeyboardCard() {
		this.view = new PLayer();
		
		PPath topBar = PPath.createRectangle(0.0, 0.0, WIDTH, 10);
		
		view.addChild(topBar);
		
	}
	
	
//	
//	@Override
//	public PNode getView() {
//		return view;
//	}

	

}
