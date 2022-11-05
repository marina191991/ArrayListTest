package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class AppTest {
    static ArrayList<Integer> integerList;

    @BeforeEach
    public void init() {
        integerList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
    }

    @Test
    public void sizeArray() {
        assertEquals(10, integerList.size());
        System.out.println();
    }

    @Test
    public void newArrayAfterLimitBaseSize() {
        int hashBefore = integerList.hashCode();
        integerList.add(10);
        int hashAfter = integerList.hashCode();
        Assertions.assertNotEquals(hashBefore, hashAfter);
        System.out.println();
    }

    //Increasing the size of the array by the formula: size*3/2+1
    @Test
    public void newSizeArray() {
        int hashStartSize = integerList.hashCode();
        for (int i = 10; i < 16; i++)
            integerList.add(i);
        int hashSecondSize = integerList.hashCode();
        for (int i = 16; i < 25; i++)
            integerList.add(i);
        int hashThirdSize = integerList.hashCode();
        integerList.add(25);
        int hashEndSize = integerList.hashCode();

        Assertions.assertNotEquals(hashStartSize, hashSecondSize);
        Assertions.assertNotEquals(hashSecondSize, hashThirdSize);
        Assertions.assertNotEquals(hashThirdSize, hashEndSize);
        System.out.println();
    }

    @Test
    public void addElementByIndex() {
        integerList.add(2, 10);
        Assertions.assertEquals(10, integerList.get(2));
        Assertions.assertEquals(1, integerList.get(1));
        Assertions.assertEquals(2, integerList.get(3));
        System.out.println();
    }

    @Test
    public void setElement() {
        integerList.set(2, 12);
        Assertions.assertEquals(12, integerList.get(2));
        Assertions.assertEquals(1, integerList.get(1));
        Assertions.assertEquals(3, integerList.get(3));
        System.out.println();
    }

    @Test
    public void removeElementInEnd() {
        integerList.remove(9);
        for (Integer el : integerList) {
            Assertions.assertNotEquals(9, el);
        }
        Assertions.assertEquals(9, integerList.size());
        System.out.println();
    }

    @Test
    public void removeElementInMiddle() {
        integerList.remove(4);
        Assertions.assertEquals(5, integerList.get(4));
        Assertions.assertEquals(9, integerList.size());
        System.out.println();
    }

    @Test
    public void getElement() {
        Assertions.assertEquals(5, integerList.get(5));
        System.out.println();
    }


}
