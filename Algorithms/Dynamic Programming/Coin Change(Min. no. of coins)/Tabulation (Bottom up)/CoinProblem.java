import java.util.*;
public class CoinProblem {

    static int solveCoinProblem(int arr[], int n, int sum)
    {
        int table[][] = new int[n+1][sum+1];
        for(int i=0;i<sum+1;i++)
            table[0][i]=Integer.MAX_VALUE-1;

        for(int i=1;i<n+1;i++)
            table[i][0] = 0;
        
        for(int i=1;i<sum+1;i++){
            if(i%arr[0]==0)
                table[1][i] = i/arr[0];
            else
                table[1][i] = Integer.MAX_VALUE-1;

        }

            for(int i=2;i<n+1;i++)
            {
                for(int j=1;j<sum+1;j++)
                {
                    if(arr[i-1]<=j)
                        table[i][j] = Math.min(1+table[i][j-arr[i-1]],table[i-1][j]);
                    else if(arr[i-1]>j)
                        table[i][j] = table[i-1][j];
                }
            }

            return table[n][sum];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Enter Sum:");
        int sum = sc.nextInt();

        sc.close();
        System.out.println("Solution: "+solveCoinProblem(arr,n,sum));
    }    
}
