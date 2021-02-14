import java.util.*;
public class equalSumParttion1 {         //Tabulation code

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
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0)
                t[i][j] = true;
                if(j==0)
                t[i][j] = false;
            }
        }
        if(sum%2!=0)
        flag=false;

        if(sum%2==0)
        flag = solveEqualSum(arr,sum/2,n,t);

        return flag;
    }

    static boolean solveEqualSum(int arr[], int sum, int n, boolean t[][])
    {
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j)
                    return t[i][j] = t[n-1][j-arr[i-1]] || t[i-1][j];

                else if(arr[i-1]>j)
                    return t[i][j] = t[i-1][j];
            }
        }

            return t[n][sum];

    }
    public static void main(String[] args) {
        System.out.println("Equal Sum Partition possible: "+solve());
    }
    
}
