import java.util.*;
public class Knapsack {

static int n,w;

static int solveKnapsack(int wt[], int val[], int w, int n, int table[][])
{
    if(n==0 || w==0)
    return 0;

    if(wt[n-1]<=w)
    {
        return table[n][w] = Math.max(val[n-1] + solveKnapsack(wt,val,w-wt[n-1],n-1,table) , solveKnapsack(wt,val,w,n-1,table));
    }

    else if(wt[n-1]>w){
        return table[n][w] = solveKnapsack(wt,val,w,n-1,table);
    }

    return table[n][w];
}

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no of elements for knapsack:");
    n = sc.nextInt();

    System.out.println("Enter capacity of knapsack:");
    w = sc.nextInt();
     // Filling values in weight and profit for each items of knapsack

        int wt[] = new int [n];
        int val[] = new int [n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter weight of item "+(i+1));
            wt[i] = sc.nextInt();
            System.out.println("Enter profit of item "+(i+1));
            val[i] = sc.nextInt();
        }
        int table[][] = new int[n+1][w+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<w+1;j++)
            {
                table[i][j] = -1;
            }
        }

        System.out.println("Solution of this 0/1 Knapsack problem is: "+ solveKnapsack(wt,val,w,n,table));
       
        
    }
}
