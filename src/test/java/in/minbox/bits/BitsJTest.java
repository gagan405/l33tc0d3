package in.minbox.bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitsJTest {

    @Test
    void reverseBinary() {
        int x = BitsJ.reverseBinary(-1);
        assertEquals(-1, x);
    }
}
