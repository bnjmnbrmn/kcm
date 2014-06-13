package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.KeyboardCard;
import static java.awt.event.KeyEvent.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Action;
import org.piccolo2d.PNode;
import edu.uiowa.cs.baberman.kcm.BlankKey;
import edu.uiowa.cs.baberman.kcm.CardKey;
import edu.uiowa.cs.baberman.kcm.HoleKey;
import edu.uiowa.cs.baberman.kcm.LeafKey;
import edu.uiowa.cs.baberman.kcm.SubmenuKey;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.EnumMap;
import org.piccolo2d.nodes.PPath;


/**
 *
 * @author bnjmnbrmn
 */
public class BasicKC implements KeyboardCard {
	
	
	public static enum KeyCode {
		Q(VK_Q),W(VK_W),E(VK_E),R(VK_R),T(VK_T),
		Y(VK_Y),U(VK_U),I(VK_I),O(VK_O),P(VK_P),
		A(VK_A),S(VK_S),D(VK_D),F(VK_F),G(VK_G),
		H(VK_H),J(VK_J),K(VK_K),L(VK_L),SEMICOLON(VK_SEMICOLON),
		Z(VK_Z),X(VK_X),C(VK_C),V(VK_V),B(VK_B),
		N(VK_N),M(VK_M),COMMA(VK_COMMA),PERIOD(VK_PERIOD),SLASH(VK_SLASH);
		
		private final int VK_CODE;
		
		private KeyCode(int VK_CODE) {
			this.VK_CODE = VK_CODE;
		}
		
		public int getVK_CODE() {
			return VK_CODE;
		}	
	}
	
	//ideally this would be immutable
	private static final EnumMap<KeyCode,Point2D.Double> defaultKeyCodePositions 
			= new EnumMap<KeyCode,Point2D.Double>(KeyCode.class) {
				{
					double x = 0;
					double y = 0;
					put(KeyCode.Q, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.W, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.E, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.R, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.T, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.Y, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.U, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.I, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.O, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.P, new Point2D.Double(x, y));
					
					x = DEFAULT_ROW_TWO_OFFSET;
					y += BasicCardKey.DEFAULT_KEY_HEIGHT;
					put(KeyCode.A, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.S, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.D, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.F, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.G, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.H, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.J, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.K, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.L, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.SEMICOLON, new Point2D.Double(x, y));
					
					x = DEFAULT_ROW_THREE_OFFSET;
					y += BasicCardKey.DEFAULT_KEY_HEIGHT;
					put(KeyCode.Z, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.X, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.C, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.V, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.B, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.N, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.M, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.COMMA, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.PERIOD, new Point2D.Double(x, y));
					x += BasicCardKey.DEFAULT_KEY_WIDTH;
					put(KeyCode.SLASH, new Point2D.Double(x, y));
					
				}
			};

	public static final double DEFAULT_ROW_TWO_OFFSET = 25;
	public static final double DEFAULT_ROW_THREE_OFFSET = 90;
	public static final Color DEFAULT_BACKGROUND_COLOR = Color.cyan;
	
	
	private final PNode node;
	
	PNode getNode() {
		return node;
	}
	
	BasicKC() {
		node = new PNode();
		backgroundColor = DEFAULT_BACKGROUND_COLOR;
	}
	

	Color backgroundColor;
	
//	private Map<Integer,CardKey> vkCodeToCardKey = 
//			new HashMap<Integer,CardKey>();
//	

	private Map<KeyCode,BasicCardKey> keyCodesToCardKeys =
			new EnumMap<KeyCode, BasicCardKey>(KeyCode.class);
	
	
	@Override
	public CardKey[] getKeys() {
		Collection<BasicCardKey> cardKeysCollection = keyCodesToCardKeys.values();
		int numberOfCardKeys = cardKeysCollection.size();
		return cardKeysCollection.toArray(new CardKey[numberOfCardKeys]);
	}
	
//	public void setKeyInDefaultPosition(int vkCode, BasicCardKey cardKey) {
////		vkCodeToCardKey.put(vkCode, cardKey);
//	}
	
	public void setKeyInDefaultPosition(KeyCode keyCode, BasicCardKey cardKey) {
		if (keyCodesToCardKeys.get(keyCode) != null)
			node.removeChild(keyCodesToCardKeys.get(keyCode).getNode());
		keyCodesToCardKeys.put(keyCode, cardKey);
		PNode cardKeyNode = cardKey.getNode();
		node.addChild(cardKeyNode);
		Point2D.Double point = defaultKeyCodePositions.get(keyCode);
		cardKeyNode.translate(point.x,point.y);
	}
	
	double getWidth() {
		return 10*BasicCardKey.DEFAULT_KEY_WIDTH + DEFAULT_ROW_TWO_OFFSET + DEFAULT_ROW_THREE_OFFSET;
	}
	
	double getHeight() {
		return 3*BasicCardKey.DEFAULT_KEY_HEIGHT;
	}
}
