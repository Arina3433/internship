package academy.tochkavhoda.base;

import java.text.DecimalFormat;

public class StringOperations {
    public static int getSummaryLength(String[] strings) {
        int result = 0;

        for (String el : strings) {
            result += el.length();
        }

        return result;
    }

    public static String getFirstAndLastLetterString(String string) {
        if (string == null || string.length() == 0) {
            return "";
        }

        if (string.length() == 1) {
            return string + string;
        }

        StringBuilder result = new StringBuilder();
        result.append(string.charAt(0));
        result.append(string.charAt(string.length() - 1));

        return result.toString();
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1 + string2;
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int maxPrefix = Math.min(string1.length(), string2.length());

        // REVU можно и так, но хватило бы одного вызова substring, если в цикле только считать символы, пока совпадают
        for (int i = 0; i < maxPrefix; i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return string1.substring(0, i);
            }
        }

        return string1.substring(0, maxPrefix);
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        // REVU сделайте без reverse
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        // REVU вызовите предыдущий метод
        return string.equalsIgnoreCase(new StringBuilder(string).reverse().toString());
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String result = "";

        for (String el : strings) {
            if (isPalindromeIgnoreCase(el)) {
                if (el.length() > result.length()) {
                    result = el;
                }
            }
        }

        return result;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (string1.length() < length + index || string2.length() < length + index) {
            return false;
        }

        return string1.substring(index, length + index).equals(string2.substring(index, length + index));
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char
            replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        String string1AfterReplace = string1.replace(replaceInStr1, replaceByInStr1);
        String string2AfterReplace = string2.replace(replaceInStr2, replaceByInStr2);

        return string1AfterReplace.equals(string2AfterReplace);
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String
            replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        String string1AfterReplace = string1.replaceAll(replaceInStr1, replaceByInStr1);
        String string2AfterReplace = string2.replaceAll(replaceInStr2, replaceByInStr2);

        return string1AfterReplace.equals(string2AfterReplace);
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replaceAll("\\s+", ""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        return makeCsvStringBuilderFromInts(array).toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        return makeCsvStringBuilderFromDoubles(array).toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        if (array == null || array.length == 0) {
            return stringBuilder;
        }

        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (i < array.length - 1) {
                stringBuilder.append(",");
            }
        }

        return stringBuilder;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder stringBuilder = new StringBuilder();

        if (array == null || array.length == 0) {
            return stringBuilder;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(decimalFormat.format(array[i]));
            if (i < array.length - 1) {
                stringBuilder.append(",");
            }
        }

        return stringBuilder;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder stringBuilder = new StringBuilder(string);

        for (int i = positions.length - 1; i >= 0; i--) {
            stringBuilder.deleteCharAt(positions[i]);
        }

        return stringBuilder;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder stringBuilder = new StringBuilder(string);

        for (int i = positions.length - 1; i >= 0; i--) {
            stringBuilder.insert(positions[i], characters[i]);
        }

        return stringBuilder;
    }
}
