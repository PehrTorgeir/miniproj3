package State;



import Rest.Point;
import Rest.ShapeCont;


public interface State {
    void pointerDown(Point point, ShapeCont shapeCont);
    void pointerUp(Point point, ShapeCont shapeCont);
    void pointerMoved(Point point, boolean pointerDown, ShapeCont shapeCont);
  }
