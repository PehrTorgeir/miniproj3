package State;

import Rest.MoveMarkerDecorator;
import Rest.Point;
import Rest.Shape;
import Rest.ShapeCont;


public class ResizeState implements State {
    private MoveMarkerDecorator currentDecorator;

    @Override
    public void pointerDown(Point point, ShapeCont context) {
        context.select(point);

        Shape selected = context.getSelected();
        if (selected != null) {
            currentDecorator = new MoveMarkerDecorator(selected);
            context.replaceShape(selected, currentDecorator);
            context.setSelected(currentDecorator);
            context.repaint();
        }
    }

    @Override
    public void pointerUp(Point point, ShapeCont context) {
        context.setSelected(null);
        if (currentDecorator != null) {
            context.replaceShape(currentDecorator, currentDecorator.getDecoratedShape());
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
                selected.resizeTo(point);
                context.repaint();
            }
        }
    }
}
