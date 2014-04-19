/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.piccolo2d.extras.PFrame;
import org.piccolo2d.nodes.PText;

/**
 *
 * @author bnjmnbrmn
 */
public class PiccoloTest {

	public static class HelloWorld extends PFrame {

		public HelloWorld() {
			PText helloWorldText = new PText("Hello world!");

			getCanvas().getLayer().addChild(helloWorldText);
		}
	}

	public PiccoloTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}
	HelloWorld hw;

	@Test
	public void hello() throws InterruptedException, InvocationTargetException, AWTException {


		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {

				hw = new HelloWorld();
				hw.setVisible(true);
			}
		});

		Robot r = new Robot();
		
		Point hwpoint = hw.getLocationOnScreen();
		
		r.mouseMove(hwpoint.x+50, hwpoint.y+50);
		
		r.mousePress(InputEvent.BUTTON1_MASK);
		
		r.delay(2000);
		
		r.mouseMove(hwpoint.x+100, hwpoint.y+100);
		
		r.mousePress(InputEvent.BUTTON1_MASK);
		
		r.delay(2000);

	}
}