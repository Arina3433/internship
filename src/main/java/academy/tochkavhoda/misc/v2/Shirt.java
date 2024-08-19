package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.Colored;

import java.util.Objects;

public class Shirt implements Colored {
    private int color;
    private char size;
    private String material;

    public Shirt(int color, char size, String material) {
        this.color = color;
        this.size = size;
        this.material = material;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shirt shirt)) return false;
        return getColor() == shirt.getColor() && getSize() == shirt.getSize() && Objects.equals(getMaterial(), shirt.getMaterial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getSize(), getMaterial());
    }
}
