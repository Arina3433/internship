package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {

    private Color color;

    public ColoredRectangle(Point leftTop, Point rightBottom, Color color) throws ColorException {
        super(leftTop, rightBottom);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle(Point leftTop, Point rightBottom, String color) throws ColorException {
        super(leftTop, rightBottom);
        this.color = Color.colorFromString(color);
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        super(xLeft, yTop, xRight, yBottom);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, String color) throws ColorException {
        super(xLeft, yTop, xRight, yBottom);
        this.color = Color.colorFromString(color);
    }

    public ColoredRectangle(int length, int width, Color color) throws ColorException {
        super(length, width);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle(int length, int width, String color) throws ColorException {
        super(length, width);
        this.color = Color.colorFromString(color);
    }

    public ColoredRectangle(Color color) throws ColorException {
        super();
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle(String color) throws ColorException {
        super();
        this.color = Color.colorFromString(color);
    }

    public ColoredRectangle() {
        super();
        this.color = Color.RED;
    }

    @Override
    public Point getTopLeft() {
        return super.getTopLeft();
    }

    @Override
    public Point getBottomRight() {
        return super.getBottomRight();
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setTopLeft(Point topLeft) {
        super.setTopLeft(topLeft);
    }

    @Override
    public void setBottomRight(Point bottomRight) {
        super.setBottomRight(bottomRight);
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
    public int getLength() {
        return super.getLength();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
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
    public void stretch(double xRatio, double yRatio) {
        super.stretch(xRatio, yRatio);
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
    public boolean isInside(Point point) {
        return super.isInside(point);
    }

    public boolean isIntersects(ColoredRectangle rectangle) {
        return super.isIntersects(rectangle);
    }

    public boolean isInside(ColoredRectangle rectangle) {
        return super.isInside(rectangle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredRectangle that)) return false;
        if (!super.equals(o)) return false;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
