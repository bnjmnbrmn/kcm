package edu.uiowa.cs.baberman.kcm;

import java.awt.Paint;
import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;

/**
 *
 * @author bnjmnbrmn
 */
public class BasicKC extends PNode implements KeyboardCard {

	public static final int KEY_WIDTH = 100;
	public static final int KEY_HEIGHT = 100;
	public static final int WITHIN_ROW_SPACE = 10;
	public static final int BETWEEN_ROW_SPACE = 10;
	public static final int CARD_WIDTH = 
		11*WITHIN_ROW_SPACE + 10*KEY_WIDTH + 2*KEY_WIDTH/3;
	public static final int CARD_HEIGHT = 4*BETWEEN_ROW_SPACE
	+ 3*KEY_HEIGHT;
	public static final int ROW2_NUDGE = 18;
	
	
	private Paint backPaint;
	
	public Paint getBackPaint() {
		return backPaint;
	}
	
	public void setBackPaint(Paint backPaint) {
		this.backPaint = backPaint;
	}
	
	private BasicKC() {
		
	}
	
	private void createCardBack() {
			PPath section;  //non-key section of the back
			
			//top bar
			section = PPath.createRectangle(x, y, 
					CARD_WIDTH, BETWEEN_ROW_SPACE);
			section.setPaint(backPaint);	
			section.setStrokePaint(backPaint);
			addChild(section);
			nonKeysList.add(section);
			//first row vertical bars
			for (int i = 0; i < 10; i++) {
				section = PPath.createRectangle(
						x+i*(KEY_WIDTH+WITHIN_ROW_SPACE),
						y+BETWEEN_ROW_SPACE, WITHIN_ROW_SPACE, KEY_HEIGHT);
				section.setPaint(backPaint);
				section.setStrokePaint(backPaint);
				addChild(section);
				nonKeysList.add(section);
			}
			//end of row
			section= PPath.createRectangle(
					x+10*(KEY_WIDTH+WITHIN_ROW_SPACE),
					y+BETWEEN_ROW_SPACE, WITHIN_ROW_SPACE+(2*KEY_WIDTH)/3,
					KEY_HEIGHT);
			section.setPaint(backPaint);
			section.setStrokePaint(backPaint);
			addChild(section);
			nonKeysList.add(section);
			//second horizontal bar
			section = PPath.createRectangle(x, y+BETWEEN_ROW_SPACE+KEY_HEIGHT,
					CARD_WIDTH, BETWEEN_ROW_SPACE);
			section.setPaint(backPaint);
			section.setStrokePaint(backPaint);
			addChild(section);
			nonKeysList.add(section);
			//start of second row
			section = PPath.createRectangle(
					x,y+2*BETWEEN_ROW_SPACE+KEY_HEIGHT,
					WITHIN_ROW_SPACE+KEY_WIDTH/3 - ROW2_NUDGE,
					KEY_HEIGHT);
			section.setPaint(backPaint);
			section.setStrokePaint(backPaint);
			addChild(section);
			nonKeysList.add(section);
			//second row inner bars
			for (int i = 0; i < 9; i++) {
				section = PPath.createRectangle(
						x + i*(KEY_WIDTH+WITHIN_ROW_SPACE)
						+ (WITHIN_ROW_SPACE+KEY_WIDTH/3 + 
								KEY_WIDTH - ROW2_NUDGE),
						y+2*BETWEEN_ROW_SPACE+KEY_HEIGHT,
						WITHIN_ROW_SPACE, KEY_HEIGHT);
				section.setPaint(backPaint);
				section.setStrokePaint(backPaint);
				addChild(section);
				nonKeysList.add(section);
			}
			//end of second row
			section = PPath.createRectangle(
					x + 9*(KEY_WIDTH+WITHIN_ROW_SPACE)
					+ (WITHIN_ROW_SPACE+KEY_WIDTH/3 + KEY_WIDTH - ROW2_NUDGE),
					y+2*BETWEEN_ROW_SPACE+KEY_HEIGHT,
					WITHIN_ROW_SPACE + KEY_WIDTH/3 + ROW2_NUDGE, KEY_HEIGHT);
			section.setPaint(backPaint);
			section.setStrokePaint(backPaint);
			addChild(section);
			nonKeysList.add(section);
			//third horizontal bar
			section = PPath.createRectangle(x, y+2*BETWEEN_ROW_SPACE+2*KEY_HEIGHT,
					CARD_WIDTH, BETWEEN_ROW_SPACE);
			section.setPaint(backPaint);
			section.setStrokePaint(backPaint);
			addChild(section);
			nonKeysList.add(section);
			//start of third row
			section = PPath.createRectangle(
					x, y+3*BETWEEN_ROW_SPACE+2*KEY_HEIGHT,
					(2*KEY_WIDTH)/3 + WITHIN_ROW_SPACE, KEY_HEIGHT);
			section.setPaint(backPaint);
			section.setStrokePaint(backPaint);
			addChild(section);
			nonKeysList.add(section);
			//third row vertical bars
			for (int i = 0; i < 10; i++) {
				section = PPath.createRectangle(
						x + (2*KEY_WIDTH)/3  + WITHIN_ROW_SPACE
						+ KEY_WIDTH + i*(KEY_WIDTH+WITHIN_ROW_SPACE),
						y+3*BETWEEN_ROW_SPACE+2*KEY_HEIGHT,
						WITHIN_ROW_SPACE, KEY_HEIGHT);
				section.setPaint(backPaint);
				section.setStrokePaint(backPaint);
				addChild(section);
				nonKeysList.add(section);
			}
			//fourth horizontal bar
			section = PPath.createRectangle(x, y+3*BETWEEN_ROW_SPACE+3*KEY_HEIGHT,
					CARD_WIDTH, BETWEEN_ROW_SPACE);
			section.setPaint(backPaint);
			section.setStrokePaint(backPaint);
			addChild(section);
			nonKeysList.add(section);
		}
	
	
	enum BasicKey {
		Q('Q'),W('W'),E('E'),R('R'),T('T'),
		Y('Y'),U('U'),I('I'),O('O'),P('P'),
		A('A'),S('S'),D('D'),F('F'),G('G'),
		H('H'),J('J'),K('K'),L('L'),SEMICOLON(';'),
		Z('Z'),X('X'),C('C'),V('V'),B('B'),
		N('N'),M('M'),COMMA(','),PERIOD('.'),SLASH('/');
		
		private final char keyChar;

		private BasicKey(char str) {
			this.keyChar = str;
		}

		public char getKeyChar() {
			return keyChar;
		}
	}
}
