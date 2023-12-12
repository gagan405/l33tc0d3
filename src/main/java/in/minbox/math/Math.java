package in.minbox.math;

public class Math {
    public void rotate(int[][] matrix) {
        int start = 0;

        for (int i = start; i < matrix.length/2; i++) {
            for (int j = i; j < getRightBoundary(i, matrix.length); j++) {
                swap(matrix, j, matrix.length - i - 1, matrix[i][j], 0);
            }
        }
    }

    private void swap(int[][] matrix, int toi, int toj, int what, int count) {
        if (count == 4) return;
        int tmp = matrix[toi][toj];
        matrix[toi][toj] = what;
        swap(matrix, toj, matrix.length - toi - 1, tmp, ++count);
    }

    private int getRightBoundary(int layer, int size) {
        return size - 1 - layer;
    }

}
