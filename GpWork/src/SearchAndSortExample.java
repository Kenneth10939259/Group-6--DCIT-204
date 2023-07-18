import java.util.Arrays;
import java.util.Scanner;

public class SearchAndSortExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to search: ");
        int target = scanner.nextInt();

        System.out.print("Choose search type (linear/binary): ");
        String searchType = scanner.next();

        long startTime = System.currentTimeMillis();
        int index;
        if (searchType.equalsIgnoreCase("linear")) {
            index = linearSearch(arr, target);
        } else if (searchType.equalsIgnoreCase("binary")) {
            Arrays.sort(arr);
            index = binarySearch(arr, target);
        } else {
            System.out.println("Invalid search type selected.");
            return;
        }
        long endTime = System.currentTimeMillis();

        if (index == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + index);
        }

        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

        System.out.print("Choose sorting algorithm (bubble/selection/insertion/merge/quick): ");
        String sortAlgorithm = scanner.next();

        startTime = System.currentTimeMillis();
        if (sortAlgorithm.equalsIgnoreCase("bubble")) {
            bubbleSort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("selection")) {
            selectionSort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("insertion")) {
            insertionSort(arr);
        } else if (sortAlgorithm.equalsIgnoreCase("merge")) {
            mergeSort(arr, 0, arr.length - 1);
        } else if (sortAlgorithm.equalsIgnoreCase("quick")) {
            quickSort(arr, 0, arr.length - 1);
        } else {
            System.out.println("Invalid sorting algorithm selected.");
            return;
        }
        endTime = System.currentTimeMillis();

        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }

    private static void quickSort(int[] arr, int i, int i1) {
    }

    private static void mergeSort(int[] arr, int i, int i1) {
    }

    private static void insertionSort(int[] arr) {
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
