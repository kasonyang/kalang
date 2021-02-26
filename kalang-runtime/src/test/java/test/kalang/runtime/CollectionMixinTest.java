package test.kalang.runtime;

import kalang.mixin.CollectionMixin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author KasonYang
 */
public class CollectionMixinTest {

    static class MyString {
        private String str;
        public MyString(String str) {
            this.str = str;
        }
        public Integer getLength() {
            return str.length();
        }

        @Override
        public String toString() {
            return str;
        }
    }

    @Test
    public void testAt() {
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(Integer.valueOf(5), CollectionMixin.at(list, 0, 0));
        assertEquals(Integer.valueOf(1), CollectionMixin.at(list, -1, 0));
        assertEquals(Integer.valueOf(0), CollectionMixin.at(list, 100, 0));
        assertEquals(Integer.valueOf(0), CollectionMixin.at(list, -100, 0));
    }

    @Test
    public void testSort() {
        List<Integer> originList = Arrays.asList(2, 1, 4, 3);
        List<Integer> expectedSorted = Arrays.asList(1, 2, 3, 4);
        List<Integer> expectedReverseSorted = Arrays.asList(4, 3, 2, 1);
        List<Integer> expectedReverse = Arrays.asList(3, 4, 1, 2);
        assertEquals(expectedSorted, CollectionMixin.sort(originList, null));
        assertEquals(expectedReverseSorted, CollectionMixin.reverseSort(originList, null));
        assertEquals(expectedReverse, CollectionMixin.reverse(originList));
    }

    @Test
    public void testSortByKE() {
        List<MyString> list = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            list.add(new MyString(String.valueOf(i)));
        }
        List<MyString> result = CollectionMixin.sort(list, MyString::getLength ,MyString::toString);
        assertEquals(list, result);
    }

}
