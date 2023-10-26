import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        int temp=0,i,j,minIndex=-1;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Merge Sort Example:");
        System.out.println("Enter the number of inputs:");
        int n=scanner.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements to be sorted");
        for (i=0;i<n;i++)
            arr[i]=scanner.nextInt();

        System.out.println("The array before sorting");
        for (int num:arr)
        {
            System.out.print(num+" ");
        }

        for (i=0;i<arr.length-1;i++)
        {
            minIndex=i;
            for (j=i+1;j<arr.length;j++)
            {
                if(arr[minIndex]>arr[j])
                {
                    minIndex=j;
                }
            }
            temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }

        System.out.println("\nThe array after sorting");
        for (int num:arr)
        {
            System.out.print(num+" ");
        }
        scanner.close();
    }
}
