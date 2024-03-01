package Rest;

import java.awt.Color;
import java.awt.Graphics;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import State.InsertState;
import State.State;

public class ShapeCont extends JPanel implements Pointable {
    private static final long serialVersionUID = 1L;
    private List<Shape> shapes = new LinkedList<>();
    private State currentState;
    private Shape selected;

    public ShapeCont() {
        super();
        currentState = new InsertState(); 
        MouseHandler mouseHandler = new MouseHandler(this);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setBackground(Color.white);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public void select(Point point) {
   
        for (Shape shape : shapes) {
            if (shape.intersects(point)) {
                selected = shape;
                return;
            }
        }
        selected = null;
    }

    public void pointerDown(Point point) {
        currentState.pointerDown(point, this);
    }

    public void pointerUp(Point point) {
        currentState.pointerUp(point, this);
    }

    public void pointerMoved(Point point, boolean pointerDown) {
        currentState.pointerMoved(point, pointerDown, this);
    }

    public void setState(State state) {
        this.currentState = state;
    }

 
    public Shape getSelected() {
        return selected;
    }

    public void setSelected(Shape selected) {
        this.selected = selected;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
        repaint();
    }
}
