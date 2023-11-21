import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationWithBooks {
    public static void allMethodsBooks(){
        String genre1 = "Fairy tale";
        String genre2 = "Detective";
        Book book1 = new Book("Farbovanyy lys", "Ivan Franko", genre1, 1899);
        Book book2 = new Book("Khlopchyk-zirka", "Uald Oskar", genre1, 1888);
        Book book3 = new Book("Leliia", "Lesia Ukrainka", genre1, 1891);
        Book book4 = new Book("Vbyty legko", "Agata Cristy", genre2, 1939);
        List<Book> booksList = List.of(book1, book2, book3, book4);
        //4.1
        System.out.println(getAuthorsOfBooks(booksList));
        //4.2
        System.out.println(getAuthorsByGenre(booksList, genre1));
        //4.3
        System.out.println(getAuthorsByYear(booksList, 1899));
        //4.4
        System.out.println(getBookByAuthor(booksList, "Ivan Franko"));
        //4.5
        System.out.println(getBooksByYear(booksList, 1899));
        //4.6
        System.out.println(getBooksByGenre(booksList, genre1));
        //4.7
        System.out.println(removeBooksByAuthor(booksList, "Agata Cristy"));
        //4.8
        System.out.println(sortByCriteria(booksList, "author"));
        System.out.println(sortByCriteria(booksList, "title"));
        System.out.println(sortByCriteria(booksList, "year"));
        //4.9
        Book book5 = new Book("Moysey", "Ivan Franko", "philosophy poem", 1905);
        Book book6 = new Book("Kobzar", "Taras Shevchenko", genre1, 1840);
        List<Book> bookList2 = List.of(book5, book6);
        List<Book> bookList3 = mergeBookCollections(booksList, bookList2);
        System.out.println(bookList3);
        //4.10
        System.out.println(subcollectionOfBookByGenre(bookList3, genre1));
    }
    // task 4
    public static List<String> getAuthorsOfBooks(List<Book> books) {
        return books.stream().map(Book::getAuthor).collect(Collectors.toList());
    }

    public static List<String> getAuthorsByGenre(List<Book> books, String genre) {
        return books.stream().filter(book -> book.getGenre().equals(genre)).map(Book::getAuthor).collect(Collectors.toList());
    }

    public static List<String> getAuthorsByYear(List<Book> books, int year) {
        return books.stream().filter(book -> book.getYear() == year).map(Book::getAuthor).collect(Collectors.toList());
    }

    public static Book getBookByAuthor(List<Book> books, String author) {
        return books.stream().filter(book -> book.getAuthor().equals(author)).findFirst().orElseThrow();
    }

    public static List<Book> getBooksByYear(List<Book> books, int year) {
        return books.stream().filter(book -> book.getYear() == year).collect(Collectors.toList());
    }

    private static List<Book> getBooksByGenre(List<Book> booksList, String genre) {
        return booksList.stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
    }

    private static String removeBooksByAuthor(List<Book> booksList, String author) {

        return booksList.removeIf(book -> book.getAuthor().equals(author)) ? "Author " + author +  "was removed" : "Author not found!";
    }

    private static List<Book> sortByCriteria(List<Book> booksList, String sortCriteria) {

        Map<String, Comparator<Book>> map = Map.of(
                "title", Comparator.comparing(Book::getTitle),
                "author", Comparator.comparing(Book::getAuthor),
                "year", Comparator.comparing(Book::getYear));
        booksList.sort(map.get(sortCriteria));
        return booksList;
    }

    private static List<Book> mergeBookCollections(List<Book> booksList, List<Book> booksList1){
        return Stream.of(booksList, booksList1).flatMap(Collection::stream).collect(Collectors.toList());
    }

    private static List<Book> subcollectionOfBookByGenre(List<Book> booksList, String genre){
        return booksList.stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
    }
}
