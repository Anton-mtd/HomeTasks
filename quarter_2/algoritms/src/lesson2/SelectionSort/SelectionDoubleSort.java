package lesson2.SelectionSort;

public class SelectionDoubleSort {
    public static void sort(Integer[] arr) {

        for (int i = 0; i < arr.length / 2; i++) {
            int leftValue = i;
            int rightValue = arr.length - 1 - i;
            int indexMinValue = leftValue;
            int indexMaxValue = rightValue;


            for (int j = i + 1; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[indexMinValue]) {
                    indexMinValue = j;
                } else if (arr[j] > arr[indexMaxValue]) {
                    indexMaxValue = j;
                }
            }

            if (arr[indexMinValue] > arr[rightValue] && arr[indexMaxValue] < arr[leftValue]) {
                indexMaxValue = leftValue;
                indexMinValue = rightValue;
                swap(arr, indexMaxValue, indexMinValue);
            } else if (arr[indexMinValue] > arr[rightValue]) {
                indexMinValue = rightValue;
                swap(arr, indexMinValue, leftValue);
                swap(arr, rightValue, indexMaxValue);
            } else if (arr[indexMaxValue] < arr[leftValue]) {
                indexMaxValue = leftValue;
                swap(arr, indexMaxValue, rightValue);
                swap(arr, leftValue, indexMinValue);
            } else {
                swap(arr, leftValue, indexMinValue);
                swap(arr, rightValue, indexMaxValue);
            }
        }
    }

    private static void swap(Integer[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
