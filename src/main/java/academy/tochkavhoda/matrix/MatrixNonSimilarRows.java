package academy.tochkavhoda.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private final int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> uniqueRows = new HashMap<>();

        for (int[] row : matrix) {
            Set<Integer> rowSet = new HashSet<>();
            for (int el : row) {
                rowSet.add(el);
            }
            uniqueRows.putIfAbsent(rowSet, row);
        }

        return new HashSet<>(uniqueRows.values());
    }
}
