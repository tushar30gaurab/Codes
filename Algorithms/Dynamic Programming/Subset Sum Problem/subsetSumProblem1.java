import java.util.*;
public class subsetSumProblem1 {        //Tabulation method

    static boolean solveSubset()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter elements of array: ");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the sum: ");
        int sum = sc.nextInt();
        boolean t[][] = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                t[i][j] = false;
                if(j==0)
                t[i][j] = true;
            }
        }

        for(int i=1; i<n+1; i++)
        {
            for(int j=1; j<sum+1; j++)
            {
                if(arr[i-1]<=j)
                t[i][j] = (t[i-1][j-arr[i-1]] || t[i-1][j]);

                if(arr[i-1]>j)
                t[i][j] = t[i-1][j];
            }
        }
        sc.close();
        return t[n][sum];
    }
    public static void main(String[] args) {
        
        System.out.println("Solution: "+solveSubset());
    }
}
