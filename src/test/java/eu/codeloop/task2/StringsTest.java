package eu.codeloop.task2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringsTest {

    @Test
    public void shouldReturnTrueWhenStringHasDuplicateChars() {
        // given
        String text = "abcad";

        // when
        boolean hasDuplicateChars = Strings.hasDuplicateChars(text);

        // then
        assertThat(hasDuplicateChars).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenStringNotHasDuplicateChars() {
        // given
        String text1 = "abc";
        String text2 = "$1p";

        // when
        boolean hasDuplicateChars1 = Strings.hasDuplicateChars(text1);
        boolean hasDuplicateChars2 = Strings.hasDuplicateChars(text2);

        // then
        assertThat(hasDuplicateChars1).isFalse();
        assertThat(hasDuplicateChars2).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenArgumentIsNull() {
        //given
        String str = null;

        //when
        Strings.hasDuplicateChars(str);
    }

    @Test
    public void shouldReturnFalseWhenStringLengthIsLessThenTwo(){
        //given
        String str1 = "a";
        String str2 = "";

        //when
        boolean hasDuplicateChars1 = Strings.hasDuplicateChars(str1);
        boolean hasDuplicateChars2 = Strings.hasDuplicateChars(str2);

        //then
        assertThat(hasDuplicateChars1).isFalse();
        assertThat(hasDuplicateChars2).isFalse();
    }
}
