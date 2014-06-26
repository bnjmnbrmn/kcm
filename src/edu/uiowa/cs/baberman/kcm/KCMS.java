package edu.uiowa.cs.baberman.kcm;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import org.piccolo2d.PCanvas;
import org.piccolo2d.nodes.PText;

/**
 *
 * @author bnjmnbrmn
 */
public class KCMS<C extends KeyboardCard<C>> extends JPanel {

	public static final double CARD_STACK_X_OFFSET = 5;
	public static final double CARD_STACK_Y_OFFSET = 5;
	public static final double BORDER_WIDTH = 10;
	private final PCanvas canvas = new PCanvas();
	private final List<C> roots = new ArrayList<C>();
	private C currentRoot;

	PCanvas getCanvas() {
		return canvas;
	}

	public KCMS(C rootCard) {
		super();

		addRoot(rootCard);
		setCurrentRoot(rootCard);

		//canvas.getLayer().addChild(rootCard.getNode());

		add(canvas, BorderLayout.CENTER);

		canvas.setPreferredSize(
				new Dimension((int) (rootCard.getWidth() + 2 * CARD_STACK_X_OFFSET + BORDER_WIDTH),
				(int) (rootCard.getHeight() + 2 * CARD_STACK_Y_OFFSET + BORDER_WIDTH)));

		canvas.setZoomEventHandler(null);
		canvas.setPanEventHandler(null);

		setInputAndActionMaps();

		if (System.getProperty("os.name").equals("Linux")) {
			new LinuxKeyRepeatAdjuster().addAutomaticKeyRepeatOnOff();
		}

	}

	private class LinuxKeyRepeatAdjuster {

		private Container topLevelAncestor = null;
		private WindowAdapter windowFocusAndClosingListener = new WindowAdapter() {
			@Override
			public void windowGainedFocus(WindowEvent e) {
				turnOffKeyRepeat();
			}

			@Override
			public void windowLostFocus(WindowEvent e) {
				turnOnKeyRepeat();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				turnOnKeyRepeat();
			}
		};

		public void addAutomaticKeyRepeatOnOff() {
			KCMS.this.addHierarchyListener(new HierarchyListener() {
				@Override
				public void hierarchyChanged(HierarchyEvent e) {

					if (topLevelAncestor != null && topLevelAncestor instanceof Window) {
						System.out.println("old topLevelAncestor instanceof Window");
						((Window) topLevelAncestor).removeWindowFocusListener(windowFocusAndClosingListener);
						((Window) topLevelAncestor).removeWindowListener(windowFocusAndClosingListener);
					}
					//TO DO:  take care of case where topLevelAncestor is an Applet

					topLevelAncestor = KCMS.this.getTopLevelAncestor();

					if (topLevelAncestor != null && topLevelAncestor instanceof Window) {
						System.out.println("new topLevelAncestor instanceof Window");
						((Window) topLevelAncestor).addWindowFocusListener(windowFocusAndClosingListener);
						((Window) topLevelAncestor).addWindowListener(windowFocusAndClosingListener);
					}
					//TO DO:  take care of case where topLevelAncestor is an Applet
				}
			});
		}

		private void turnOffKeyRepeat() {
			try {
				System.out.println("Turning off KeyRepeat");
				Runtime.getRuntime().exec("xset -r");
			} catch (IOException ex) {
				Logger.getLogger(KCMS.class.getName()).log(Level.SEVERE, null, ex);
			}

		}

		private void turnOnKeyRepeat() {

			try {
				System.out.println("Turning on KeyRepeat");
				Runtime.getRuntime().exec("xset r");
			} catch (IOException ex) {
				Logger.getLogger(KCMS.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}

	private void setInputAndActionMaps() {
		InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = getActionMap();

		final KeyboardCard<C> root = getCurrentRoot();

		for (final Integer keyCode : root.getKeyCodes()) {
			im.put(KeyStroke.getKeyStroke(keyCode, 0, false),
					root.getKeyLabelForKeyCode(keyCode) + "Pressed");
			am.put(root.getKeyLabelForKeyCode(keyCode) + "Pressed", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					codesForHeldDownKeys.add(keyCode);

					C top = cardStack.get(cardStack.size() - 1);
					CardKey cardKey = top.getCardKeyForKeyCode(keyCode);

					if (cardKey instanceof LeafKey) {
						LeafKey lk = (LeafKey) cardKey;

						if (lk.isActive()) {
							lk.performPreDisplayPressActions(e);
							top.setAllInactiveExcept(lk);
							lk.setPressed();
							lk.performPressActions(e);
						}
					} else if (cardKey instanceof SubmenuKey) {
						SubmenuKey<C> sk = (SubmenuKey<C>) cardKey;

						if (sk.isActive()) {
							sk.performPreDisplayPressActions(e);
							top.setAllInactiveExcept(sk); //unnecessary
							sk.setPressed();
							pushCard(sk.getSubmenu());
							sk.performPressActions(e);
						}
					}



//					if (heldDownLeaf == null) {
//						if (cardKey instanceof SubmenuKey) {
//							SubmenuKey<C> sk = (SubmenuKey<C>) cardKey;
//							for (Action action : sk.getPreDisplayPressActions()) {
//								action.actionPerformed(e);
//							}
//							push(sk.getSubmenu(), keyCode);
//							for (Action action : sk.getPressActions()) {
//								action.actionPerformed(e);
//							}
//						} else if (cardKey instanceof LeafKey) {
//							heldDownLeaf = keyCode;
//							LeafKey lk = (LeafKey) cardKey;
//							for (Action action : lk.getPreDisplayPressActions()) {
//								action.actionPerformed(e);
//							}
//							lk.getInnerSquare().setStroke(new BasicStroke(3.0f));
//							for (Action action : lk.getPressActions()) {
//								action.actionPerformed(e);
//							}
//						}
//					}
				}
			});

			im.put(KeyStroke.getKeyStroke(keyCode, 0, true),
					root.getKeyLabelForKeyCode(keyCode) + "Released");
			am.put(root.getKeyLabelForKeyCode(keyCode) + "Released", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					codesForHeldDownKeys.remove(keyCode);

					C top = cardStack.get(cardStack.size() - 1);
					CardKey cardKey = top.getCardKeyForKeyCode(keyCode);

					if (cardKey instanceof LeafKey) {
						LeafKey lk = (LeafKey) cardKey;

						lk.performPreDisplayReleaseActions(e);
						top.setAllActive();
						lk.setReleased();
						lk.performReleaseActions(e);

						popCards(e);

					} else if (cardKey instanceof HoleKey) {
						if (top.allActive())
							popCards(e);
					}
//
//					if (cardKey instanceof HoleKey) {
//
//						int i = cardStack.size() - 1;
//						while (cardStack.get(i).getCardKeyForKeyCode(keyCode) instanceof HoleKey) {
//							i--;
//						}
//
//						SubmenuKey<C> sk = (SubmenuKey<C>) cardStack
//								.get(i).getCardKeyForKeyCode(keyCode);
//
//						for (Action action : sk.getPreDisplayReleaseActions()) {
//							action.actionPerformed(e);
//						}
//
////						while (!keyCodeStack.isSubsetOf(keysHeldDown))
//						
//						if (i == cardStack.size() - 2) {
//							pop();
//						}
//
//					} else if (keyCode == heldDownLeaf) {
//						heldDownLeaf = null;
//						LeafKey lk = (LeafKey) cardKey;
//						for (Action action : lk.getPreDisplayReleaseActions()) {
//							action.actionPerformed(e);
//						}
//						lk.getInnerSquare().setStroke(new BasicStroke(1.0f));
//						for (Action action : lk.getReleaseActions()) {
//							action.actionPerformed(e);
//						}
//					}
				}
			});
		}
	}

	private void pushCard(C card) {
		canvas.getLayer().addChild(card.getNode());

		card.getNode().setOffset(cardStack.size() * CARD_STACK_X_OFFSET, 
				cardStack.size() * CARD_STACK_Y_OFFSET);
		
		cardStack.add(card);
	}

	private C popCard() {
		if (cardStack.isEmpty()) {
			throw new RuntimeException("Tried to pop card from empty stack");
		}

		C card = cardStack.remove(cardStack.size() - 1);

		canvas.getLayer().removeChild(card.getNode());

		return card;
	}

	private void popCards(ActionEvent e) {
		int i = cardStack.size() - 1;

		while (i > 0) {
			C cardOneDown = cardStack.get(i - 1);

			SubmenuKey<C> invokingCardKey = cardOneDown.getPressedSubmenuKey();
			if (invokingCardKey == null) {
				throw new RuntimeException("Failed to get "
						+ "pressed submenu key in parent card");
			}
			Integer invokingKeyCode = cardOneDown.getKeyCodeForCardKey(invokingCardKey);
			if (invokingKeyCode == null) {
				throw new RuntimeException("Got pressed submenu"
						+ " key in parent card, but could not get "
						+ "its key code");
			}

			if (codesForHeldDownKeys.contains(invokingKeyCode)) {
				break;
			} else {
				invokingCardKey.performPreDisplayPressActions(e);
				popCard();
				invokingCardKey.setReleased();
				cardOneDown.setAllActive();
			}

			i--;
		}
	}
	private Integer heldDownLeaf = null;
	//the last item in the list (with the highest index) is the top of the stack
	private final List<C> cardStack = new ArrayList<C>();
	//the last item in the list (with the highest index) is the top of the stack
	private final List<Integer> keyCodeStack = new ArrayList<Integer>();
	//keys held down does not necessarily contain the same set of keys as in
	//the keyCodeStack, e.g. when F then J are held down but then F is released
	private final Set<Integer> codesForHeldDownKeys = new HashSet<Integer>();

	//returns popped C and keyCode Integer and Objects 0 and 1 respectively
	private Object[] pop() {
		if (cardStack.isEmpty()) {
			throw new RuntimeException("Tried to pop card from empty stack");
		}

		C card = cardStack.remove(cardStack.size() - 1);

		canvas.getLayer().removeChild(card.getNode());

		Integer keyCode = null;

		if (!keyCodeStack.isEmpty()) {
			keyCode = keyCodeStack.remove(keyCodeStack.size() - 1);
		}

		return new Object[]{card, keyCode};
	}

	//use null for the keyCode of a root
	private void push(C card, Integer keyCode) {
		canvas.getLayer().addChild(card.getNode());

		card.getNode().translate(cardStack.size() * CARD_STACK_X_OFFSET,
				cardStack.size() * CARD_STACK_Y_OFFSET);

		cardStack.add(card);
		if (keyCode != null) {
			keyCodeStack.add(keyCode);
			codesForHeldDownKeys.add(keyCode);
		}
	}

	public void setCurrentRoot(C root) {
		if (roots.contains(root)) {
			this.currentRoot = root;
			push(this.currentRoot, null);
		} else {
			throw new RuntimeException("Tried to set the current root to one that had not been added");
		}
	}

	public KeyboardCard<C> getCurrentRoot() {
		return currentRoot;
	}

	public List<C> getRoots() {
		return roots;
	}

	public void addRoot(C root) {
		roots.add(root);
	}

	public void removeRoot(C root) {
		roots.remove(root);
	}
}
