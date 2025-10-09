import java.util.*;

public class BucketSort {

    public void sort(float[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;

        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new List[n];
        for (int i = 0; i < n; i++)
            buckets[i] = new ArrayList<>();

        for (float value : arr) {
            int bucketIndex = (int) (value * n);
            buckets[bucketIndex].add(value);
        }

        for (List<Float> bucket : buckets)
            Collections.sort(bucket);

        int index = 0;
        for (List<Float> bucket : buckets)
            for (float value : bucket)
                arr[index++] = value;
    }

    public static void main(String[] args) {
        float[] arr = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};
        BucketSort bs = new BucketSort();
        bs.sort(arr);
        System.out.println("Sorted array is:");
        for (float num : arr)
            System.out.print(num + " ");
    }
}
