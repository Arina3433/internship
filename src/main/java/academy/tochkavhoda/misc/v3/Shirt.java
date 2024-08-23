package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class Shirt implements Colored {
    private Color color;
    private char size;
    private String material;

    public Shirt(Color color, char size, String material) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }

        this.color = color;
        this.size = size;
        this.material = material;
    }

    public Shirt(String color, char size, String material) throws ColorException {
        this.color = Color.colorFromString(color);
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
    public Color getColor() {
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
