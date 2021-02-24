import java.util.*;
public class CoinChange {
    static int solveCoinChange(int arr[], int n, int sum, int t[][])
    {
        if(sum==0)
        return 1;
        if(sum<0)
        return 0;
        if(n<=0 && sum>=1)
        return 0;
        if(arr[n-1]<=sum)
            return t[n][sum] = (solveCoinChange(arr, n, sum-arr[n-1], t) + solveCoinChange(arr, n-1, sum, t));
        else if(arr[n-1]>sum)
            return t[n][sum] = (solveCoinChange(arr, n-1, sum, t));

        return t[n][sum];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter sum:");
        int sum = sc.nextInt();
        int t[][] = new int[n+1][sum+1];
        System.out.println("Total no of ways to perform Coin Change: "+solveCoinChange(arr,n,sum,t));
        sc.close();
    }
    
}
