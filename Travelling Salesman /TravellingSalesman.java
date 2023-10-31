import java.util.Scanner;

public class TravellingSalesman {
    static int[][] costMatrix=new int[100][100];
    static boolean[] visited_copy=new boolean[100];
    static int number_of_vertices,current_vertex,total_min_cost=0,i,j;



    public static void inputs()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of Cities");
        number_of_vertices=scanner.nextInt();
        System.out.println("Enter the starting vertex");
        current_vertex=scanner.nextInt();
        for (i=0;i<number_of_vertices;i++)
        {
            for (j=0;j<number_of_vertices;j++)
            {
                if (i==j)
                {
                    costMatrix[i][j]=0;
                }
                else {
                    System.out.println("Enter the cost between the paths "+(i+1)+"-->"+(j+1)+": ");
                    costMatrix[i][j]=scanner.nextInt();
                }
            }
        }

        System.out.println("\nCost Matrix");
        for (i=0;i<number_of_vertices;i++)
        {
            for (j=0;j<number_of_vertices;j++)
            {
                System.out.print(costMatrix[i][j]+"    ");
            }
            System.out.println();
        }

    }

    public  static int next_visit(int c_vertex)
    {
        int MIN=Integer.MAX_VALUE;
        int cost_spent=0,next_vertex=Integer.MAX_VALUE;

        for (i=0;i<number_of_vertices;i++)
        {
            if (costMatrix[c_vertex-1][i]!=0 && !visited_copy[i])
            {
                if (costMatrix[c_vertex-1][i]+costMatrix[i][c_vertex-1]<MIN)
                {
                    MIN=costMatrix[c_vertex-1][i]+costMatrix[i][c_vertex-1];
                    cost_spent=costMatrix[c_vertex-1][i];
                    next_vertex=i;
                }
            }
        }
        if (MIN!=Integer.MAX_VALUE)
        {
            total_min_cost+=cost_spent;
        }
        return next_vertex+1;
    }

    public static void shortest_distance(int c_vertex)
    {
        visited_copy[c_vertex-1]=true;
        System.out.print(c_vertex+" ---> ");
        int nxt_visit=next_visit(c_vertex);
        if (nxt_visit==Integer.MAX_VALUE+1)
        {
            System.out.print(current_vertex);
            total_min_cost+=costMatrix[c_vertex-1][current_vertex-1];
            return;
        }
        shortest_distance(nxt_visit);
    }

    public static void main(String[] args) {
        inputs();
        System.out.println("Salesman's path ");
        shortest_distance(current_vertex);
        System.out.println();
        System.out.println("Tour cost: "+total_min_cost);
    }

}
