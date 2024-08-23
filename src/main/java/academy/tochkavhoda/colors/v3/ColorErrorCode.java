package academy.tochkavhoda.colors.v3;

public enum ColorErrorCode {
    WRONG_COLOR_STRING ("Цвет задан неверно"),
    NULL_COLOR ("Цвет не задан");

    private final String errorString;

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
