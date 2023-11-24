import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RandomNumberListTest {
    private List<Integer> numberList;

    @BeforeEach
    private void getList() {
        numberList = new ArrayList<>(List.of(20, 99, 53, 18, 99, 46, 30, 31, 96, 80, 78, 57, 96, 5, 15, 79, 57, 28, 93, 53));
    }

    private static Stream<Arguments> arrayAndNumberProvider() {
        return Stream.of(
                Arguments.of(new ArrayList<>(List.of(20, 99, 53, 18, 99, 46, 30, 31, 96, 80, 78, 57, 96, 5, 15, 79, 57, 28, 93, 53)), 5),
                Arguments.of(new ArrayList<Integer>(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arrayAndNumberProvider")
    public void getMinTest(List<Integer> list, int expected) {
               assertEquals(expected, RandomNumbersList.getMin(list));
    }
    @Test
    public void getMaxTest() {
       assertEquals(99, RandomNumbersList.getMax(numberList), "Max value should be 99!");
    }

    @Test
    public void averageValueTest() {
       assertEquals(56.65, RandomNumbersList.averageValue(numberList), "Average value should be 56.65!");
    }

    @Test
    public void removeEvenTest() {
        List<Integer> expectedList = List.of(99, 53, 99, 31, 57, 5, 15, 79, 57, 93, 53);
       assertEquals(expectedList, RandomNumbersList.removeEven(numberList));
    }

    @Test
    public void sortNumbersTest() {
        List<Integer> expectedList = List.of(5, 15, 18, 20, 28, 30, 31, 46, 53, 53, 57, 57, 78, 79, 80, 93, 96, 96, 99, 99);
        assertEquals(expectedList, RandomNumbersList.sortNumbers(numberList));
    }
}
