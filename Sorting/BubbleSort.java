import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        int temp=0,i,j,minIndex=-1;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Bubble Sort Example:");
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
            for (j=i+1;j<arr.length;j++)
            {
                if (arr[i]>arr[j])
                {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        
        System.out.println("The array after sorting");
        for (int num:arr)
        {
            System.out.print(num+" ");
        }
    }
}
