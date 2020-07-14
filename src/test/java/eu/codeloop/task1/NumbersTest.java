package eu.codeloop.task1;

import org.junit.Test;

import java.util.ArrayList;
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

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenGivenArgumentIsNull() {
        //given
        List<String> list = null;

        //when
        Numbers.findOddNumbers(list);
    }

    @Test
    public void shouldReturnEmptyListWhenEmptyListIsGiven() {
        //given
        List<String> list = new ArrayList<>();

        //when
        List<Integer> resultList = Numbers.findOddNumbers(list);

        //then
        assertThat(resultList).isEmpty();
    }

    @Test
    public void numbersShouldBeInCorrectOrderInTheResultList() {
        //given
        List<String> list = new ArrayList<>();
        int a = 1;
        int b = 3;
        list.add(String.valueOf(a));
        list.add(String.valueOf(b));

        //when
        List<Integer> resultLst = Numbers.findOddNumbers(list);

        //then
        assertThat(resultLst).contains(a, b);
    }

    @Test(expected = NumberFormatException.class)
    public void sequenceShouldNotExceedsMaxIntegerValue() {
        //given
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(Integer.MAX_VALUE) + 1);

        //when
        Numbers.findOddNumbers(list);

    }

    @Test
    public void sequenceOfNumbersMethodShouldReturnTrueWhenSequenceIsIntegerNumber() {
        //given
        String sequence1 = "7";
        String sequence2 = "-22";
        String sequence3 = "9999999999999999999";

        //when
        boolean result1 = Numbers.isSequenceOfNumbers(sequence1);
        boolean result2 = Numbers.isSequenceOfNumbers(sequence2);
        boolean result3 = Numbers.isSequenceOfNumbers(sequence3);

        //then
        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
    }

    @Test
    public void sequenceOfNumbersMethodShouldReturnFalseWhenSequenceIsNotIntegerNumber() {
        //given
        String sequence1 = "1.2";
        String sequence2 = "a1b2c3";
        String sequence3 = "-^";

        //when
        boolean result1 = Numbers.isSequenceOfNumbers(sequence1);
        boolean result2 = Numbers.isSequenceOfNumbers(sequence2);
        boolean result3 = Numbers.isSequenceOfNumbers(sequence3);

        //then
        assertThat(result1).isFalse();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }


    @Test
    public void sequenceOfNumbersMethodShouldReturnFalseWhenSequenceIsNull() {
        //given
        String sequence = null;

        //when
        boolean result = Numbers.isSequenceOfNumbers(sequence);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void sequenceOfNumbersMethodShouldReturnFalseWhenSequenceLengthIsLessThanOne() {
        //given
        String sequence = "";

        //when
        boolean result = Numbers.isSequenceOfNumbers(sequence);

        //then
        assertThat(result).isFalse();
    }
}
