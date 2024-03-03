package Rest;

import java.awt.Graphics;

public class Rectangle implements Shape {
    private Point position;
    private double width;
    private double height;

    public Rectangle() {

    }

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
        return point.getX() >= position.getX() && point.getX() <= position.getX() + width &&
                point.getY() >= position.getY() && point.getY() <= position.getY() + height;
    }

    @Override
    public void moveTo(Point point) {
        point.setX(point.getX()-(width/2));
        point.setY(point.getY()-(height/2));
        position.moveTo(point);
    }

    @Override
    public void move(double dx, double dy) {
        position.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        double newWidth = Math.abs(position.getX() - point.getX());
        double newHeight = Math.abs(position.getY() - point.getY());

        if (newWidth > 0 && newHeight > 0) {
            width = newWidth;
            height = newHeight; 
        }
    }

    @Override
    public Shape peel() {
        return this;
    }

    @Override
    public Point calculateCenter() {
        double centerX = position.getX() + width / 2;
        double centerY = position.getY() + height / 2;
        return new Point(centerX, centerY);
    }
}
