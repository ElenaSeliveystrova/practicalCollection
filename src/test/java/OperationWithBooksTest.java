import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class OperationWithBooksTest {
    private static final String genre1 = "Poem";
    private static final String genre2 = "Fairy Tail";
    private static final String genre3 = "Detective";
    private static final String author1 = "Lesia Ukrainka";
    private static final String author2 = "Ivan Franko";
    private static final String author3 = "Uald Oskar";
    private static final String author4 = "Agata Cristy";
    private static final String author5 = "Taras Shevchenko";
    private static final String author6 = "Jack London";
    private static final String author7 = "O'Genry";
    private static final int yearSearch = 1905;
    private static List<Book> bookList;
    private final List<String> emptyList = new ArrayList<>();

    private static final Book book1 = new Book("Farbovanyy lys", author2, genre2, 1899);
    private static final Book book2 = new Book("Khlopchyk-zirka", author3, genre2, 1888);
    private static final Book book3 = new Book("Leliia", author1, genre2, 1891);
    private static final Book book4 = new Book("Vbyty legko", author4, genre3, 1939);
    private static final Book book5 = new Book("Moysey", author2, genre1, yearSearch);
    private static final Book book6 = new Book("Kobzar", author5, genre1, 1840);
    private static final Book book7 = new Book("White Fang", author6, "story", yearSearch);
    private static final Book book8 = new Book("Gifts of the Magi", author7, "novel", yearSearch);


    @BeforeEach
    public void createData() {
        bookList = new ArrayList<>(List.of(book1, book2, book3, book4, book5, book6, book7, book8));
    }

    @Test
    public void getAuthorsOfBooksTest() {
        List<String> authorsExpected = new ArrayList<>(List.of(author2, author3, author1, author4, author2, author5, author6, author7));
        assertEquals(authorsExpected, OperationWithBooks.getAuthorsOfBooks(bookList));
    }

    @Test
    public void getAuthorsByGenreTest() {
        List<String> authorsExpected = new ArrayList<>(List.of(author2, author3, author1));
        assertEquals(authorsExpected, OperationWithBooks.getAuthorsByGenre(bookList, genre2));
    }

    @Test
    public void getAuthorsByGenreNotFoundGenreTest() {
        assertEquals(emptyList, OperationWithBooks.getAuthorsByGenre(bookList, "horror"));
    }

    @Test
    public void getAuthorsByYearTest() {
        List<String> authorsExpected = new ArrayList<>(List.of(author2, author6, author7));
        assertEquals(authorsExpected, OperationWithBooks.getAuthorsByYear(bookList, yearSearch));
    }

    @Test
    public void getAuthorsByYearNotFoundTest() {
        assertEquals(emptyList, OperationWithBooks.getAuthorsByYear(bookList, 1900));
    }

    @Test
    public void getBookByAuthorTest() {
        assertEquals(book1, OperationWithBooks.getBookByAuthor(bookList, author2));
    }

    @Test
    public void getBookByAuthorNotFoundAuthorTest() {
        assertThrows(NoSuchElementException.class, () -> OperationWithBooks.getBookByAuthor(bookList, "author"));
    }

    @Test
    public void getBooksByYearTest() {
        assertEquals(3, OperationWithBooks.getBooksByYear(bookList, yearSearch).size());
    }

    @Test
    public void getBooksByYearNotFoundYearTest() {
        assertEquals(new ArrayList<Book>(), OperationWithBooks.getBooksByYear(bookList, 1900));
    }

    @Test
    public void getBooksByGenreTest() {
        List<Book> authorsExpected = new ArrayList<>(List.of(book1, book2, book3));
        assertEquals(authorsExpected, OperationWithBooks.getBooksByGenre(bookList, genre2));
        assertEquals(3, OperationWithBooks.getBooksByGenre(bookList, genre2).size());
    }

    @Test
    public void getBooksByGenreNotFoundGenreTest() {
        assertEquals(new ArrayList<Book>(), OperationWithBooks.getBooksByGenre(bookList, "Horror"));
    }

    @Test
    public void removeBooksByAuthorTest() {
        String expected = "Author " + author4 + "was removed";
        assertEquals(expected, OperationWithBooks.removeBooksByAuthor(bookList, author4));
    }

    @Test
    public void removeBooksByAuthorNotFoundTest() {
        String expected = "Author not found!";
        assertEquals(expected, OperationWithBooks.removeBooksByAuthor(bookList, "Nechuy Levitskiy"));
    }

    public static Stream<Arguments> criteriaAndListProvider() {
        return Stream.of(
                Arguments.of("title", List.of(book1, book8, book2, book6, book3, book5, book4, book7)),
                Arguments.of("author", List.of(book4, book1, book5, book7, book3, book8, book6, book2)),
                Arguments.of("year", List.of(book6, book2, book3, book1, book5, book7, book8, book4))
        );
    }
    @ParameterizedTest
    @MethodSource("criteriaAndListProvider")
    public void sortByCriteriaTest(String criteria, List<Book> filterListExpected) {
        assertEquals(filterListExpected, OperationWithBooks.sortByCriteria(bookList, criteria));
    }

    @Test
    public void mergeBookCollectionsTest() {
        Book b = new Book("36 i 6 kotiv", "Galina Vdovichenko", genre3, 2015);
        Book b2 = new Book("Natalka Poltavka", "Ivan Kotlarevskiy", "drama", 1819);
        List<Book> bookList2 = new ArrayList<>(List.of(b, b2));
        List<Book> expectedList = new ArrayList<>(bookList);
        expectedList.add(b);
        expectedList.add(b2);
        assertEquals(expectedList.size(), OperationWithBooks.mergeBookCollections(bookList, bookList2).size());
    }


}
