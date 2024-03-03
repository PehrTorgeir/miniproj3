package Rest;

import java.awt.Color;
import java.awt.Graphics;

public class MoveMarkerDecorator implements Shape {
    private Shape decoratedShape;
    private boolean markerVisible = true;

    public MoveMarkerDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;;
    }

    @Override
    public void draw(Graphics g) {
        decoratedShape.draw(g);
        if (markerVisible) {
            g.setColor(Color.RED);

            Point center = decoratedShape.calculateCenter();
            double x = center.getX();
            double y = center.getY();

            g.drawLine((int) (x - decoratedShape.getWidth() / 2), (int) y, (int) (x + decoratedShape.getWidth() / 2),
                    (int) y);
            g.drawLine((int) x, (int) (y - decoratedShape.getHeight() / 2), (int) x,
                    (int) (y + decoratedShape.getHeight() / 2));

            g.setColor(Color.BLACK);
        }
    }

    public void removeMarker() {
        markerVisible = false;
    }

    public void addMarker() {
        markerVisible = true; //
    }

    public Shape getDecoratedShape() {
        return decoratedShape;
    }

    @Override
    public Point getPosition() {
        return decoratedShape.getPosition();
    }

    @Override
    public double getWidth() {
        return decoratedShape.getWidth();
    }

    @Override
    public double getHeight() {
        return decoratedShape.getHeight();
    }

    @Override
    public boolean intersects(Point point) {
        return decoratedShape.intersects(point);
    }

    @Override
    public void moveTo(Point point) {
        decoratedShape.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        decoratedShape.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        decoratedShape.resizeTo(point);
    }

    @Override
    public Shape peel() {
        return decoratedShape.peel();
    }

    @Override
    public Point calculateCenter() {
        return decoratedShape.calculateCenter();
    }
}
