
package tugasjayjay;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class HitungTest {
    static int tambah(int angka1, int angka2) {
        return angka1 + angka2;
    }
    @Test
    void testTambah() {
        
        assertEquals(5, tambah(2, 3));
        assertEquals(-1, tambah(-3, 2));
        assertEquals(0, tambah(0, 0));
        assertEquals(100, tambah(50, 50));
        assertEquals(-5, tambah(-10, 5));

        
    }
}
