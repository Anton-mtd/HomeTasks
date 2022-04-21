package lesson3;


public class SearchMissNumber {

    public static int searchMissNumber(Integer[] arr) {

        if (arr.length == 0) {
            return 1;
        }

        int baseIndex;
        int startIndex = 0;
        int endIndex = arr.length - 1;

        if (endIndex - startIndex == arr[endIndex] - arr[startIndex]) {
            if (arr[startIndex] != 1) {
                return 1;
            } else {
                return arr[endIndex] + 1;
            }
        } else {
            do {
                baseIndex = startIndex + (endIndex - startIndex) / 2;

                if (arr[baseIndex] != arr[startIndex] + ((baseIndex - startIndex))) {
                    endIndex = baseIndex;
                } else {
                    startIndex = baseIndex;
                }
            } while (endIndex - startIndex != 1);
            return arr[endIndex] - 1;
        }
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        Integer[] arr1 = new Integer[]{1, 2, 4, 5, 6};
        Integer[] arr2 = new Integer[]{2, 3, 4, 5, 6, 7, 8};
        Integer[] arr3 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Integer[] arr4 = new Integer[]{};

        System.out.println(searchMissNumber(arr));
        System.out.println(searchMissNumber(arr1));
        System.out.println(searchMissNumber(arr2));
        System.out.println(searchMissNumber(arr3));
        System.out.println(searchMissNumber(arr4));
    }
}
