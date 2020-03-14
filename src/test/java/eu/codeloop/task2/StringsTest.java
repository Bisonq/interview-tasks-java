package eu.codeloop.task2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringsTest {

    @Test
    public void shouldFindOddNumbers() {
        // given
        String text = "abcad";

        // when
        boolean hasDuplicateChars = Strings.hasDuplicateChars(text);

        // then
        assertThat(hasDuplicateChars).isTrue();
    }

    @Test
    public void otherTestCases() {
        // something more? what do you think? test them all!
    }
}
