package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.figures.v3.Point;
import academy.tochkavhoda.iface.v3.Movable;
import academy.tochkavhoda.iface.v3.Resizable;

import java.util.Objects;

public class LineSegment implements Movable, Resizable {
    private Point initialPoint;
    private Point endPoint;

    public LineSegment(Point initialPoint, Point endPoint) {
        this.initialPoint = initialPoint;
        this.endPoint = endPoint;
    }

    public LineSegment(int xInitial, int yInitial, int xEnd, int yEnd) {
        this.initialPoint = new Point(xInitial, yInitial);
        this.endPoint = new Point(xEnd, yEnd);
    }

    public LineSegment() {
        this.initialPoint = new Point(0, 0);
        this.endPoint = new Point(1, 1);
    }

    public Point getInitialPoint() {
        return initialPoint;
    }

    public void setInitialPoint(Point initialPoint) {
        this.initialPoint = initialPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void moveTo(int x, int y) {
        int xInitial = initialPoint.getX();
        int yInitial = initialPoint.getY();
        int xEnd = endPoint.getX();
        int yEnd = endPoint.getY();

        int newEndX = xEnd + (x - xInitial);
        int newEndY = yEnd + (y - yInitial);

        initialPoint.moveTo(x, y);
        endPoint.moveTo(newEndX, newEndY);
    }

    @Override
    public void moveRel(int dx, int dy) {
        initialPoint.moveRel(dx, dy);
        endPoint.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {

        int dx = endPoint.getX() - initialPoint.getX();
        int dy = endPoint.getY() - initialPoint.getY();

        int newEndX = (int) (initialPoint.getX() + dx * ratio);
        int newEndY = (int) (initialPoint.getY() + dy * ratio);

        endPoint.moveTo(newEndX, newEndY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineSegment that)) return false;
        return Objects.equals(getInitialPoint(), that.getInitialPoint()) && Objects.equals(getEndPoint(), that.getEndPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInitialPoint(), getEndPoint());
    }
}
