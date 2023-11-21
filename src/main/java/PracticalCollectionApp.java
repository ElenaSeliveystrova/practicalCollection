import java.util.*;

public class PracticalCollectionApp {
    private static final Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        //1.1
        System.out.println("Enter string 1");
        String string1 = SCANNER.nextLine();
        System.out.println("Enter string 2");
        String string2 = SCANNER.nextLine();
        System.out.println(equalString(string1, string2));

        //1.2
        System.out.println("Enter String");
        String st = SCANNER.nextLine();
        System.out.println("Enter index1");
        int index1 = SCANNER.nextInt();
        System.out.println("Enter index2");
        int index2 = SCANNER.nextInt();
        System.out.println(concatString(st, index1, index2));

        //1.3
        System.out.println(checkString(string1, string2));
        // 1.4
        String y = "Write a method that replaces all occurrences of one substring with another in a given string.";
        System.out.println(replace(y, "a", "@"));
        //1.5
        String x1 = "we34fgh";
        String x2 = "vbgkjds";
        System.out.println(containsDigits(x1));
        System.out.println(containsDigits(x2));
        //1.6
        String a = "  Write a method ";
        System.out.println(removeSpaces(a));
        //1.7
        String s = "Create a method that splits a string into an array of substrings according to a given delimiter.";
        System.out.println(Arrays.toString(splitString(s, "a")));

        //2
        Rectangle rectangle = new Rectangle(4, 2);
        System.out.println("height " + rectangle.getHeight() + "\n"
                + "width " + rectangle.getWidth() + "\n"
                + "diagonal " + rectangle.getDiagonal() + "\n"
                + "area " + rectangle.calculateArea() + "\n"
                + "perimeter " + rectangle.calculatePerimeter() + "\n");

        rectangle.setWidth(6);
        rectangle.setHeight(4);
        System.out.println("New height " + rectangle.getHeight() + ". New width " + rectangle.getWidth());

        //3
        int givenNumber = 67;
        numberCollections(givenNumber);

        //4
        OperationWithBooks.allMethodsBooks();
    }

    // task 1.1
    public static boolean equalString(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    //task 1.2
    public static String concatString(String st, int index1, int index2) {
        if (index1 < 0 || st.length() < index2) {
            return "Indexes aren't correct!!!";
        } else {
            return st.substring(index1, index2);
        }
    }

    //     task 1.3
    public static int checkString(String line, String st) {
        int result = line.indexOf(st);
        if (result < 0) {
            System.out.println("Substring is not contained in a given string");
        }
        return result;
    }

    // task 1.4
    public static String replace(String string, String st2, String st3) {
        return string.replaceAll(st2, st3);

    }

    // task 1.5
    public static boolean containsDigits(String string) {
        return string.matches(".*\\d.*");
    }

    // task 1.6
    public static String removeSpaces(String string) {
        return string.trim();
    }

    // task 1.7
    public static String[] splitString(String string, String delimiter) {
        return string.split(delimiter);
    }

    // task 3
    public static void numberCollections(int givenNumber) {
        int capacity = 20;
        List<Integer> numbers = new ArrayList<>(capacity);
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            numbers.add(random.nextInt(1, 100));
        }
        System.out.println(numbers);

        int minValue = Collections.min(numbers);
        int maxValue = Collections.max(numbers);
        System.out.println("min " + minValue + "\n" + "max " + maxValue);

        numbers.stream().mapToDouble(Integer::intValue).average().ifPresent(System.out::println);

        numbers.removeIf(n -> (n % 2) == 0);
        System.out.println(numbers);

        System.out.println(numbers.contains(givenNumber));

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);

    }

}
