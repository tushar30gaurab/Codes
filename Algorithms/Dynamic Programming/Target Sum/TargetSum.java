import java.util.*;
public class TargetSum {

    static int countsubset(int arr[], int sum, int n)
    {
        int t[][] = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                t[i][j] = 0;
                if(j==0)
                t[i][j] = 1;
            }
        }

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];

                else if(arr[i-1]>j)
                t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        int summ=0;
        System.out.println("Enter elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            summ+=arr[i];
        }
        System.out.println("Enter difference: ");
        int diff = sc.nextInt();
        int s = (summ+diff)/2;

        System.out.println("Solution: "+countsubset(arr, s, n));
        sc.close();
    }
}
