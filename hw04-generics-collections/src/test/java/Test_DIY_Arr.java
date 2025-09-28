import org.junit.jupiter.api.Test;
import otus.HomeWork.DIYarrayList;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Test_DIY_Arr {
    @Test
    void test_Constructor() {
        var arr = new DIYarrayList<String>();
        System.out.println("Construction work = " + arr);
    }

    @Test
    void test_Size_Empty() {
        var arr = new DIYarrayList<String>();
        System.out.println("Size empty = " + arr.size());
    }

    @Test
    void addToEmptyList() {
        DIYarrayList<Integer> list = new DIYarrayList<>();
        assertTrue(list.add(1));
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    void addMultipleElements() {
        DIYarrayList<String> list = new DIYarrayList<>();
        for(int i=0; i<15; i++) {
            list.add("str" + i);
        }
        assertEquals(15, list.size());
        assertEquals("str0", list.get(0));
        assertEquals("str14", list.get(14));
    }

    @Test
    void addNullElements() {
        DIYarrayList<Object> list = new DIYarrayList<> ();
        assertTrue(list.add(null));
        assertNull(list.get(0));
        assertEquals(1, list.size());
    }
}
