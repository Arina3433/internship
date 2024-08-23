package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.iface.v3.Stretchable;

import java.util.Objects;

public class Ellipse extends Figure implements Stretchable {
    private Point center;
    private int xAxis;
    private int yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this(new Point(xCenter, yCenter), xAxis, yAxis);
    }

    public Ellipse(int xAxis, int yAxis) {
        this(new Point(0, 0), xAxis, yAxis);
    }

    public Ellipse() {
        this(new Point(0, 0), 1, 1);
    }

    public Point getCenter() {
        return center;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void moveTo(int x, int y) {
        this.center.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.center.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        this.xAxis = (int) (this.xAxis * ratio);
        this.yAxis = (int) (this.yAxis * ratio);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        this.xAxis = (int) (this.xAxis * xRatio);
        this.yAxis = (int) (this.yAxis * yRatio);
    }

    @Override
    public double getArea() {
        return Math.PI * (xAxis / 2.0) * (yAxis / 2.0);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((xAxis * xAxis + yAxis * yAxis) / 8.0);
    }

    @Override
    public boolean isInside(int x, int y) {
        double dx = x - center.getX();
        double dy = y - center.getY();
        return (dx * dx) / ((xAxis / 2.0) * (xAxis / 2.0)) + (dy * dy) / ((yAxis / 2.0) * (yAxis / 2.0)) <= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse ellipse)) return false;
        return xAxis == ellipse.xAxis && yAxis == ellipse.yAxis && Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}
