package State;

import Rest.Point;
import Rest.Shape;
import Rest.ShapeCont;


public class MoveState implements State {

    @Override
    public void pointerDown(Point point, ShapeCont context) {
        context.select(point);
    }

    @Override
    public void pointerUp(Point point, ShapeCont context) {
        context.setSelected(null);
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