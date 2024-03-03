package Rest;

import java.awt.Graphics;

public class Circle implements Shape {
    private Point center;
    private double r;

    public Circle() {

    }

    public Circle(double x, double y, double r) {
        center = new Point(x, y);
        this.r = r;
    }

    public Circle(Point point, double r) {
        this(point.getX(), point.getY(), r);
    }

    @Override
    public void draw(Graphics g) {
        int x = (int) (center.getX() - r);
        int y = (int) (center.getY() - r);
        int diameter = (int) (2 * r);
        g.drawOval(x, y, diameter, diameter);
    }

    @Override
    public Point getPosition() {
        return center;
    }

    @Override
    public double getWidth() {
        return 2 * r;
    }

    @Override
    public double getHeight() {
        return 2 * r;
    }

    @Override
    public boolean intersects(Point point) {
        return center.distanceTo(point) < r;
    }

    @Override
    public void moveTo(Point point) {
        center.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        r = center.distanceTo(point);
    }

    @Override
    public Shape peel() {
        return this;
    }

    @Override
    public Point calculateCenter() {
        return center;
    }
}
