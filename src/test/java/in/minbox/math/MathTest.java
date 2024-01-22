package in.minbox.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathTest {

    @Test
    void rotate() {
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7}, {15,14,12,16}};
        //int[][] matrix = new int[][]{{4,8},{3,6}};
        //int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new Math().rotate(matrix);
        for (int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    @Test
    void testTargetSum() {
        assertEquals(5, new Math().findTargetSumWays(new int[]{1,2,3}, 6));
    }
}