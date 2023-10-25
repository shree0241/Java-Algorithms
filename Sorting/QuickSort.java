import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Quick Sort Example:");
        System.out.println("Enter the number of inputs:");
        int n=scanner.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements to be sorted");
        for (int i=0;i<n;i++)
            arr[i]=scanner.nextInt();

        System.out.println("The array before sorting");
        for (int num:arr)
        {
            System.out.print(num+" ");
        }
        quickSort(arr,0,arr.length-1);
        System.out.println("The array after sorting");
        for (int num:arr)
        {
            System.out.print(num+" ");
        }

    }
    private static void quickSort(int[] arr, int low, int high) {
        if (low<high)
        {
            int pivot=partition(arr,low,high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot=arr[high];
        int i=low-1;

        for (int j=low;j<high;j++)
        {
            if(arr[j]<pivot)
            {
                i++;
                swapArrayElements(arr,i,j);
            }
        }
        swapArrayElements(arr,i+1,high);
        return i+1;
    }

    private static void swapArrayElements(int[] arr,int x,int y)
    {
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;

    }
}
