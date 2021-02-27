import java.util.*;
public class CoinChange1
{

    static int solveCoinChangeProblem(int arr[], int n, int sum, int t[][])
    {
        if(n==0)
            return t[n][sum] = Integer.MAX_VALUE-1;
        if(sum==0)
            return t[n][sum] = 0;
        if(arr[n-1]<=sum)
            return t[n][sum] = Math.min(1+solveCoinChangeProblem(arr, n, sum-arr[n-1], t) , solveCoinChangeProblem(arr, n-1, sum, t));
        else if(arr[n-1]>sum)
            return t[n][sum] = solveCoinChangeProblem(arr, n-1, sum, t);
        
            return t[n][sum];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Enter sum:");
        int sum = sc.nextInt();
        int t[][] = new int[n+1][sum+1];
        System.out.println("Solution: "+solveCoinChangeProblem(arr,n,sum,t));
        sc.close();
    }
}