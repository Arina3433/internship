package academy.tochkavhoda.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private final int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        Map<Set<Integer>, Integer> uniqueRows = new LinkedHashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowSet = new HashSet<>();

            for (int el : matrix[i]) {
                rowSet.add(el);
            }

            uniqueRows.putIfAbsent(rowSet, i);
        }

        Set<int[]> result = new LinkedHashSet<>();
        for (Integer el : uniqueRows.values()) {
            result.add(matrix[el]);
        }

        return result;
    }
}
