package org.localhost;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NumberFinderTest {

    private final NumberFinder objectUnderTest = new NumberFinder();

    @Test
    void ItShouldProcessNumbersAndReturnDataAsMap() {
//        given
        Integer[][] data = new Integer[][]{
                new Integer[]{1,3,4,5},
                new Integer[]{23,89,59},
                new Integer[]{66,22,5,13},
        };
//        when
        Map<String, Object> result = objectUnderTest.processNumbers(data);
        List<List<Integer>> expectedSortedArr = Arrays.asList(
                Arrays.asList(1, 3, 4, 5),
                Arrays.asList(23, 59, 89),
                Arrays.asList(5, 13, 22, 66)
        );
        Map<String, Object> expectedResultMap = Map.of(
                "Lowest_number", 1,
                "Sorted_number", expectedSortedArr
        );
//        then
        assertEquals(expectedResultMap, result);
    }

    @Test
    void itShouldThrowExceptionWhenInputIsNull() {
//        then
        assertThrows(IllegalArgumentException.class, () -> objectUnderTest.processNumbers(null));
    }

    @Test
    void itShouldThrowExceptionWhenInputArrIsEmpty() {
//        given
        Integer[][] data = new Integer[][]{
        };
//      then
        assertThrows(IllegalArgumentException.class, () -> objectUnderTest.processNumbers(data));
    }
}