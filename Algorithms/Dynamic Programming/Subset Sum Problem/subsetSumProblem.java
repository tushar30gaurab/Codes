import java.util.*;
public class subsetSumProblem {
    static int n,sum;

static boolean solvesubset(int arr[], int sum, int n, boolean table[][])
{
    if(sum>0 && n==0)
        return false;
    if(sum==0 && n==0)
        return true;

    if(arr[n-1]<=sum)
    return table[n][sum] = (solvesubset(arr, sum-arr[n-1], n-1, table) || solvesubset(arr, sum, n-1, table));

    else if(arr[n-1]>sum)
    return table[n][sum] = solvesubset(arr, sum, n-1, table);

    return table[n][sum];
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements of array:");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter the sum: ");
        sum = sc.nextInt();
        boolean table[][] = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                table[i][j] = false;
            }
        }
        System.out.print("Solution of Subset Sum present: " + solvesubset(arr,sum,n,table));
    }
}
