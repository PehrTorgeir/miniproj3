package Rest;

import java.awt.Graphics;

public class Rectangle implements Shape {
    private Point position;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.position = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point position, double width, double height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        // Draw the rectangle
        g.drawRect((int) position.getX(), (int) position.getY(), (int) width, (int) height);
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean intersects(Point point) {
        // Check if the point is within the rectangle
        return point.getX() >= position.getX() && point.getX() <= position.getX() + width &&
               point.getY() >= position.getY() && point.getY() <= position.getY() + height;
    }

    @Override
    public void moveTo(Point point) {
        // Move the rectangle to the specified point
        position.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        // Move the rectangle by the specified displacement
        position.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        // Resize the rectangle to the specified point
        width = point.getX() - position.getX();
        height = point.getY() - position.getY();
    }

    @Override
    public Shape peel() {
        // The peel operation for a rectangle (returning itself)
        return this;
    }
}
