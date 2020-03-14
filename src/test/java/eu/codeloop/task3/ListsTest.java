package eu.codeloop.task3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ListsTest {

    @Test
    public void shouldFindOddNumbers() {
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
    public void otherTestCases() {
        // something more? what do you think? test them all!
        // what about duplicates - let's say we have `mapBy(books, Book::getTitle)` and books contain two books with the same title
    }
}
