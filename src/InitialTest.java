
import org.piccolo2d.PNode;
import org.piccolo2d.extras.PFrame;
import org.piccolo2d.nodes.PText;


/**
 *
 * @author Benjamin Berman
 */
public class InitialTest extends PFrame {
    public void initialize() {
                PNode aNode = new PText("Hello World!");                

                // Add the node to the canvas layer so that it
                // will be displayed on the screen.
                getCanvas().getLayer().addChild(aNode);
        }

        public static void main(String[] args) {
                new InitialTest();
        }

}
