package academy.tochkavhoda.boxes.v3;

import academy.tochkavhoda.figures.v3.Figure;
import academy.tochkavhoda.iface.v3.HasArea;

public class Box<T extends Figure> implements HasArea {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public double getArea() {
        return content.getArea();
    }

    public boolean isAreaEqual(Box<?> box) {
        return Math.abs(getArea() - box.getArea()) < 1e-10;
    }

    public static boolean isAreaEqual(Box<?> box1, Box<?> box2) {
        return Math.abs(box1.getArea() - box2.getArea()) < 1e-10;
    }

}
