package org.localhost;
import org.jetbrains.annotations.NotNull;
import java.util.*;
public class NumberFinder implements NumbersUtils {

    public Map<String, Object> processNumbers(final Integer[][] numbers) {
        validateInput(numbers);
        List<List<Integer>> list = normalizeData(numbers);
        Integer lowestNumber = getLowestNumber(list);
        List<List<Integer>> sortedNumbers = sortNumbers(list);
        return Map.of("Sorted_number", sortedNumbers, "Lowest_number", lowestNumber);
    }

    @Override
    public List<List<Integer>> sortNumbers(@NotNull final List<List<Integer>> numbers) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> arr : numbers) {
            List<Integer> sublist = new ArrayList<>(arr);
            Collections.sort(sublist);
            result.add(sublist);
        }
        return result;
    }

    @Override
    public Integer getLowestNumber(@NotNull final List<List<Integer>> numbers) {
        return findLowestNumber(numbers);
    }

    private Integer findLowestNumber(@NotNull final List<List<Integer>> numbers) {
        List<Integer> lowestNumbersList = numbers.stream()
                .map(Collections::min)
                .sorted()
                .toList();
        return lowestNumbersList.get(0);
    }

    private void validateInput(Integer[][] inputArr) {
        if (inputArr == null) {
            throw new IllegalArgumentException("inputArr is null");
        }

        if (inputArr.length == 0) {
            throw new IllegalArgumentException("inputArr is empty");

        }

    }

    private List<List<Integer>> normalizeData(@NotNull final Integer[][] data) {
        if (data == null || data.length == 0) return Collections.emptyList();
        return Arrays.stream(data)
                .map(Arrays::asList)
                .toList();
    }
}