import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Merge Sort Example:");
        System.out.println("Enter the number of inputs:");
        int n=scanner.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements to be sorted");
        for (int i=0;i<n;i++)
            arr[i]=scanner.nextInt();

        System.out.println("The array before sorting");
        for (int num:arr)
        {
            System.out.print(num+" ");
        }
        mergeSort(arr,0,arr.length-1);
        System.out.println("\nThe array after sorting");
        for (int num:arr)
        {
            System.out.print(num+" ");
        }
        scanner.close();
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left<right)
        {
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int leftArraySize=mid-left+1;
        int rightArraySize=right-mid;

        int leftArray[]= new int[leftArraySize];
        int rightArray[]= new int[rightArraySize];

        for (int x=0;x<leftArraySize;x++)
        {
            leftArray[x]=arr[left+x];
        }
        for (int x=0;x<rightArraySize;x++)
        {
            rightArray[x]=arr[mid+1+x];
        }
        int i=0,j=0,k=left;

        while (i<leftArraySize && j<rightArraySize)
        {
            if (leftArray[i]<=rightArray[j])
            {
                arr[k]=leftArray[i];
                i++;
            }else {
                arr[k]=rightArray[j];
                j++;
            }
            k++;
        }
        while (i<leftArraySize)
        {
            arr[k]=leftArray[i];
            i++;
            k++;
        }
        while (j<rightArraySize)
        {
            arr[k]=rightArray[j];
            j++;
            k++;
        }
    }
}
