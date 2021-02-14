import java.util.*;
public class equalSumParttion {

    static boolean solve()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        boolean flag = false;

        System.out.println("Enter elements:");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum = sum+arr[i];
        }

        boolean t[][] = new boolean[n+1][sum+1];
        if(sum%2!=0)
        flag=false;

        if(sum%2==0)
        flag = solveEqualSum(arr,sum/2,n,t);

        return flag;
    }

    static boolean solveEqualSum(int arr[], int sum, int n, boolean t[][])
    {
        if(sum>0 && n==0)
        return false;

        if(sum==0)
        return true;

        if(arr[n-1]<=sum)
            return t[n][sum] = (solveEqualSum(arr, sum-arr[n-1], n-1, t) || solveEqualSum(arr, sum, n-1, t));

        else if(arr[n-1]>sum)
            return t[n][sum] = solveEqualSum(arr, sum, n-1, t);

            return t[n][sum];

    }
    public static void main(String[] args) {
        System.out.println("Equal Sum Partition possible: "+solve());
    }
    
}
