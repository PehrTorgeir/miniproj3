package Rest;

import java.awt.Color;
import java.awt.Graphics;

public class MoveMarkerDecorator implements Shape {
    private Shape decoratedShape;
    private boolean markerVisible = true; // New field to control marker visibility

    public MoveMarkerDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw(Graphics g) {
        decoratedShape.draw(g);
        if (markerVisible) {
            g.setColor(Color.RED);

            double x = decoratedShape.getPosition().getX();
            double y = decoratedShape.getPosition().getY();
            double width = decoratedShape.getWidth();
            double height = decoratedShape.getHeight();

            g.drawLine((int) (x - width / 2), (int) y, (int) (x + width / 2), (int) y);
            g.drawLine((int) x, (int) (y - height / 2), (int) x, (int) (y + height / 2));

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
}
