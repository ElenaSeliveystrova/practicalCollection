import java.util.*;

public class RandomNumbersList {
    public static void numberCollections(int capacity, int givenNumber) {
        List<Integer> numbers = getNumbers(capacity);
        System.out.println(numbers);

        System.out.println("min " + getMin(numbers) + "\n" + "max " + getMax(numbers));

        System.out.println(averageValue(numbers));

        System.out.println(removeEven(numbers));

        System.out.println(numbers.contains(givenNumber));

        System.out.println(sortNumbers(numbers));

    }

    public static Integer getMax(List<Integer> numbers) {
        if (!numbers.isEmpty()) {
            return Collections.max(numbers);
        } else {
            System.out.println("Random numbers List is empty!!!");
            return 0;
        }
    }

    public static Integer getMin(List<Integer> numbers) {
        if (!numbers.isEmpty()) {
            return Collections.min(numbers);
        } else {
            System.out.println("Random numbers List is empty!!!");
            return 0;
        }
    }

    public static List<Integer> sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public static List<Integer> removeEven(List<Integer> numbers) {
        numbers.removeIf(n -> (n % 2) == 0);
        return numbers;
    }

    public static double averageValue(List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::intValue).average().orElse(0.0);
    }

    private static List<Integer> getNumbers(int capacity) {
        List<Integer> numbers = new ArrayList<>(capacity);
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            numbers.add(random.nextInt(1, 100));
        }
        return numbers;
    }


}
