import org.junit.jupiter.api.Test;
import otus.HomeWork.DIYarrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        for (int i = 0; i < 15; i++) {
            list.add("str" + i);
        }
        assertEquals(15, list.size());
        assertEquals("str0", list.get(0));
        assertEquals("str14", list.get(14));
    }

    @Test
    void addNullElements() {
        DIYarrayList<Object> list = new DIYarrayList<>();
        assertTrue(list.add(null));
        assertNull(list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void addAllNull() {
        var list = new DIYarrayList<Integer> ();
        for (int i=0; i<5; i++) {
            list.add(i);
        }
        assertFalse(list.addAll(null));
    }

    @Test
    void addAllEmpty() {
        var list1 = new DIYarrayList<Integer>();
        for (int i=0; i<5; i++) {
            list1.add(i);
        }
        assertFalse(list1.addAll(new DIYarrayList<Integer>()));
    }

    @Test
    void EmptyAddAllList() {
        List list1 = new DIYarrayList<Integer>();
        List list2 = new DIYarrayList<Integer>();
        for (int i=0; i<5; i++) {
            list2.add(i);
        }
        assertTrue(list1.addAll(list2));
        assertEquals(5, list1.size());
        assertEquals(0,list1.get(0));
        assertEquals(4,list1.get(4));
    }
}
