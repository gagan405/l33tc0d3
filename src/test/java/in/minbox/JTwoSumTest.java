package in.minbox;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JTwoSumTest {

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{0, 1}, JTwoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}