package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinimarketTest {

    private Minimarket mm;

    private void setupScenary1() {
        mm = new Minimarket();
    }

    @Test
    public void test1() {
        setupScenary1();
        assertTrue(mm.registerClient("CC", 123, 3));
    }
    
    @Test
    public void test2() {
        setupScenary1();
        assertFalse(mm.registerClient("CC", 123, 2));
    }
    
    @Test
    public void test3() {
        setupScenary1();
        assertTrue(mm.registerClient("CC", 133, 2));
    }
    
    @Test
    public void test4() {
        setupScenary1();
        assertFalse(mm.registerClient("CC", 133, 3));
    }
    
    @Test
    public void test5() {
        setupScenary1();
        assertFalse(mm.registerClient("TI", 133, 3));
    }
    
    @Test
    public void test6() {
        setupScenary1();
        mm.registerClient("CC", 123, 3);
        mm.registerClient("CC", 123, 2);
        mm.registerClient("CC", 133, 2);
        mm.registerClient("CC", 133, 3);
        mm.registerClient("TI", 133, 3);
        assertEquals(5, mm.getTryIn());
    }
    
    @Test
    public void test7() {
        setupScenary1();
        mm.registerClient("CC", 123, 3);
        mm.registerClient("CC", 123, 2);
        mm.registerClient("CC", 133, 2);
        mm.registerClient("CC", 133, 3);
        mm.registerClient("TI", 133, 3);
        assertEquals(2, mm.getClientsSize());
    }
}
