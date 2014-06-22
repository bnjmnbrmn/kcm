package edu.uiowa.cs.baberman.kcm;

import static java.awt.event.KeyEvent.*;
import java.awt.Paint;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bnjmnbrmn
 */
public final class ThirtyKey extends KeyboardCard {
	private static final double DEFAULT_ROW_TWO_OFFSET = 25;
	private static final double DEFAULT_ROW_THREE_OFFSET = 90;
	private static final List<Integer> keyCodes;
	private static final Map<Integer, String> keyLabelsForKeyCodes;
	private static final Map<Integer, Point2D.Double> keyPositionsForKeyCodes;
	
	public static enum KeyPosition {

        Q(VK_Q,"Q"), W(VK_W,"W"), E(VK_E,"E"), R(VK_R,"R"), T(VK_T,"T"),
        Y(VK_Y,"Y"), U(VK_U,"U"), I(VK_I,"I"), O(VK_O,"O"), P(VK_P,"P"),
        A(VK_A,"A"), S(VK_S,"S"), D(VK_D,"D"), F(VK_F,"F"), G(VK_G,"G"),
        H(VK_H,"H"), J(VK_J,"J"), K(VK_K,"K"), L(VK_L,"L"), SEMICOLON(VK_SEMICOLON,";"),
        Z(VK_Z,"Z"), X(VK_X,"X"), C(VK_C,"C"), V(VK_V,"V"), B(VK_B,"B"),
        N(VK_N,"N"), M(VK_M,"M"), COMMA(VK_COMMA,","), PERIOD(VK_PERIOD,"."), SLASH(VK_SLASH,"/");

        private final int VK_CODE;
        private final String KEY_LABEL;

        
        
        private KeyPosition(int VK_CODE, String keyLabel) {
            this.VK_CODE = VK_CODE;
            this.KEY_LABEL = keyLabel;
            
        }

        public int getVK_CODE() {
            return VK_CODE;
        }

        public String getKeyLabel() {
            return KEY_LABEL;
        }
        
        //ideally this would be immutable
        private static final EnumMap<KeyPosition, Point2D.Double> defaultKeyPositionsOffsets
            = new EnumMap<KeyPosition, Point2D.Double>(KeyPosition.class) {
                {
                    double x = 0;
                    double y = 0;
                    put(KeyPosition.Q, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.W, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.E, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.R, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.T, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.Y, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.U, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.I, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.O, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.P, new Point2D.Double(x, y));

                    x = DEFAULT_ROW_TWO_OFFSET;
                    y += CardKey.OUTER_HEIGHT;
                    put(KeyPosition.A, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.S, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.D, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.F, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.G, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.H, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.J, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.K, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.L, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.SEMICOLON, new Point2D.Double(x, y));

                    x = DEFAULT_ROW_THREE_OFFSET;
                    y += CardKey.OUTER_HEIGHT;
                    put(KeyPosition.Z, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.X, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.C, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.V, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.B, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.N, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.M, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.COMMA, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.PERIOD, new Point2D.Double(x, y));
                    x += CardKey.OUTER_WIDTH;
                    put(KeyPosition.SLASH, new Point2D.Double(x, y));

                }
            };
    }
	
	
	static {
		keyLabelsForKeyCodes = new HashMap<Integer, String>() {
			{
				put(VK_Q, "Q");
				put(VK_W, "W");
				put(VK_E, "E");
				put(VK_R, "R");
				put(VK_T, "T");
				put(VK_Y, "Y");
				put(VK_U, "U");
				put(VK_I, "I");
				put(VK_O, "O");
				put(VK_P, "P");
				put(VK_A, "A");
				put(VK_S, "S");
				put(VK_D, "D");
				put(VK_F, "F");
				put(VK_G, "G");
				put(VK_H, "H");
				put(VK_J, "J");
				put(VK_K, "K");
				put(VK_L, "L");
				put(VK_SEMICOLON, ";");
				put(VK_Z, "Z");
				put(VK_X, "X");
				put(VK_C, "C");
				put(VK_V, "V");
				put(VK_B, "B");
				put(VK_N, "N");
				put(VK_M, "M");
				put(VK_COMMA, ",");
				put(VK_PERIOD, ".");
				put(VK_SLASH, "/");
			}
		};
		keyCodes = new ArrayList<Integer>() {
			{
				add(VK_Q);
				add(VK_W);
				add(VK_E);
				add(VK_R);
				add(VK_T);
				add(VK_Y);
				add(VK_U);
				add(VK_I);
				add(VK_O);
				add(VK_P);
				add(VK_A);
				add(VK_S);
				add(VK_D);
				add(VK_F);
				add(VK_G);
				add(VK_H);
				add(VK_J);
				add(VK_K);
				add(VK_L);
				add(VK_SEMICOLON);
				add(VK_Z);
				add(VK_X);
				add(VK_C);
				add(VK_V);
				add(VK_B);
				add(VK_N);
				add(VK_M);
				add(VK_COMMA);
				add(VK_PERIOD);
				add(VK_SLASH);
			}
		};
		keyPositionsForKeyCodes = new HashMap<Integer, Point2D.Double>() {
			{
				double x = 0;
				double y = 0;
				put(VK_Q, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_W, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_E, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_R, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_T, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_Y, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_U, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_I, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_O, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_P, new Point2D.Double(x, y));
				x = DEFAULT_ROW_TWO_OFFSET;
				y += CardKey.OUTER_HEIGHT;
				put(VK_A, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_S, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_D, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_F, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_G, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_H, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_J, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_K, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_L, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_SEMICOLON, new Point2D.Double(x, y));
				x = DEFAULT_ROW_THREE_OFFSET;
				y += CardKey.OUTER_HEIGHT;
				put(VK_Z, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_X, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_C, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_V, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_B, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_N, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_M, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_COMMA, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_PERIOD, new Point2D.Double(x, y));
				x += CardKey.OUTER_WIDTH;
				put(VK_SLASH, new Point2D.Double(x, y));
			}
		};
	}

	private ThirtyKey(Paint innerKeyPaint, Paint outerKeyPaint) {
		super(innerKeyPaint, outerKeyPaint);
	}

	public static ThirtyKey createRootCard() {
		ThirtyKey newRoot = new ThirtyKey(DEFAULT_ROOT_INNER_KEY_PAINT, DEFAULT_ROOT_OUTER_KEY_PAINT);
		for (Integer keyCode : keyCodes) {
			newRoot.putNewBlankKey(keyCode);
		}
		return newRoot;
	}

	@Override
	double getWidth() {
		return 10 * CardKey.OUTER_WIDTH + DEFAULT_ROW_TWO_OFFSET + DEFAULT_ROW_THREE_OFFSET;
	}

	@Override
	double getHeight() {
		return 3 * CardKey.OUTER_HEIGHT;
	}

	@Override
	public List<Integer> getKeyCodes() {
		return keyCodes; //TO DO:  return clone
	}

	@Override
	public String getKeyLabelForKeyCode(Integer keyCode) {
		return keyLabelsForKeyCodes.get(keyCode);
	}

	@Override
	public Point2D.Double getKeyPositionForKeyCode(Integer keyCode) {
		return keyPositionsForKeyCodes.get(keyCode);
	}

	public LeafKey putNewLeaf(KeyPosition keyPosition) {
		return putNewLeaf(keyPosition.getVK_CODE());
	}

	public BlankKey putNewBlankKey(KeyPosition keyPosition) {
		return putNewBlankKey(keyPosition.getVK_CODE());
	}
	
}
