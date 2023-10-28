import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        int i=0;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Insertion Sort Example:");
        System.out.println("Enter the number of inputs:");
        int n=scanner.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements to be sorted");
        for ( i=0;i<n;i++)
            arr[i]=scanner.nextInt();

        System.out.println("The array before sorting");
        for (int num:arr)
        {
            System.out.print(num+" ");
        }

        for(i=0;i<arr.length;i++)
        {
            int key=arr[i];
            int j=i-1;

            while (j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }

        System.out.println("\nThe array after sorting");
        for (int num:arr)
        {
            System.out.print(num+" ");
        }
        scanner.close();
    }
}
