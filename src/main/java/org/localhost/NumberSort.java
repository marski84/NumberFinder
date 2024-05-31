package org.localhost;

import java.util.List;

public interface NumberSort {
    abstract int getLowestNumber();
    abstract <T> List<T> getSortedNumbers();
}
