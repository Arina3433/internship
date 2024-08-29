package academy.tochkavhoda.figures.v3;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

public class FigureBag {
    private final Bag<Figure> figures;

    public FigureBag() {
        this.figures = new HashBag<>();
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public void addFigure(Figure figure, int copies) {
        figures.add(figure, copies);
    }

    public boolean removeFigure(Figure figure) {
        return figures.remove(figure);
    }

    public boolean removeFigure(Figure figure, int copies) {
        return figures.remove(figure, copies);
    }

    public int getFigureCopies(Figure figure) {
        return figures.getCount(figure);
    }
}
