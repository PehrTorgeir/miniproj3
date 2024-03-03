package State;

import Rest.Point;
import Rest.Shape;
import Rest.ShapeCont;

import Rest.ShapeDecorator;

public class MarkState implements State {

    @Override
    public void pointerDown(Point point, ShapeCont context) {
        context.select(point);
        Shape selected = context.getSelected();
        if (selected != null && !(selected instanceof ShapeDecorator)) {
            Shape decoratedShape = new ShapeDecorator(selected);
            context.removeShape(selected);
            context.addShape(decoratedShape);
            context.repaint();
        }
    }

    @Override
    public void pointerUp(Point point, ShapeCont context) {

    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown, ShapeCont context) {
    }

}
