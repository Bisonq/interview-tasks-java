package eu.codeloop.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Numbers {

    private Numbers() {
    }

    public static List<Integer> findOddNumbers(List<String> numbers) {
        if (numbers == null)
            throw new IllegalArgumentException("Given argument cannot be null!");

        List<Integer> resultList = new ArrayList<>();

        if (numbers.isEmpty())
            return resultList;

        for (String numberSequence : numbers) {
            if (isSequenceOfNumbers(numberSequence)) {
                int extractedNumber = Integer.parseInt(numberSequence);
                if (extractedNumber % 2 != 0)
                    resultList.add(extractedNumber);
            }
        }
        return resultList;
    }

    protected static boolean isSequenceOfNumbers(String sequence) {
        if (sequence == null || sequence.length() < 1)
            return false;
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(sequence);
        return matcher.matches();
    }
}
