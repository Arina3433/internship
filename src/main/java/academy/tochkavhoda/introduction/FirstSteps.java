package academy.tochkavhoda.introduction;

public class FirstSteps {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int result = 0;

        for (int el : array) {
            result += el;
        }
        return result;
    }

    public int mul(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int result = 1;

        for (int el : array) {
            result *= el;
        }
        return result;
    }

    public int min(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MAX_VALUE;
        }

        int result = array[0];

        for (int el : array) {
            if (el < result) {
                result = el;
            }
        }

        return result;
    }

    public int max(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }

        int result = array[0];

        for (int el : array) {
            if (el > result) {
                result = el;
            }
        }

        return result;
    }

    public double average(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        return (double) sum(array) / array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        if (array == null || array.length == 0) {
            return true;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // REVU *=
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        for (int el : array) {
            if (el == value) {
                return true;
            }
        }

        return false;
    }

    public void reverse(int[] array) {
        int startIndx = 0;
        int endIndx = array.length - 1;

        int tempNumber;

        while (startIndx < endIndx) {
            tempNumber = array[startIndx];
            array[startIndx] = array[endIndx];
            array[endIndx] = tempNumber;

            startIndx++;
            endIndx--;
        }
    }

    public boolean isPalindrome(int[] array) {
        if (array == null || array.length == 0) {
            return true;
        }

        int startIndx = 0;
        int endIndx = array.length - 1;

        while (startIndx < endIndx) {
            if (array[startIndx] != array[endIndx]) {
                return false;
            }

            startIndx++;
            endIndx--;
        }

        return true;
    }

    public int sum(int[][] matrix) {
        int result = 0;

        for (int[] row : matrix) {
            // REVU вызовите sum для линейного массива
            for (int el : row) {
                result += el;
            }
        }

        return result;
    }

    public int max(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        int result = matrix[0][0];

        for (int[] row : matrix) {
            for (int el : row) {
                // REVU аналогично
                if (el > result) {
                    result = el;
                }
            }
        }

        return result;
    }

    public int diagonalMax(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        int result = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] > result) {
                result = matrix[i][i];
            }
        }

        return result;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] row : matrix) {
            if (!isSortedDescendant(row)) {
                return false;
            }
        }

        return true;
    }

    public char getCharByCode(short code) {
        return (char) code;
    }

    public short getCodeByChar(char character) {
        return (short) character;
    }

    public char getCharByCodeAndOffset(char ch, short offset) {
        return (char) (ch + offset);
    }

    public boolean isGreaterOrEqual(char ch1, char ch2) {
        return ch1 >= ch2;
    }

    public char getAverageChar(char ch1, char ch2) {
        return (char) ((ch1 + ch2) / 2);
    }

}
