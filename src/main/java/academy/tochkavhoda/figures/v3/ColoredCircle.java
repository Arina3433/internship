package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class ColoredCircle extends Circle implements Colored {
    private Color color;

    public ColoredCircle(Point center, int radius, Color color) throws ColorException {
        super(center, radius);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredCircle(Point center, int radius, String color) throws ColorException {
        super(center, radius);
        this.color = Color.colorFromString(color);
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        super(xCenter, yCenter, radius);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, String color) throws ColorException {
        super(xCenter, yCenter, radius);
        this.color = Color.colorFromString(color);
    }

    public ColoredCircle(int radius, Color color) throws ColorException {
        super(radius);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredCircle(int radius, String color) throws ColorException {
        super(radius);
        this.color = Color.colorFromString(color);
    }

    public ColoredCircle(Color color) throws ColorException {
        super();
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredCircle(String color) throws ColorException {
        super();
        this.color = Color.colorFromString(color);
    }

    public ColoredCircle() throws ColorException {
        super();
        this.color = Color.RED;
    }

    @Override
    public Point getCenter() {
        return super.getCenter();
    }

    @Override
    public int getRadius() {
        return super.getRadius();
    }

    @Override
    public void setCenter(Point center) {
        super.setCenter(center);
    }

    @Override
    public void setRadius(int radius) {
        super.setRadius(radius);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }

    @Override
    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        super.resize(ratio);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public boolean isInside(int x, int y) {
        return super.isInside(x, y);
    }

    @Override
    public boolean isInside(Point point) {
        return super.isInside(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredCircle that)) return false;
        if (!super.equals(o)) return false;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
