import java.util.*;
public class CountSubsetSum {

    static int solveCountSubset(int arr[], int sum, int n,int table[][])
    {
        for(int i=1;i<n+1;i++)
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                    table[i][j] = table[i-1][j-arr[i-1]] + table[i-1][j];

                else if(arr[i-1]>j)
                    table[i][j] = table[i-1][j];
            }

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
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0)
                 table[i][j ]= 0; 
                if(j==0)
                 table[i][j] = 1;
            }
        }
        sc.close();
      System.out.println("Solution: "+solveCountSubset(arr,sum,n,table));
    }
}

