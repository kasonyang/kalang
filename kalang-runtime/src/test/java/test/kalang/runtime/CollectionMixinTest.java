package test.kalang.runtime;

import kalang.mixin.CollectionMixin;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author KasonYang
 */
public class CollectionMixinTest {

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

}
