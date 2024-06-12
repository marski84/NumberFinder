package NumberFinderRecursion;


public class QuickSort {

    public static <T extends Comparable<T>> void  quickSort(T[] myArray, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(myArray, low, high);
            quickSort(myArray, low, pivotIndex - 1);
            quickSort(myArray, pivotIndex + 1, high);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
