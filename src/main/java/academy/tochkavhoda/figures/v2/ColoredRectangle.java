package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {

    private int color;

    public ColoredRectangle(Point leftTop, Point rightBottom, int color) {
        super(leftTop, rightBottom);
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        super(xLeft, yTop, xRight, yBottom);
        this.color = color;
    }

    public ColoredRectangle(int length, int width, int color) {
        super(length, width);
        this.color = color;
    }

    public ColoredRectangle(int color) {
        super();
        this.color = color;
    }

    public ColoredRectangle() {
        super();
        this.color = 1;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
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
