package eu.codeloop.task3;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ListsTest {

    @Test
    public void shouldMapBy() {
        // given
        Book lordOfTheRings = new Book(1, "Lord of the Rings");
        Book mythicalManMonth = new Book(2, "Mythical Man Month");
        List<Book> books = Arrays.asList(lordOfTheRings, mythicalManMonth);

        // when
        Map<Integer, Book> integerObjectMap = Lists.mapBy(books, Book::getId);
        Map<Integer, Book> integerObjectMapV2 = Lists.mapByV2(books, Book::getId);

        // then
        assertThat(integerObjectMap.get(1)).isEqualTo(lordOfTheRings);
        assertThat(integerObjectMap.get(2)).isEqualTo(mythicalManMonth);

        assertThat(integerObjectMapV2.get(1)).isEqualTo(lordOfTheRings);
        assertThat(integerObjectMapV2.get(2)).isEqualTo(mythicalManMonth);
    }

    @Test
    public void shouldReturnEmptyMapWhenEmptyCollectionIsGiven(){
        //given
        Collection<Book> books = new ArrayList<>();

        //when
        Map<Integer, Book> resultMap = Lists.mapBy(books, Book::getId);
        Map<Integer, Book> resultMapV2 = Lists.mapByV2(books, Book::getId);

        //then
        assertThat(resultMap).isEmpty();
        assertThat(resultMapV2).isEmpty();
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenGivenCollectionIsNull(){
        //given
        Collection<Book> books = null;

        //when
        assertThatIllegalArgumentException().isThrownBy( () -> Lists.mapBy(books, Book::getId));
        assertThatIllegalArgumentException().isThrownBy( () -> Lists.mapByV2(books, Book::getId));
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenGivenFunctionIsNull(){
        //given
        Collection<Book> books = null;

        //when
        assertThatIllegalArgumentException().isThrownBy( () -> Lists.mapBy(books, null));
        assertThatIllegalArgumentException().isThrownBy( () -> Lists.mapByV2(books, null));
    }

    @Test
    public void resultMapShouldContainsTheSameObjectsThatGivenCollectionContains(){
        //given
        Book lordOfTheRings = new Book(1, "Lord of the Rings");
        Book mythicalManMonth = new Book(2, "Mythical Man Month");
        List<Book> books = Arrays.asList(lordOfTheRings, mythicalManMonth);

        //when
        Map<Integer, Book> integerObjectMap = Lists.mapBy(books, Book::getId);
        Map<Integer, Book> integerObjectMapV2 = Lists.mapByV2(books, Book::getId);

        Book mapBook1 = integerObjectMap.get(1);
        Book mapBook2 = integerObjectMap.get(2);

        Book mapBook1V2 = integerObjectMapV2.get(1);
        Book mapBook2V2 = integerObjectMapV2.get(2);

        //then
        assertThat(mapBook1).isSameAs(lordOfTheRings);
        assertThat(mapBook2).isSameAs(mythicalManMonth);

        assertThat(mapBook1V2).isSameAs(lordOfTheRings);
        assertThat(mapBook2V2).isSameAs(mythicalManMonth);
    }

    @Test
    public void resultMapShouldHaveSameLengthThatGivenCollection(){
        //given
        Book lordOfTheRings = new Book(1, "Lord of the Rings");
        Book mythicalManMonth = new Book(2, "Mythical Man Month");
        List<Book> books = Arrays.asList(lordOfTheRings, mythicalManMonth);

        //when
        Map<Integer, Book> integerObjectMap = Lists.mapBy(books, Book::getId);
        Map<Integer, Book> integerObjectMapV2 = Lists.mapByV2(books, Book::getId);

        int resultMapLength = integerObjectMap.size();
        int resultMapLengthV2 = integerObjectMapV2.size();

        //then
        assertThat(resultMapLength).isEqualTo(books.size());
        assertThat(resultMapLengthV2).isEqualTo(books.size());
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
        Map<Integer, Book> integerObjectMapV2 = Lists.mapByV2(books, Book::getId);

        Set<Integer> resultMapKeys = integerObjectMap.keySet();
        Set<Integer> resultMapKeysV2 = integerObjectMapV2.keySet();

        //then
        assertThat(resultMapKeys).contains(bookId1, bookId2);
        assertThat(resultMapKeysV2).contains(bookId1, bookId2);
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
        Map<String, Book> integerObjectMapV2 = Lists.mapByV2(books, Book::getTitle);

        Set<String> resultMapKeys = integerObjectMap.keySet();
        Set<String> resultMapKeysV2 = integerObjectMapV2.keySet();

        //then
        assertThat(resultMapKeys).contains(bookTitle1, bookTitle2);
        assertThat(resultMapKeysV2).contains(bookTitle1, bookTitle2);
    }

    @Test
    public void shouldReturnEmptyMapWhenElementInGivenCollectionIsNull(){
        //given
        List<Book> books = new ArrayList<>();
        books.add(null);
        books.add(null);

        //when
        Map<String, Book> integerObjectMap = Lists.mapBy(books, Book::getTitle);
        Map<String, Book> integerObjectMapV2 = Lists.mapByV2(books, Book::getTitle);

        //then
        assertThat(integerObjectMap).isEmpty();
        assertThat(integerObjectMapV2).isEmpty();
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
        Map<String, Book> booksByTileV2 = Lists.mapByV2(books1, Book::getTitle);

        Book overwrittenBookByTitle = booksByTile.get("Lord of the Rings");
        Book overwrittenBookByTitleV2 = booksByTileV2.get("Lord of the Rings");

        Map<Integer, Book> booksByID = Lists.mapBy(books2, Book::getId);
        Map<Integer, Book> booksByIDV2 = Lists.mapByV2(books2, Book::getId);

        Book overwrittenBookByID = booksByID.get(1);
        Book overwrittenBookByIDV2 = booksByIDV2.get(1);

        //then
        assertThat(overwrittenBookByTitle).isSameAs(book2);
        assertThat(overwrittenBookByID).isSameAs(book4);

        assertThat(overwrittenBookByTitleV2).isSameAs(book2);
        assertThat(overwrittenBookByIDV2).isSameAs(book4);
    }
}
