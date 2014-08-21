package edu.uiowa.cs.baberman.kcm;

import java.awt.Color;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.piccolo2d.PNode;
import static java.awt.event.KeyEvent.*;

/**
 *
 * @author bnjmnbrmn
 */
public abstract class KeyboardCard<C extends KeyboardCard<C>> {

    static List<Color> defaultOuterKeyColors = new ArrayList<Color>() {
        {
            add(new Color(68, 41, 242));
            add(new Color(232, 123, 123));
            add(new Color(0, 166, 22));
        }
    };
    static List<Color> defaultInnerKeyColors = new ArrayList<Color>() {
        {
            add(new Color(155, 142, 237));
            add(new Color(232, 123, 123));
            add(new Color(72, 240, 94));
        }
    };

//    static final Color DEFAULT_ROOT_OUTER_KEY_PAINT = new Color(68, 41, 242);
//    static final Color DEFAULT_ROOT_INNER_KEY_PAINT = new Color(155, 142, 237);
//	
//	static final Color DEFAULT_LEVEL_ONE_OUTER_KEY_PAINT = new Color(242, 56,56);
//	static final Color DEFAULT_LEVEL_ONE_INNER_KEY_PAINT = new Color(232, 123,123);
    abstract double getWidth();

    abstract double getHeight();

    public abstract List<Integer> getKeyCodes();

    public abstract String getKeyLabelForKeyCode(Integer keyCode);

    public abstract Point2D.Double getKeyPositionForKeyCode(Integer keyCode);

    private final PNode node = new PNode();

    final PNode getNode() {
        return node;
    }

    private final Map<Integer, CardKey> cardKeysForKeyCodes
            = new HashMap<Integer, CardKey>();

    private final Map<CardKey, Integer> keyCodesForCardKeys
            = new HashMap<CardKey, Integer>();

    CardKey getCardKeyForKeyCode(Integer keyCode) {
        return cardKeysForKeyCodes.get(keyCode);
    }

    Integer getKeyCodeForCardKey(CardKey cardKey) {
        return keyCodesForCardKeys.get(cardKey);
    }

    private final Paint innerKeyPaint;

    public Paint getInnerKeyPaint() {
        return innerKeyPaint;
    }

    private final Paint outerKeyPaint;

    public Paint getOuterKeyPaint() {
        return outerKeyPaint;
    }

    KeyboardCard(Paint innerKeyPaint, Paint outerKeyPaint) {
        this.innerKeyPaint = innerKeyPaint;
        this.outerKeyPaint = outerKeyPaint;
    }

    private void putKey(Integer keyCode, CardKey key) {
        if (!getKeyCodes().contains(keyCode)) {
            throw new RuntimeException("Bad key code argument");
        }

        if (cardKeysForKeyCodes.get(keyCode) != null) {
            node.removeChild(cardKeysForKeyCodes.get(keyCode).getNode());
        }
        cardKeysForKeyCodes.put(keyCode, key);
        keyCodesForCardKeys.put(key, keyCode);
        node.addChild(key.getNode());
        Point2D.Double point = getKeyPositionForKeyCode(keyCode);
        key.getNode().translate(point.x, point.y);
    }

    public LeafKey putNewLeaf(Integer keyCode) {
        if (!getKeyCodes().contains(keyCode)) {
            throw new RuntimeException("Bad key code argument");
        }

        LeafKey lk = new LeafKey(getOuterKeyPaint(), getInnerKeyPaint(),
                getKeyLabelForKeyCode(keyCode), "");

        putKey(keyCode, lk);

        return lk;
    }

    BlankKey putNewBlankKey(Integer keyCode) {
        if (!getKeyCodes().contains(keyCode)) {
            throw new RuntimeException("Bad key code argument");
        }

        BlankKey bk = new BlankKey(getOuterKeyPaint(), getInnerKeyPaint());

        putKey(keyCode, bk);

        return bk;
    }

    public SubmenuKey<C> putNewSubmenu(Integer keyCode) {
        if (!getKeyCodes().contains(keyCode)) {
            throw new RuntimeException("Bad key code argument");
        }

        SubmenuKey<C> sk = new SubmenuKey<C>(getOuterKeyPaint(),
                getInnerKeyPaint(), getKeyLabelForKeyCode(keyCode),
                "", this, keyCode);

        putKey(keyCode, sk);

        return sk;
    }

    private final List<Integer> holeKeyCodes = new ArrayList<Integer>();

    public final List<Integer> getHoleKeyCodes() {
        return holeKeyCodes;
    }

    C createSubmenu(Integer newCardInvokingKeyCode) {
        int newSubmenuLevel = this.getHoleKeyCodes().size() + 1;
        C newSubmenu = this.getNewRootCard(
                defaultInnerKeyColors
                .get(newSubmenuLevel % defaultInnerKeyColors.size()),
                defaultOuterKeyColors
                .get(newSubmenuLevel % defaultOuterKeyColors.size()));

        for (Integer kc : holeKeyCodes) {
            newSubmenu.getHoleKeyCodes().add(kc);
        }
        newSubmenu.getHoleKeyCodes().add(newCardInvokingKeyCode);

        for (Integer kc : getKeyCodes()) {
            if (newSubmenu.getHoleKeyCodes().contains(kc)) {
                newSubmenu.putNewHoleKey(kc);
            } else {
                newSubmenu.putNewBlankKey(kc);
            }
        }

        return newSubmenu;

    }

    abstract C getNewRootCard();

    abstract C getNewRootCard(Paint innerKeyPaint, Paint outerKeyPaint);

    HoleKey putNewHoleKey(Integer keyCode) {
        if (!getKeyCodes().contains(keyCode)) {
            throw new RuntimeException("Bad key code argument");
        }

        HoleKey hk = new HoleKey(getOuterKeyPaint());

        putKey(keyCode, hk);

        return hk;
    }

    void setAllInactiveExcept(ActionKey ak) {
        for (CardKey ck : cardKeysForKeyCodes.values()) {
            if (ck instanceof ActionKey) {
                ((ActionKey) ck).setInactive();
            }
        }
        ak.setActive();
    }

    void setAllActive() {
        for (CardKey ck : cardKeysForKeyCodes.values()) {
            if (ck instanceof ActionKey) {
                ((ActionKey) ck).setActive();
            }
        }
    }

    boolean allActive() {
        for (CardKey ck : cardKeysForKeyCodes.values()) {
            if (ck instanceof ActionKey) {
                if (!((ActionKey) ck).isActive()) {
                    return false;
                }
            }
        }
        return true;
    }

    SubmenuKey<C> getPressedSubmenuKey() {
        for (Integer keyCode : getKeyCodes()) {
            CardKey potentialSubmenuKey = getCardKeyForKeyCode(keyCode);
            if (potentialSubmenuKey instanceof SubmenuKey) {
                SubmenuKey<C> potentiallyPressedSK = (SubmenuKey<C>) potentialSubmenuKey;

                if (potentiallyPressedSK.isPressed()) {
                    return potentiallyPressedSK;
                }
            }
        }

        return null;
    }
    
    public void setAllKeysReleased() {
        List<ActionKey> pressedActionKeys = new ArrayList<ActionKey>();
        for (Integer keyCode : getKeyCodes()) {
            CardKey potentialActionKey = getCardKeyForKeyCode(keyCode);
            if (potentialActionKey instanceof ActionKey) {
                ((ActionKey) potentialActionKey).setReleased();
            }
        }
    }

}
