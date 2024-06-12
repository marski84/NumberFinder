package NumberFinderRecursion;

import java.util.List;
import java.util.*;

import static NumberFinderRecursion.QuickSort.quickSort;

public class NumberFinderRecursion {

    public static void main(String[] args) {
        Random random = new Random();

        Integer[][] data = new Integer[][]{
                new Integer[]{1, 3, 4, 5},
                new Integer[]{23, 89, 59},
                new Integer[]{66, 22, 5, 13},
        };
        Integer[] empty = new Integer[]{};
        Double[][] data2 = new Double[][]{
                new Double[]{random.nextDouble(100), random.nextDouble(100), random.nextDouble(100), random.nextDouble(100), random.nextDouble(100), random.nextDouble(100)},
                new Double[]{random.nextDouble(100), random.nextDouble(100), random.nextDouble(100), random.nextDouble(100), random.nextDouble(100), random.nextDouble(100)},
                new Double[]{random.nextDouble(100), random.nextDouble(100), random.nextDouble(100), random.nextDouble(100), random.nextDouble(100), random.nextDouble(100)},
        };
        numberSort(data2);



    }

    public static <T extends Comparable<T>> SortedNumbers<T> numberSort(T[][] numbers) {
//        validate input
        if (numbers == null) {
            throw new IllegalArgumentException("numbers cannot be null");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException("numbers cannot be empty");
        }

        List<T> lowestNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != null && numbers[i].length > 0) {
                quickSort(numbers[i], 0, numbers[i].length - 1);
//                lowestNumbers.add(numbers[i][0]);
            }
//            check
//            for (T number : numbers[i]) {
//                System.out.println(number);
//                System.out.println("next");
//            }
        }
        T[] flattenedArray = Utils.flattenArray(numbers);
        T min = Utils.getSmallestRecord(flattenedArray);
        System.out.println(min);
        System.out.println("lista");
        Arrays.stream(flattenedArray).sorted().forEach(System.out::println);





        final SortedNumbers sortedNumbers = new SortedNumbers();
        return null;
    }








    public static final class SortedNumbers<T> {
        private int lowestNumber;
        private List<T> sortedNumbers;

        public int getLowestNumber() {
            return lowestNumber;
        }

        public List<T> getSortedNumbers() {
            return sortedNumbers;
        }
    }


}