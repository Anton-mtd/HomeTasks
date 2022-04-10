package lesson2.SelectionSort;

public class SelectionSort {
    public static void sort(Integer[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int indexMinValue = i;

            for (int j = 1 + i; j < arr.length; j++) {

                if (arr[j] < arr[indexMinValue]) {
                    indexMinValue = j;
                }

            }
            int tempMin = arr[i];
            arr[i] = arr[indexMinValue];
            arr[indexMinValue] = tempMin;
        }
    }
}
