import java.util.*;
public class CountSubsetSum1 {

    static int solveCountSubset(int arr[], int sum, int n,int table[][])
    {
        if(sum>0 && n==0)
        return 0;
        if(sum==0)
        return 1;
        if(arr[n-1]<=sum)
            return table[n][sum] = solveCountSubset(arr, sum-arr[n-1], n-1, table) + solveCountSubset(arr, sum, n-1, table);

        else if(arr[n-1]>sum)
            return table[n][sum] = solveCountSubset(arr, sum, n-1, table);

            return table[n][sum];
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements:");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Enter sum:");
        int sum = sc.nextInt();

        int table[][] = new int[n+1][sum+1];
        sc.close();
      System.out.println("Solution: "+solveCountSubset(arr,sum,n,table));
    }
}

