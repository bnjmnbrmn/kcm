package edu.uiowa.cs.baberman.kcm.basic;

import edu.uiowa.cs.baberman.kcm.CardKey;
import org.piccolo2d.PNode;

/**
 *
 * @author bnjmnbrmn
 */
public abstract class BasicCardKey implements CardKey {
	//	public static final int[] VK_CODES = {
	//		VK_Q,VK_W,VK_E,VK_R,VK_T,VK_Y,VK_U,VK_I,VK_O,VK_P,
	//		VK_A,VK_S,VK_D,VK_F,VK_G,VK_H,VK_J,VK_K,VK_L,VK_SEMICOLON,
	//		VK_Z,VK_X,VK_C,VK_V,VK_B,VK_N,VK_M,VK_COMMA,VK_PERIOD,VK_SLASH
	//	};
	public static final double DEFAULT_KEY_WIDTH = 100;
	public static final double DEFAULT_KEY_HEIGHT = 100;
	private PNode node;
	private final BasicKC card;

	public BasicCardKey(final BasicKC card) {
		this.card = card;
		node = new PNode();
	}

	PNode getNode() {
		return node;
	}

}
