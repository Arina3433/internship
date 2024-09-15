package academy.tochkavhoda.colors.v3;

public enum Color {
    RED,
    GREEN,
    BLUE;

    public static Color colorFromString(String colorString) throws ColorException {
        if (colorString == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }

        // REVU а если их 1000 будет ?
        // Color.valueOf и ловите IllegalArgumentException
        switch (colorString.toUpperCase()) {
            case "RED":
                return RED;
            case "GREEN":
                return GREEN;
            case "BLUE":
                return BLUE;
            default:
                throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }

    }
}
