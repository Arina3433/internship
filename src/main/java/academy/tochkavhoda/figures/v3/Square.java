package academy.tochkavhoda.figures.v3;

import java.util.Objects;

public class Square extends Figure {

    private Point topLeft;
    private int size;

    public Square(Point topLeft, int size) {
        this.topLeft = topLeft;
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.topLeft = new Point(xLeft, yTop);
        this.size = size;
    }

    public Square(int size) {
        this.topLeft = new Point(0, -size);
        this.size = size;
    }

    public Square() {
        this.topLeft = new Point(0, -1);
        this.size = 1;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return new Point(topLeft.getX() + size, topLeft.getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getLength() {
        return size;
    }

    @Override
    public void moveTo(int x, int y) {
        this.topLeft.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.topLeft.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        this.size = (int) (this.size * ratio);
    }

    @Override
    public double getArea() {
        return size * size;
    }

    @Override
    public double getPerimeter() {
        return 4 * size;
    }

    @Override
    public boolean isInside(int x, int y) {
        int xLeft = this.topLeft.getX();
        int yTop = this.topLeft.getY();
        int xRight = xLeft + this.size;
        int yBottom = yTop + this.size;

        return (x >= xLeft && x <= xRight) && (y >= yTop && y <= yBottom);
    }

    public boolean isIntersects(Square square) {
        int xLeft1 = this.topLeft.getX();
        int yTop1 = this.topLeft.getY();
        int xRight1 = xLeft1 + this.size;
        int yBottom1 = yTop1 + this.size;

        int xLeft2 = square.topLeft.getX();
        int yTop2 = square.topLeft.getY();
        int xRight2 = xLeft2 + square.size;
        int yBottom2 = yTop2 + square.size;

        return !(xLeft1 > xRight2 || xLeft2 > xRight1 || yTop1 > yBottom2 || yTop2 > yBottom1);
    }

    public boolean isInside(Square square) {
        return this.isInside(square.getTopLeft()) && this.isInside(square.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square square)) return false;
        return size == square.size && Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, size);
    }
}
