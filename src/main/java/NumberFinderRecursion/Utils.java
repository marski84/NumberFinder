package NumberFinderRecursion;

import java.lang.reflect.Array;

public class Utils {
    public static <T> T[] flattenArray(T[][] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Input array is null or empty");
        }
        int flattenedLength = 0;
        for (int i = 0; i < input.length; i++) {
            flattenedLength += input[i].length;
        }

        T[] flat = new T[flattenedLength];
        T[] flattenedArray = (T[]) Array.newInstance(input[0].getClass().getComponentType(), flattenedLength);

        int index = 0;
        for (T[] subArray : input) {
            for (T element : subArray) {
                flattenedArray[index++] = element;
            }
        }
        return flattenedArray;
    }

    public static <T extends Comparable<T>> T getSmallestRecord(T[] inputData) {
        if (inputData == null || inputData.length == 0) {
            throw new IllegalArgumentException("Input array is null or empty");
        }
        T min = inputData[0];
        for (int i = 0; i < inputData.length; i++) {

            if (min.compareTo(inputData[i]) > 0 ) {
                min = inputData[i];
            }
        }

        return min;
    }


}
