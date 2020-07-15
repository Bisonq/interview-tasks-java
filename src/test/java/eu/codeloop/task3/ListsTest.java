package eu.codeloop.task3;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ListsTest {

    @Test
    public void shouldMapBy() {
        // given
        Book lordOfTheRings = new Book(1, "Lord of the Rings");
        Book mythicalManMonth = new Book(2, "Mythical Man Month");
        List<Book> books = Arrays.asList(lordOfTheRings, mythicalManMonth);

        // when
        Map<Integer, Book> integerObjectMap = Lists.mapBy(books, Book::getId);

        // then
        assertThat(integerObjectMap.get(1)).isEqualTo(lordOfTheRings);
        assertThat(integerObjectMap.get(2)).isEqualTo(mythicalManMonth);
    }

    @Test
    public void shouldReturnEmptyMapWhenEmptyCollectionIsGiven(){
        //given
        Collection<Book> books = new ArrayList<>();

        //when
        Map<Integer, Book> resultMap = Lists.mapBy(books, Book::getId);

        //then
        assertThat(resultMap).isEmpty();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionWhenGivenCollectionIsNull(){
        //given
        Collection<Book> books = null;

        //when
        Lists.mapBy(books, Book::getId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionWhenGivenFunctionIsNull(){
        //given
        Collection<Book> books = null;

        //when
        Lists.mapBy(books, null);
    }

    @Test
    public void resultMapShouldContainsTheSameObjectsThatGivenCollectionContains(){
        //given
        Book lordOfTheRings = new Book(1, "Lord of the Rings");
        Book mythicalManMonth = new Book(2, "Mythical Man Month");
        List<Book> books = Arrays.asList(lordOfTheRings, mythicalManMonth);

        //when
        Map<Integer, Book> integerObjectMap = Lists.mapBy(books, Book::getId);
        Book mapBook1 = integerObjectMap.get(1);
        Book mapBook2 = integerObjectMap.get(2);

        //then
        assertThat(mapBook1).isSameAs(lordOfTheRings);
        assertThat(mapBook2).isSameAs(mythicalManMonth);
    }

    @Test
    public void resultMapShouldHaveSameLengthThatGivenCollection(){
        //given
        Book lordOfTheRings = new Book(1, "Lord of the Rings");
        Book mythicalManMonth = new Book(2, "Mythical Man Month");
        List<Book> books = Arrays.asList(lordOfTheRings, mythicalManMonth);

        //when
        Map<Integer, Book> integerObjectMap = Lists.mapBy(books, Book::getId);
        int resultMapLength = integerObjectMap.size();

        //then
        assertThat(resultMapLength).isEqualTo(books.size());
    }

    @Test
    public void valuesInResultMapShouldBeGroupByBookID(){
        //given
        int bookId1 = 1;
        int bookId2 = 2;
        Book lordOfTheRings = new Book(bookId1, "Lord of the Rings");
        Book mythicalManMonth = new Book(bookId2, "Mythical Man Month");
        List<Book> books = Arrays.asList(lordOfTheRings, mythicalManMonth);

        //when
        Map<Integer, Book> integerObjectMap = Lists.mapBy(books, Book::getId);
        Set<Integer> resultMapKeys = integerObjectMap.keySet();

        //then
        assertThat(resultMapKeys).contains(bookId1, bookId2);
    }

    @Test
    public void valuesInResultMapShouldBeGroupByBookTitle(){
        //given
        String bookTitle1 = "Lord of the Rings";
        String bookTitle2 = "Mythical Man Month";

        Book lordOfTheRings = new Book(1, bookTitle1);
        Book mythicalManMonth = new Book(2, bookTitle2);
        List<Book> books = Arrays.asList(lordOfTheRings, mythicalManMonth);

        //when
        Map<String, Book> integerObjectMap = Lists.mapBy(books, Book::getTitle);
        Set<String> resultMapKeys = integerObjectMap.keySet();

        //then
        assertThat(resultMapKeys).contains(bookTitle1, bookTitle2);
    }

    @Test
    public void shouldReturnEmptyMapWhenElementInGivenCollectionIsNull(){
        //given
        List<Book> books = new ArrayList<>();
        books.add(null);
        books.add(null);

        //when
        Map<String, Book> integerObjectMap = Lists.mapBy(books, Book::getTitle);

        //then
        assertThat(integerObjectMap).isEmpty();
    }

    @Test
    public void resultMapShouldContainOverwrittenElementsWhenTheGroupingValuesAreTheSame(){
        //given
        String bookTitle1 = "Lord of the Rings";
        String bookTitle2 = "Lord of the Rings";
        Book book1 = new Book(1, bookTitle1);
        Book book2 = new Book(2, bookTitle2);

        int bookId1 = 1;
        int bookId2 = 1;
        Book book3 = new Book(bookId1, "Lord of the Rings");
        Book book4 = new Book(bookId2, "Mythical Man Month");

        List<Book> books1 = Arrays.asList(book1, book2);
        List<Book> books2 = Arrays.asList(book3, book4);

        //when
        Map<String, Book> booksByTile = Lists.mapBy(books1, Book::getTitle);
        Book overwrittenBookByTitle = booksByTile.get("Lord of the Rings");

        Map<Integer, Book> booksByID = Lists.mapBy(books2, Book::getId);
        Book overwrittenBookByID = booksByID.get(1);

        //then
        assertThat(overwrittenBookByTitle).isSameAs(book2);
        assertThat(overwrittenBookByID).isSameAs(book4);

    }
}
