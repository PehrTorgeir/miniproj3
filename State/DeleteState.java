package State;

import Rest.Point;
import Rest.ShapeCont;

public class DeleteState implements State {

    @Override
    public void pointerDown(Point point, ShapeCont context) {
        context.select(point);
        if (context.getSelected() != null) {
            context.removeShape(context.getSelected());
            context.setSelected(null);
            context.repaint();
        }
    }

    @Override
    public void pointerUp(Point point, ShapeCont context) {
        // Nothing to do on pointer up in delete mode
    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown, ShapeCont context) {
        // Nothing to do on pointer move in delete mode
    }
}
