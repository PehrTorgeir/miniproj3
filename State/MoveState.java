package State;

import Rest.MoveMarkerDecorator;
import Rest.Point;
import Rest.Shape;
import Rest.ShapeCont;

public class MoveState implements State {
    private MoveMarkerDecorator currentDecorator;

    @Override
    public void pointerDown(Point point, ShapeCont context) {
        context.select(point);

        Shape selected = context.getSelected();
        if (selected != null) {
            currentDecorator = new MoveMarkerDecorator(selected);
            context.replaceShape(selected, currentDecorator);
            context.setSelected(currentDecorator);
            currentDecorator.moveTo(point);
            context.repaint();
        }
    }

    @Override
    public void pointerUp(Point point, ShapeCont context) {
        if (currentDecorator != null) {
            context.replaceShape(currentDecorator, currentDecorator.getDecoratedShape());
            context.setSelected(null);
            currentDecorator.removeMarker();
            currentDecorator = null;
            context.repaint();
        }
    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown, ShapeCont context) {
        if (pointerDown) {
            Shape selected = context.getSelected();
            if (selected != null) {
                selected.moveTo(point);
                context.repaint();
            }
        }
    }
}