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
import edu.uiowa.cs.baberman.kcm.NonHoleKey;
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

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getKeyColor() {
        return keyColor;
    }
    
    public Map<KeyPosition, BasicCardKey> getKeyPositionsToCardKeys() {
        return keyPositionsToCardKeys;
    }

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
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.W, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.E, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.R, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.T, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.Y, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.U, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.I, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.O, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.P, new Point2D.Double(x, y));

                    x = DEFAULT_ROW_TWO_OFFSET;
                    y += BasicCardKey.OUTER_HEIGHT;
                    put(KeyPosition.A, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.S, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.D, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.F, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.G, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.H, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.J, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.K, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.L, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.SEMICOLON, new Point2D.Double(x, y));

                    x = DEFAULT_ROW_THREE_OFFSET;
                    y += BasicCardKey.OUTER_HEIGHT;
                    put(KeyPosition.Z, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.X, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.C, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.V, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.B, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.N, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.M, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.COMMA, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.PERIOD, new Point2D.Double(x, y));
                    x += BasicCardKey.OUTER_WIDTH;
                    put(KeyPosition.SLASH, new Point2D.Double(x, y));

                }
            };
    }

    public static final double DEFAULT_ROW_TWO_OFFSET = 25;
    public static final double DEFAULT_ROW_THREE_OFFSET = 90;
    
    public static final Color DEFAULT_LEVEL_0_BACKGROUND_COLOR = new Color(68,41,242);
    public static final Color DEFAULT_LEVEL_0_KEY_COLOR = new Color(155,142,237);

    private final PNode node;

    PNode getNode() {
        return node;
    }

    BasicKC() {
        node = new PNode();
        backgroundColor = DEFAULT_LEVEL_0_BACKGROUND_COLOR;
        keyColor = DEFAULT_LEVEL_0_KEY_COLOR;
    }

    private Color backgroundColor;
    private Color keyColor;

    private Map<KeyPosition, BasicCardKey> keyPositionsToCardKeys
            = new EnumMap<KeyPosition, BasicCardKey>(KeyPosition.class);

    @Override
    public CardKey[] getKeys() {
        Collection<BasicCardKey> cardKeysCollection = keyPositionsToCardKeys.values();
        int numberOfCardKeys = cardKeysCollection.size();
        return cardKeysCollection.toArray(new CardKey[numberOfCardKeys]);
    }

    public void setKey(KeyPosition keyPosition, BasicCardKey cardKey) {
        if (keyPositionsToCardKeys.get(keyPosition) != null) {
            node.removeChild(keyPositionsToCardKeys.get(keyPosition).getNode());
        }
        keyPositionsToCardKeys.put(keyPosition, cardKey);
        node.addChild(cardKey.getNode());
        Point2D.Double point = KeyPosition.defaultKeyPositionsOffsets.get(keyPosition);
        cardKey.getNode().translate(point.x, point.y);
        cardKey.setOuterPaint(getBackgroundColor());
        if (cardKey instanceof BasicNonHoleKey) {
            ((BasicNonHoleKey) cardKey).setInnerPaint(keyColor);
        }
    }
    
    public BasicLeafKey putNewLeaf(KeyPosition keyPosition) {
        BasicLeafKey lk = new BasicLeafKey(backgroundColor, keyColor, keyPosition.getKeyLabel(), "");
        if (keyPositionsToCardKeys.get(keyPosition) != null) {
            node.removeChild(keyPositionsToCardKeys.get(keyPosition).getNode());
        }
        keyPositionsToCardKeys.put(keyPosition, lk);
        node.addChild(lk.getNode());
        Point2D.Double point = KeyPosition.defaultKeyPositionsOffsets.get(keyPosition);
        lk.getNode().translate(point.x, point.y);
        return lk;
    }

    double getWidth() {
        return 10 * BasicCardKey.OUTER_WIDTH + DEFAULT_ROW_TWO_OFFSET + DEFAULT_ROW_THREE_OFFSET;
    }

    double getHeight() {
        return 3 * BasicCardKey.OUTER_HEIGHT;
    }
}
