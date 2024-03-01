package State;

import Rest.Point;
import Rest.Shape;
import Rest.ShapeCont;

public class UnmarkState implements State {

    @Override
    public void pointerDown(Point point, ShapeCont context) {

        context.select(point);
        Shape selected = context.getSelected();

        if (selected != null) {
            Shape undecoratedShape = selected.peel();
            context.removeShape(selected);
            context.addShape(undecoratedShape);
            context.repaint();
        }

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
