package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.iface.v3.HasArea;
import academy.tochkavhoda.iface.v3.Movable;
import academy.tochkavhoda.iface.v3.Resizable;

public abstract class Figure implements Movable, Resizable, HasArea {

    @Override
    public abstract void moveTo(int x, int y);

    @Override
    public abstract void moveRel(int dx, int dy);

    @Override
    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract boolean isInside(int x, int y);

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

}
