public class CombSort {

    public void sort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};
        CombSort cs = new CombSort();
        cs.sort(arr);
        System.out.println("Sorted array is:");
        for (int num : arr)
            System.out.print(num + " ");
    }
}
