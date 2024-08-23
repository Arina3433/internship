package academy.tochkavhoda.boxes.v3;

import academy.tochkavhoda.figures.v3.Figure;

public class ArrayBox<T extends Figure> {
    private T[] content;

    public ArrayBox(T[] content) {
        this.content = content;
    }

    public T[] getContent() {
        return content;
    }

    public void setContent(T[] content) {
        this.content = content;
    }

    public T getElement(int i) {
        return content[i];
    }

    public void setElement(int i, T element) {
        content[i] = element;
    }

    public boolean isSameSize(ArrayBox<?> box) {
        return this.content.length == box.getContent().length;
    }
}
