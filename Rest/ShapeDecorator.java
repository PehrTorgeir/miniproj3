package Rest;

import java.awt.Graphics;

public class ShapeDecorator implements Shape {
  private Shape decoratee;

  public ShapeDecorator(Shape decoratee) {
    this.decoratee = decoratee;
  }

  @Override
    public void draw(Graphics g) {
        decoratee.draw(g);

        Point position = decoratee.getPosition();
        double x = position.getX();
        double y = position.getY();

        double width = decoratee.getWidth();
        double height = decoratee.getHeight();

        int drawX = (int) (x - width / 2.0 + 0.5);
        int drawY = (int) (y - height / 2.0 + 0.5);

        if (decoratee instanceof Circle) {
            g.fillOval(drawX, drawY, (int) (width + 0.5), (int) (height + 0.5));
        } else if (decoratee instanceof Rectangle) {
            g.fillRect((int) (drawX + decoratee.getWidth()/2), (int) (drawY + decoratee.getHeight()/2), (int) (width + 0.5), (int) (height + 0.5));
        }
    }

  @Override
  public Point getPosition() {
    return decoratee.getPosition();
  }

  @Override
  public double getWidth() {
    return decoratee.getWidth();
  }

  @Override
  public double getHeight() {
    return decoratee.getHeight();
  }

  @Override
  public boolean intersects(Point point) {
    return decoratee.intersects(point);
  }

  @Override
  public void moveTo(Point point) {
    decoratee.moveTo(point);
  }

  @Override
  public void move(double dx, double dy) {
    decoratee.move(dx, dy);
  }

  @Override
  public void resizeTo(Point point) {
    decoratee.resizeTo(point);
  }

  @Override
  public Shape peel() {
    return decoratee;
  }

  @Override
  public Point calculateCenter() {
    return decoratee.calculateCenter();
  }


}
