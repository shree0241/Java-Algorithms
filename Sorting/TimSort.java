import java.util.Arrays;

/**
 * TimSort implementation in Java (simplified version).
 * Hybrid of Insertion Sort + Merge Sort.
 */
public class TimSort {

    private static final int RUN = 32;

    /**
     * Sorts the given array using TimSort.
     */
    public static void timSort(int[] arr) {
        int n = arr.length;

        // Step 1: Sort individual subarrays of size RUN using insertion sort
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + RUN - 1), n - 1));
        }

        // Step 2: Merge sorted subarrays in powers of 2
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), n - 1);

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    /** Insertion sort for subarray arr[left..right] */
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    /** Merge two sorted subarrays arr[left..mid] and arr[mid+1..right] */
    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1, len2 = right - mid;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        System.arraycopy(arr, left, leftArr, 0, len1);
        System.arraycopy(arr, mid + 1, rightArr, 0, len2);

        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }

        while (i < len1) arr[k++] = leftArr[i++];
        while (j < len2) arr[k++] = rightArr[j++];
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19, 10, 1, 3, 8, 2};
        System.out.println("Original array: " + Arrays.toString(arr));

        timSort(arr);
        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }
}
