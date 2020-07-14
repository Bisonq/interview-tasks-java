package eu.codeloop.task2;

import java.util.Arrays;

public final class Strings {

    private Strings() {
    }

    public static boolean hasDuplicateChars(String text) {
        if (text == null)
            throw new IllegalArgumentException("Given argument cannot be null!");

        if (text.length() < 2)
            return false;

        char[] charArray = text.toCharArray();
        Arrays.sort(charArray);

        for (int i = 0; i < charArray.length - 1; i++)
            if (charArray[i] == charArray[i + 1])
                return true;
        return false;
    }
}
