import java.text.DecimalFormat;

public class Algorithms {

    public static void elapsed(long start, String what) {
        long end = System.currentTimeMillis();
        DecimalFormat df = new DecimalFormat("#0.00000");
        System.out.printf("%s took %s\n", what, df.format(((end - start) / 1000d)) + "ms");
    }

    public static String printArray(int[] arr) {
        String result = "[";
        for (int current : arr) {
            result += current + ", ";
        }
        result = result.substring(0, result.length() - 2);
        return result += "]";
    }

    public static String reverseString(String str) {
        int length = str.length() - 1;
        String reverse = "";
        for (int i = 0; i < str.length(); i++) {
            reverse += str.charAt(length - i);
        }
        return reverse;
    }

    public static boolean isPalindrome(String str) {
        int length = str.length() - 1;
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }

    public static int linearSearch(int key, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int key, int[] arr) {
        int min = 0, mid = 0;
        int max = arr.length;
        while (true) {
            mid = (max + min) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (max <= min) {
                return -1;
            }
            if (arr[mid] < key) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        int tmp;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
                System.out.println("Iteration " + i + ": " + printArray(arr));
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int min, tmp;
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
            System.out.println("Iteration " + i + ": " + printArray(arr));
        }
    }

    public static void doubleSelectionSort(int[] arr) {
        int min, max, oldMax, tmp;
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            min = i;
            oldMax = length - i - 1;
            max = oldMax;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                if (arr[length - j] > arr[max] && (min != max)) {
                    max = length - j;
                }
            }
            if (min != i) {
                tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
            if (max != oldMax) {
                tmp = arr[oldMax];
                arr[oldMax] = arr[max];
                arr[max] = tmp;
            }
            System.out.println("Iteration " + i + ": " + printArray(arr));
        }
    }

    public static void insertionSort(int[] arr) {
        int tmp;
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
            System.out.println("Iteration " + i + ": " + printArray(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr;
        String str;
        long start;

        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        System.out.println("Sorted Array: " + printArray(arr));
        System.out.println("\nBinary Search");
        start = System.currentTimeMillis();
        System.out.println("Key Index: " + binarySearch(10, arr));
        elapsed(start, "Binary Search");
        System.out.println();

        arr = new int[] { 3, 1, 4, 2, 6, 5, 8, 7, 10, 9 };
        System.out.println("Array: " + printArray(arr));
        System.out.println("\nLinear Search");
        start = System.currentTimeMillis();
        System.out.println("Key Index: " + linearSearch(6, arr));
        elapsed(start, "Linear Search");

        System.out.println("\nBubble Sort");
        start = System.currentTimeMillis();
        bubbleSort(arr);
        System.out.println(printArray(arr));
        elapsed(start, "Bubble Sort");

        arr = new int[] { 3, 1, 4, 2, 6, 5, 8, 7, 10, 9 };
        System.out.println("\nSelection Sort");
        start = System.currentTimeMillis();
        selectionSort(arr);
        System.out.println(printArray(arr));
        elapsed(start, "Selection Sort");

        arr = new int[] { 3, 1, 4, 2, 6, 5, 8, 7, 10, 9 };
        System.out.println("\nDouble Selection Sort");
        start = System.currentTimeMillis();
        doubleSelectionSort(arr);
        System.out.println(printArray(arr));
        elapsed(start, "Double Selection Sort");

        arr = new int[] { 3, 1, 4, 2, 6, 5, 8, 7, 10, 9 };
        System.out.println("\nInsertion Sort");
        start = System.currentTimeMillis();
        insertionSort(arr);
        System.out.println(printArray(arr));
        elapsed(start, "Insertion Sort");

        str = "Omar loves Tuffy so much";
        System.out.println("\nReverse String");
        start = System.currentTimeMillis();
        System.out.println(reverseString(str));
        elapsed(start, "Reverse String");

        str = "ANBBNA";
        System.out.println("\nPalindrome String");
        start = System.currentTimeMillis();
        System.out.println(str + ": " + isPalindrome(str));
        elapsed(start, "Palindrome String");
    }

}