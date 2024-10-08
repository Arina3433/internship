package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.iface.v3.Stretchable;

import java.util.Objects;

public class Rectangle extends Figure implements Stretchable {

    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    public Rectangle(int length, int width) {
        this(0, -width, length, 0);
    }

    public Rectangle() {
        this(0, -1, 1, 0);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getLength() {
        return (bottomRight.getX() - topLeft.getX());
    }

    public int getWidth() {
        return (bottomRight.getY() - topLeft.getY());
    }

    @Override
    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();

        topLeft.moveTo(x, y);
        bottomRight.moveTo(x + length, y + width);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        int length = getLength();
        int width = getWidth();

        int newLength = (int) Math.floor(length * ratio);
        int newWidth = (int) Math.floor(width * ratio);

        this.bottomRight.moveTo(topLeft.getX() + newLength, topLeft.getY() + newWidth);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        int length = getLength();
        int width = getWidth();

        int newLength = (int) Math.floor(length * xRatio);
        int newWidth = (int) Math.floor(width * yRatio);

        this.bottomRight.moveTo(topLeft.getX() + newLength, topLeft.getY() + newWidth);
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    @Override
    public boolean isInside(int x, int y) {
        int xLeft = topLeft.getX();
        int xRight = bottomRight.getX();
        int yTop = topLeft.getY();
        int yBottom = bottomRight.getY();

        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public boolean isIntersects(Rectangle rectangle) {
        int xLeft1 = this.topLeft.getX();
        int yTop1 = this.topLeft.getY();
        int xRight1 = this.bottomRight.getX();
        int yBottom1 = this.bottomRight.getY();

        int xLeft2 = rectangle.topLeft.getX();
        int yTop2 = rectangle.topLeft.getY();
        int xRight2 = rectangle.bottomRight.getX();
        int yBottom2 = rectangle.bottomRight.getY();

        return !(xLeft1 > xRight2 || xLeft2 > xRight1 || yTop1 > yBottom2 || yTop2 > yBottom1);
    }

    public boolean isInside(Rectangle rectangle) {
        int xLeft1 = this.topLeft.getX();
        int yTop1 = this.topLeft.getY();
        int xRight1 = this.bottomRight.getX();
        int yBottom1 = this.bottomRight.getY();

        int xLeft2 = rectangle.topLeft.getX();
        int yTop2 = rectangle.topLeft.getY();
        int xRight2 = rectangle.bottomRight.getX();
        int yBottom2 = rectangle.bottomRight.getY();

        return xLeft2 >= xLeft1 && xRight2 <= xRight1 && yTop2 >= yTop1 && yBottom2 <= yBottom1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle rectangle)) return false;
        return Objects.equals(topLeft, rectangle.topLeft) && Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
