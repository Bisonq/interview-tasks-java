package eu.codeloop.task1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    public void shouldFindOddNumbers() {
        // given
        List<String> numbersAsText = Arrays.asList("1", "2", "3");

        // when
        List<Integer> numbers = Numbers.findOddNumbers(numbersAsText);

        // then
        assertThat(numbers).containsOnly(1, 3);
    }

    @Test
    public void otherTestCases() {
        // Numbers.findOddNumbers(Arrays.asList("1", "", "3"));
        // Numbers.findOddNumbers(null);
        // something more? what do you think? test them all!
    }
}
