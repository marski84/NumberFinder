package org.localhost;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;


public class NumberFinder implements NumbersUtils {


    public Map<String, List<?>> processNumbers(Integer[][] numbers) {
        validateInput(numbers);
        List<List<Integer>> list = normalizeData(numbers);
        List<Integer> lowestNumber = getLowestNumber(list);
        List<List<Integer>> sortedNumbers = sortNumbers(list);
        return Map.of("Sorted_number", sortedNumbers, "Lowest_number", lowestNumber);
    }

    public List<List<Integer>> sortNumbers(@NotNull List<List<Integer>> numbers) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> arr : numbers) {
            List<Integer> sublist = new ArrayList<>(arr);
            Collections.sort(sublist);
            result.add(sublist);
        }
//opcja ze streamApi- ale w tym przypadku modyfikuje kolejność w inpucie
//        List<List<Integer>> numbersCopy = new ArrayList<>(numbers);
//        numbersCopy.stream().forEach(numberArr -> numberArr.sort(
//                new Comparator<Integer>() {
//                    @Override
//                    public int compare(Integer o1, Integer o2) {
//                        return o1.compareTo(o2);
//                    }
//                }
//        ));

        return result;
    }

    private List<List<Integer>> normalizeData(@NotNull Integer[][] data) {
        if (data == null || data.length == 0) return Collections.emptyList();
        return Arrays.stream(data)
                .map(arr -> Arrays.asList(arr))
                .collect(Collectors.toList());
    }

    public List<Integer> getLowestNumber(@NotNull List<List<Integer>> numbers) {

        return findLowestNumber(numbers);
    }

    private List<Integer> findLowestNumber(@NotNull List<List<Integer>> numbers) {
        List lowestNumbersList = numbers.stream()
                .map(list -> Collections.min(list))
                .sorted()
                .toList();
//        return (Integer) lowestNumbersList.get(0);
        return Collections.singletonList(Collections.min(lowestNumbersList, Integer::compareTo));
    }

    private void validateInput(Integer[][] inputArr) {
        if (inputArr == null) {
            throw new IllegalArgumentException("inputArr is null");
        }

        if (inputArr.length == 0) {
            throw new IllegalArgumentException("inputArr is empty");

        }

    }
}