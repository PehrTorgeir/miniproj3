package State;

import Rest.Circle;
import Rest.Point;
import Rest.ShapeCont;


public class InsertState implements State {

    @Override
    public void pointerDown(Point point, ShapeCont context) {
        context.addShape(new Circle(point, Math.random() * 50.0));
        context.repaint();
    }

    @Override
    public void pointerUp(Point point, ShapeCont context) {
       // Nothing to do on pointer move in unmark mode
      
    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown, ShapeCont context) {
        // Nothing to do on pointer move in unmark mode
        
    }

}
