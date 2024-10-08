package academy.tochkavhoda.colors.v3;

public class ColorException extends Exception{
    private final ColorErrorCode colorErrorCode;

    public ColorException(ColorErrorCode colorErrorCode) {
        this.colorErrorCode = colorErrorCode;
    }

    public ColorErrorCode getErrorCode() {
        return colorErrorCode;
    }

}
