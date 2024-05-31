package org.localhost;
import lombok.Data;
import java.util.List;

@Data
public class SortedNumbers implements NumberSort {
    private Integer lowestInt;

    @Override
    public int getLowestNumber() {
        return 0;
    }

    @Override
    public <T> List<T> getSortedNumbers() {
        return List.of();
    }
}
