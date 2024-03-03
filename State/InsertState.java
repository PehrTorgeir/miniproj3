package State;

import Rest.Circle;
import Rest.Point;
import Rest.Rectangle;
import Rest.Shape;
import Rest.ShapeCont;


public class InsertState implements State {
    private Shape currentShape;

    @Override
    public void pointerDown(Point point, ShapeCont context) {

        currentShape = context.getShape();

        if (currentShape instanceof Circle) {
            context.addShape(new Circle(point, Math.random() * 50.0));
        } else {
            context.addShape(new Rectangle(point, Math.random() * 50.0, Math.random() * 50.0));
        }
        context.repaint();
    }

    @Override
    public void pointerUp(Point point, ShapeCont context) {
      
    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown, ShapeCont context) {
    }

}
