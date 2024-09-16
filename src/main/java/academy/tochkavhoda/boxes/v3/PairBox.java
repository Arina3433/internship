package academy.tochkavhoda.boxes.v3;

import academy.tochkavhoda.figures.v3.Figure;
import academy.tochkavhoda.iface.v3.HasArea;

public class PairBox<T extends Figure, C extends Figure> implements HasArea {
    private T contentFirst;
    private C contentSecond;

    public PairBox(T contentFirst, C contentSecond) {
        this.contentFirst = contentFirst;
        this.contentSecond = contentSecond;
    }

    public T getContentFirst() {
        return contentFirst;
    }

    public void setContentFirst(T contentFirst) {
        this.contentFirst = contentFirst;
    }

    public C getContentSecond() {
        return contentSecond;
    }

    public void setContentSecond(C contentSecond) {
        this.contentSecond = contentSecond;
    }

    @Override
    public double getArea() {
        return contentFirst.getArea() + contentSecond.getArea();
    }

    public boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> pairBox) {
        return isAreaEqual(this, pairBox);
    }

    public static boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> pairBox1,
                                      PairBox<? extends Figure, ? extends Figure> pairBox2) {
        return Math.abs(pairBox1.getArea() - pairBox2.getArea()) < 1e-10;
    }
}
