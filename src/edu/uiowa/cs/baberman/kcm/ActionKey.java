package edu.uiowa.cs.baberman.kcm;

import edu.uiowa.cs.baberman.kcm.basic.BasicActionKey;
import java.util.List;
import javax.swing.Action;

/**
 *
 * This should not be directly implemented. Use {@link LeafKey} or
 * {@link SubmenuKey} as the direct super-type instead.
 *
 * @author bnjmnbrmn
 */
public interface ActionKey extends NonHoleKey {

    public List<Action> getPreDisplayActions();

    public List<Action> getActions();

    ActionKey setMenuItemText(String testLabel);

    ActionKey addAction(Action action);
    
    ActionKey addPreDisplayAction(Action action);
}
