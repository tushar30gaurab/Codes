import java.util.*;
public class Knapsack1 {

static int n,w;

    static int solveKnapsack(int wt[], int val[], int w, int n, int table[][])
    {
        for(int i=0;i<n+1;i++)
        {
                for(int j=0;j<w+1;j++)
                {
                    if(i==0 || j==0)
                    table[i][j]=0;

                    else if(wt[i-1]<=j)
                        table[i][j] = Math.max(val[i-1]+table[i-1][j-wt[i-1]], table[i-1][j]);

                    else if(wt[i-1]>j)
                        table[i][j] = table[i-1][j];
                }
        }
        return table[n][w];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements for knapsack: ");
        n = sc.nextInt();
    
        System.out.print("Enter capacity of knapsack: ");
        w = sc.nextInt();
         // Filling values in weight and profit for each items of knapsack
    
            int wt[] = new int [n];
            int val[] = new int [n];
            for(int i=0;i<n;i++)
            {
                System.out.print("Enter weight of item "+(i+1)+": ");
                wt[i] = sc.nextInt();
                System.out.print("Enter profit of item "+(i+1)+": ");
                val[i] = sc.nextInt();
            }
            int table[][] = new int[n+1][w+1];

            for(int i=0;i<n+1;i++)
            {
                for(int j=0;j<w+1;j++)
                {
                    if(w==0 || n==0)
                    table[i][j] = 0;
                }
            }
    
            System.out.println("Solution of this 0/1 Knapsack problem is: "+ solveKnapsack(wt,val,w,n,table));
           sc.close();
            
        }
}
