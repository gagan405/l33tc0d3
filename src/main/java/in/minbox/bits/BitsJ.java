package in.minbox.bits;

public class BitsJ {

    // LeetCode 190
    public static int reverseBinary(int x) {
        int y = 0;
        int z = x;

        for (int count = 1; count <=32; count++) {
            y = y | (z & 1);
            z = z >> 1;
            if (count < 32)
                y = y << 1;
        }

        return y;
    }

}
