import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberListTest {
    private List<Integer> numberList;

    @BeforeEach
    private void getList() {
        numberList = new ArrayList<>(List.of(20, 99, 53, 18, 99, 46, 30, 31, 96, 80, 78, 57, 96, 5, 15, 79, 57, 28, 93, 53));
    }
    @Test
    public void getMinTest() {
       assertEquals(5, RandomNumbersList.getMin(numberList), "Min value should be 5!");
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
